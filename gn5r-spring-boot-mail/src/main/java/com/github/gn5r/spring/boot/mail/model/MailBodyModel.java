package com.github.gn5r.spring.boot.mail.model;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

/**
 * Thymeleafテンプレートを使用したメールボディの基底モデル
 * 
 * @author gn5r
 */
public abstract class MailBodyModel {
    
    /**
     * yyyy/MM/dd HH:mm:ssへ変換する
     */
    protected static final DateTimeFormatter YMD_HMS = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /**
     * 送信日時をセットする
     * 
     * @param sendTime 送信日時
     */
    public abstract void setSendTime(@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss") LocalDateTime sendTime);

    /**
     * 送信日時を取得する
     * 
     * @return 送信日時
     */
    public abstract String getSendTime();

    /**
     * メール本文テキストをセットする
     * 
     * @param text メール本文テキスト
     */
    public abstract void setText(@NonNull String text);

    /**
     * メール本文テキストを取得する
     * 
     * @return メール本文テキスト
     */
    public abstract String getText();

    /**
     * オブジェクトのフィールドを {@code Map<String, Object>} 形式のマップに変換する
     * <p>
     * 値は {@code getValue(変数名)} で取得可能
     * </p>
     * 
     * @return フィールドとパラメータのマップ
     */
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        final List<Field> fields = Arrays.asList(this.getClass().getDeclaredFields());

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                final String key = field.getName();
                final Object value = field.get(this);
                map.put(key, value);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return map;
    }
}
