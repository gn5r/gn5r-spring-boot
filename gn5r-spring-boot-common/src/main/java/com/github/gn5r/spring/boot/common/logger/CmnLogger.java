package com.github.gn5r.spring.boot.common.logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gn5r.common.utils.ObjectUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 独自ロガークラス
 */
public class CmnLogger {

    private static final Logger log = LoggerFactory.getLogger(CmnLogger.class);

    private static final Pattern excludes = Pattern.compile("java.lang.*");

    /**
     * infoレベルのログ
     *
     * @param message メッセージ
     */
    public static void info(Object message) {
        log.info(setStackTrace(message));
    }

    /**
     * infoレベルのログ
     *
     * @param messages メッセージ配列
     */
    public static void info(Object... messages) {
        log.info(setStackTrace(messages));
    }

    /**
     * errroレベルのログ
     * 
     * @param message メッセージ
     */
    public static void error(Object message) {
        log.error(setStackTrace(message));
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
        log.debug(setStackTrace(message));
    }

    /**
     * debugレベルのログ
     * 
     * @param messages メッセージ配列
     */
    public static void debug(Object... messages) {
        log.debug(setStackTrace(messages));
    }

    /**
     * traceレベルのログ
     * 
     * @param message メッセージ
     */
    public static void trace(Object message) {
        log.trace(setStackTrace(message));
    }

    /**
     * traceレベルのログ
     * 
     * @param messages メッセージ配列
     */
    public static void trace(Object... messages) {
        log.trace(setStackTrace(messages));
    }

    /**
     * オブジェクト配列をカンマで連結した文字列を返却する
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

    /**
     * 先頭の {@link StackTraceElement} を返却する
     * 
     * @return {@link StackTraceElement}
     */
    private static StackTraceElement getFiStackTraceElement() {
        final StackTraceElement[] elements = Thread.currentThread().getStackTrace();

        for (StackTraceElement e : elements) {
            // 除外クラスにマッチするか検証
            final Matcher m = excludes.matcher(e.getClassName());

            // マッチした場合は次のループへ
            if (m.find()) {
                continue;
            }
            // 除外クラス以外のStackTraceを返却
            return e;
        }
        return null;
    }

    /**
     * 呼び出し元のクラス名とメソッド名を付与しログ出力する
     * 
     * @param messages メッセージ
     * @return メッセージテキスト
     */
    private static String setStackTrace(Object... messages) {
        final StackTraceElement element = getFiStackTraceElement();

        StringBuffer buffer = new StringBuffer();
        buffer.append(element.getClassName() + "." + element.getMethodName() + " - " + concatString(messages));

        return buffer.toString();
    }
}
