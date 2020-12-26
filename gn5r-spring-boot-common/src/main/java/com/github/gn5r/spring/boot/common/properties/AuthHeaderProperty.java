package com.github.gn5r.spring.boot.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = AuthHeaderProperty.AUTH_PREFIX)
public class AuthHeaderProperty {

    /**
     * プロパティのprefixをstatic変数に格納
     */
    public static final String AUTH_PREFIX = "application.auth.header";

    /**
     * <p>
     * REST通信においてユーザー情報を格納するリクエストヘッダーのキー値
     * </p>
     */
    private String key = "X-AUTH-ID";

    /**
     * <p>ユーザー情報を格納するリクエストヘッダーのキー値を取得する</p>
     * 
     * @return リクエストヘッダーキー値
     */
    public final String getKey() {
        return this.key;
    }
}
