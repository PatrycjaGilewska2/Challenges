package project.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlReader {

    private UrlReader() {
    }

    public static String readFromUrl(String url) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        try (InputStream in = new URL(url).openStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

}
