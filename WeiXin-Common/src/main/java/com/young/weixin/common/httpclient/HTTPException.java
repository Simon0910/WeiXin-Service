package com.young.weixin.common.httpclient;


public class HTTPException extends Exception {

	private static final long serialVersionUID = -6090056941317354998L;
	private final int statusCode;
    private final String reason;

    public HTTPException(final int statusCode, final String reason) {
        super("HTTP statusCode: " + statusCode + ", reasons: " + reason);
        this.reason = reason;
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReason() {
        return reason;
    }
}
