package com.WS.Controllers;

import java.util.Date;

public class Token {
    private String text;
    private Date expiration;

    public Token(String text, Date expiration) {
        this.text = text;
        this.expiration = expiration;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}
