package webserver.http.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webserver.http.common.header.HeaderType;
import webserver.http.common.header.HeaderTypeFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.lineSeparator;

public class HttpParser {

    private static final Logger logger = LoggerFactory.getLogger(HttpParser.class);

    public static String readHttpHeader(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            if (line.isEmpty()) {
                break;
            }
            sb.append(line).append(lineSeparator());
        }
        return sb.toString().trim();
    }

    public static Map<HeaderType, String> parseHeaderMap(String headerString) {
        Map<HeaderType, String> headerMap = new HashMap<>();
        String[] headers = headerString.split(System.lineSeparator());
        for (String header : headers) {
            HeaderType key = HeaderTypeFactory.createHeaderType(header.split(HttpRequestParser.HEADER_SEPARATOR_REGEX)[HttpRequestParser.KEY_INDEX]);
            if (key == null) {
                continue;
            }
            String value = header.split(HttpRequestParser.HEADER_SEPARATOR_REGEX)[HttpRequestParser.VALUE_INDEX];
            headerMap.put(key, value);
        }
        return headerMap;
    }

    public static String readMessageBody(BufferedReader br, int contentLength) throws IOException {
        char[] buf = new char[contentLength];
        br.read(buf, 0, contentLength);
        return String.valueOf(buf);
    }
}