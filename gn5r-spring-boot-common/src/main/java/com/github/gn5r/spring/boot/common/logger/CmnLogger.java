package com.github.gn5r.spring.boot.common.logger;

import com.gn5r.common.utils.ObjectUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 独自ロガークラス
 * 
 * @author gn5r
 */
public class CmnLogger {

    private static final Logger log = LoggerFactory.getLogger(CmnLogger.class);

    /**
     * infoレベルのログ
     *
     * @param message メッセージ
     */
    public static void info(Object message) {
        log.info(concatString(message));
    }

    /**
     * infoレベルのログ
     *
     * @param messages メッセージ配列
     */
    public static void info(Object... messages) {
        log.info(concatString(messages));
    }

    /**
     * errroレベルのログ
     * 
     * @param message メッセージ
     */
    public static void error(Object message) {
        log.error(concatString(message));
    }

    /**
     * errorレベルのログ
     * 
     * @param t 例外クラス
     */
    public static void error(Throwable t) {
        log.error(t.getMessage(), t);
    }

    /**
     * debugレベルのログ
     * 
     * @param message メッセージ
     */
    public static void debug(Object message) {
        log.debug(concatString(message));
    }

    /**
     * debugレベルのログ
     * 
     * @param messages メッセージ配列
     */
    public static void debug(Object... messages) {
        log.debug(concatString(messages));
    }

    /**
     * traceレベルのログ
     * 
     * @param message メッセージ
     */
    public static void trace(Object message) {
        log.trace(concatString(message));
    }

    /**
     * traceレベルのログ
     * 
     * @param messages メッセージ配列
     */
    public static void trace(Object... messages) {
        log.trace(concatString(messages));
    }

    /**
     * オブジェクト配列をカンマで連結した文字列に変換し返却する
     *
     * @param objects オブジェクト配列
     * @return メッセージテキスト
     */
    private static String concatString(Object... objects) {
        StringBuffer buffer = new StringBuffer();

        for (Object msg : objects) {
            String str = "";
            if (msg instanceof Comparable) {
                str = msg.toString();
            } else {
                str = ObjectUtil.toString(msg);
            }
            buffer.append(str + ",");
        }

        // 末尾にあるカンマを削除
        return buffer.toString().replaceAll(",$", "");
    }
}
