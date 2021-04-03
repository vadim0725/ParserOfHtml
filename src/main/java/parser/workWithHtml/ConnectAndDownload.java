package parser.workWithHtml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parser.ConsoleHelper;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class ConnectAndDownload {
        private static final Logger logger = LoggerFactory.getLogger(ConnectAndDownload.class);

        public boolean connectForDownload(URL myUrl, String fileName) {
                HttpsURLConnection con = null;
                try {
                        SSLContext sc = SSLContext.getInstance("SSL");
                        sc.init(null, trustAllCerts, new java.security.SecureRandom());
                        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                        con = (HttpsURLConnection) myUrl.openConnection();
                        con.addRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0");
                        if (con.getContentLength() == -1) {
                                ConsoleHelper.print("Некорректный адрес web-страницы, попробуйте повторно.");
                                return false;
                        }
                } catch (IOException | ClassCastException e) {
                        logger.error(e.getMessage(), e);
                        ConsoleHelper.print("Ошибка при попытке соединения с сетью.");
                } catch (NoSuchAlgorithmException | KeyManagementException e) {
                        logger.error(e.getMessage(), e);
                }
                if (con != null) {
                        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                             BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                                String inputLine;
                                while ((inputLine = in.readLine()) != null) {
                                        bw.write(inputLine);
                                }
                                return true;
                        } catch (IOException e) {
                                ConsoleHelper.print("Ошибка при попытке записать файл на диск.");
                                logger.error(e.getMessage(), e);
                        }
                }
                return false;
        }

        TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return null;
                        }
                        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                        }
                        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                        }
                }
        };
}
