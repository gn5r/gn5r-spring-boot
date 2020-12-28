package com.github.gn5r.spring.boot.mail.model;

import java.time.LocalDateTime;

/**
 * サンプルメールボディ
 * 
 * @author gn5r
 */
public class MailBody extends MailBodyModel {

    private String sendTime;

    private String text;

    @Override
    public void setSendTime(LocalDateTime sendTime) {
        this.sendTime = sendTime.format(YMD_HMS);
    }

    @Override
    public String getSendTime() {
        return this.sendTime;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }

}
