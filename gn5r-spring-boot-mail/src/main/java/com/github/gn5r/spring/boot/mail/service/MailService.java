package com.github.gn5r.spring.boot.mail.service;

import com.github.gn5r.spring.boot.mail.exception.MailRuntimeException;
import com.github.gn5r.spring.boot.mail.model.MailModel;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import lombok.extern.slf4j.Slf4j;

/**
 * メール送信に関係するメソッドを実装したクラス
 * 
 * @author gn5r
 */
@Slf4j
public class MailService {

    @Autowired
    private MailSender mailSender;

    /**
     * メール送信する
     * 
     * @param model メール送信モデル
     */
    public void send(@NonNull MailModel model) {
        this.checkModel(model);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(model.getFrom());
        message.setTo(model.getTo());
        message.setCc(model.getCc());
        message.setBcc(model.getBcc());
        message.setSubject(model.getSubject());
        message.setText(this.getBody(model));

        mailSender.send(message);
    }

    /**
     * メールモデルやパラメータのnullチェック
     * 
     * @param model メールモデル
     */
    private final void checkModel(MailModel model) {
        if (model == null) {
            throw new MailRuntimeException("メールモデルがnullです");
        }

        if (StringUtils.isEmpty(model.getFrom())) {
            throw new MailRuntimeException("Fromアドレスが設定されていません");
        }

        if (StringUtils.isAllEmpty(model.getTo())) {
            throw new MailRuntimeException("Toアドレスが設定されていません");
        }
    }

    /**
     * Thymeleafテンプレートを使用したメール本文を取得する
     * 
     * @param model メールモデル
     * @return メール本文
     */
    private final String getBody(MailModel model) {
        if (model.getBody() == null) {
            throw new MailRuntimeException("メール本文が設定されていません");
        }
        log.debug(model.toString());
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.TEXT);
        templateResolver.setCharacterEncoding("UTF-8");

        SpringTemplateEngine engine = new SpringTemplateEngine();
        Context context = new Context();
        if (model.getContext() != null) {
            templateResolver = new ClassLoaderTemplateResolver(Thread.currentThread().getContextClassLoader());
            context = model.getContext();
        }
        engine.setTemplateResolver(templateResolver);

        context.setVariables(model.getBody().toMap());
        String template = model.getFormPath();
        if (StringUtils.isEmpty(template)) {
            template = "/templates/MAIL/sample.txt";
        }
        return engine.process(template, context);
    }
}
