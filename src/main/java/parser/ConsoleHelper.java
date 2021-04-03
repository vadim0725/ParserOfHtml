package parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ConsoleHelper {
    private static final Logger logger = LoggerFactory.getLogger(ConsoleHelper.class);
    public static void print(String message) {
        System.out.println(message);
    }

    public static String consoleWrite() {
        String write = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                write = bufferedReader.readLine();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            System.out.println("Произошла ошибка при попытке ввода данных. Попробуйте еще раз.");
        }
        return write;
    }

    public static URL consoleWriteUrl() {
        ConsoleHelper.print("Введите веб-адресс:");
        String httpURL = consoleWrite().trim();
        URL myUrl = null;
        try {
            myUrl = new URL(httpURL);
        } catch (MalformedURLException e) {
            logger.error(e.getMessage(), e);
            ConsoleHelper.print("Неверный формат веб-адресса. Попробуйте повторно.");
        }
        return myUrl;
    }
}
