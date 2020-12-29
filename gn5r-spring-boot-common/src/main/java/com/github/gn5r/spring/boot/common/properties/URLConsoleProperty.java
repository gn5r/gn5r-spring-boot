package com.github.gn5r.spring.boot.common.properties;

import com.github.gn5r.spring.boot.common.interceptor.URLConsoleInterceptor;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * URLロギング有効/無効プロパティ
 * </p>
 * <p>
 * {@link URLConsoleInterceptor} にて使用
 * </p>
 * 
 * @author gn5r
 */
@ConfigurationProperties(prefix = URLConsoleProperty.CONSOLE_PREFIX)
public class URLConsoleProperty {

    /**
     * プロパティのprefix
     */
    public static final String CONSOLE_PREFIX = "application.url.console";

    /**
     * URLロギング一括有効/無効フラグ
     */
    private boolean enable = true;

    /**
     * URLロギング有効/無効フラグを取得する
     * 
     * @return URLロギング一括有効/無効フラグ
     */
    public boolean isEnable() {
        return this.enable;
    }
}
