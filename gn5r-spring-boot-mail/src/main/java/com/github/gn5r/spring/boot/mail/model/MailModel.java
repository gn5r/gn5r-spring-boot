package com.github.gn5r.spring.boot.mail.model;

import org.thymeleaf.context.Context;

import lombok.Data;

/**
 * メール送信用モデルクラス
 */
@Data
public class MailModel {

    private String from;
    private String[] to;
    private String[] cc;
    private String[] bcc;
    private String subject;
    private MailBodyModel body;
    private String formPath;
    private Context context;

    /**
     * 送信先アドレスをセットする
     * 
     * @param to 送信先アドレス
     */
    public void setTo(String... to) {
        this.to = to;
    }

    /**
     * CCアドレスをセットする
     * 
     * @param cc CCアドレス
     */
    public void setCc(String... cc) {
        this.cc = cc;
    }

    /**
     * BCCアドレスをセットする
     * 
     * @param bcc BCCアドレス
     */
    public void setBcc(String... bcc) {
        this.bcc = bcc;
    }

    /**
     * メール本文をセットする
     * 
     * @param <B>  MailBodyModelを継承したクラスの型
     * @param body メール本文モデル
     * 
     * @see MailBodyModel
     */
    public <B extends MailBodyModel> void setBody(B body) {
        this.body = body;
    }
}
