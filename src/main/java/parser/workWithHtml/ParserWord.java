package parser.workWithHtml;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserWord {
    private String splitter = "[\\p{Punct}\\d\\s]+";
    public Map<String, Long> parseWords(String words) {
        Map<String, Long> cntMap;
            cntMap = Stream.of(words)
                    .flatMap(l -> Stream.of(l.split(splitter)))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            return cntMap;
    }

    public void printWord(Map<String, Long> cntMap) {
        for (Map.Entry<String, Long> entry: cntMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
