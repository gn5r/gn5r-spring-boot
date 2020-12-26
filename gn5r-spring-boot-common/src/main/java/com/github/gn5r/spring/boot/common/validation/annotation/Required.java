package com.github.gn5r.spring.boot.common.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.github.gn5r.spring.boot.common.validation.RequiredValidation;

/**
 * 必須項目バリデーションアノテーション
 *
 * @author gn5r
 */
@Documented
@Constraint(validatedBy = { RequiredValidation.class })
@Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Required.List.class)
public @interface Required {

    String message() default "{com.gn5r.spring.boot.common.validation.Required.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Documented
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List {
        Required[] value();
    }
}