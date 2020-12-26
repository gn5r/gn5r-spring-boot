package com.github.gn5r.spring.boot.common.autoconfigure;

import com.github.gn5r.spring.boot.common.properties.AuthHeaderProperty;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 独自プロパティのBeanを自動登録するConfigクラス
 * 
 * @author gn5r
 */
@Configuration
public class PropertiesAutoConfiguration {

    /**
     * リクエストヘッダーからユーザー情報を取得するためのキー値を設定したプロパティ
     * 
     * @return AuthHeaderProperty
     * @see AuthHeaderProperty
     */
    @Bean
    public AuthHeaderProperty authHeaderProperty() {
        return new AuthHeaderProperty();
    }
}
