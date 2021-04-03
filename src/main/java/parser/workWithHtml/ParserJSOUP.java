package parser.workWithHtml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parser.ConsoleHelper;

import java.io.File;
import java.io.IOException;

public class ParserJSOUP {
    private static final Logger logger = LoggerFactory.getLogger(ParserJSOUP.class);

    public String parseWeb(String path){
        Document doc = null;
        try {
            doc = Jsoup.parse(new File(path), "UTF-8");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            ConsoleHelper.print("Ошибка при парсинге HTML страницы, попробуйте еще раз.");
        }
        Elements paragraphs = doc.select("body");
        Element firstParagraph = paragraphs.first();
        Element p;
        p = firstParagraph;
        return p.text();
    }
}
