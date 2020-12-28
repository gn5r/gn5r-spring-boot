package com.github.gn5r.spring.boot.mail.autoconfigure;

import com.github.gn5r.spring.boot.mail.service.MailService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@link MailService} を自動登録するクラス
 * 
 * @author gn5r
 */
@Configuration
public class MailServiceAutoConfiguration {

    @Bean
    public MailService mailService() {
        return new MailService();
    }
}
