package com.github.gn5r.spring.boot.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * URLロギングスキップアノテーション
 * </p>
 * <p>
 * {@link URLConsoleInterceptor} 内でロギングするかの判断に使用。コントローラー/メソッド毎に個別指定することも可能
 * </p>
 * 
 * @author gn5r
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NoURLConsole {

}
