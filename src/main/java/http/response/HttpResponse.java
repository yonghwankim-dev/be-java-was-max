package http.response;

import http.common.header.HeaderType;
import http.response.component.ResponseHeader;
import http.response.component.StatusLine;
import java.util.HashMap;
import java.util.Optional;

public class HttpResponse {

    private StatusLine statusLine;
    private ResponseHeader responseHeader;
    private byte[] messageBody;

    public HttpResponse() {
        this.statusLine = null;
        this.responseHeader = new ResponseHeader(new HashMap<>());
        this.messageBody = new byte[0];
    }

    public HttpResponse(StatusLine statusLine, ResponseHeader responseHeader, byte[] messageBody) {
        this.statusLine = statusLine;
        this.responseHeader = responseHeader;
        this.messageBody = messageBody;
    }

    public void addHeader(HeaderType key, String value) {
        responseHeader.put(key, value);
    }

    public byte[] getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(byte[] messageBody) {
        this.messageBody = messageBody;
    }

    public Optional<String> get(HeaderType key) {
        return responseHeader.get(key);
    }

    public StatusLine getStatusLine() {
        return statusLine;
    }

    public void setStatusLine(StatusLine statusLine) {
        this.statusLine = statusLine;
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    @Override
    public String toString() {
        return String.format("%s\r\n%s\r\n\r\n", statusLine, responseHeader);
    }
}
