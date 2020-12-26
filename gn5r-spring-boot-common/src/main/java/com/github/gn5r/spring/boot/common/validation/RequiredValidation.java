package com.github.gn5r.spring.boot.common.validation;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.github.gn5r.spring.boot.common.validation.annotation.Required;

/**
 * {@link Required}用バリデーションクラス
 *
 * @author gn5r
 */
public class RequiredValidation implements ConstraintValidator<Required, Object> {

    private String message;

    @Override
    public void initialize(Required annotation) {
        this.message = annotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (!Objects.isNull(value)) {
            // Stringかチェックする
            if (value instanceof String) {
                if (!Objects.toString(value).isEmpty()) {
                    return true;
                }

                // 半角・全角スペースを全て消す
                final String text = Objects.toString(value).replaceAll("\\h", "");
                if (!text.isEmpty()) {
                    return true;
                }
            } else {
                // String以外はnullじゃなければtrueとする
                return true;
            }
        }

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
        return false;
    }
}