package com.github.gn5r.spring.boot.mail.exception;

import org.springframework.mail.MailException;

/**
 * 独自例外クラス
 * 
 * @author gn5r
 */
public class MailRuntimeException extends MailException {

    private static final long serialVersionUID = 1L;

    public MailRuntimeException(String msg) {
        super(msg);
    }

    public MailRuntimeException(String msg, Throwable t) {
        super(msg, t);
    }
}
