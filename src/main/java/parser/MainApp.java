package parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parser.workWithHtml.ConnectAndDownload;
import parser.workWithHtml.ParserJSOUP;
import parser.workWithHtml.ParserWord;

import java.net.URISyntaxException;
import java.net.URL;

public class MainApp {
    private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        URL myUrl = ConsoleHelper.consoleWriteUrl();
        if (myUrl != null) {
            String fileName = null;
            try {
                fileName = "target/" + myUrl.toURI().getAuthority() + ".html";
            } catch (URISyntaxException e) {
                logger.error(e.getMessage(), e);
            }
            if (new ConnectAndDownload().connectForDownload(myUrl, fileName)) {
                ParserWord parserWord = new ParserWord();
                String text = new ParserJSOUP().parseWeb(fileName);
                if (text != null)
                    parserWord.printWord(parserWord.parseWords(text));
            }
        }
    }
}
