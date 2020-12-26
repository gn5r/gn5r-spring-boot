package com.github.gn5r.spring.boot.common.handler;

import com.github.gn5r.spring.boot.common.exception.RestRuntimeException;
import com.github.gn5r.spring.boot.common.logger.CmnLogger;
import com.github.gn5r.spring.boot.common.resource.ErrorResource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * <p>
 * {@link RestController} 向けの例外捕捉クラス
 * </p>
 *
 * @author gn5r
 * @see RestRuntimeException
 */
@RestControllerAdvice
public class RestRuntimeExceptionHandler extends ResponseEntityExceptionHandler {

    private static final HttpStatus SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR;

    /**
     * {@link RestRuntimeException} を捕捉しエラーリソースを返却するハンドラメソッド
     * 
     * @param e 独自例外
     * @return エラーリソース
     * @see ErrorResource
     */
    @ExceptionHandler(RestRuntimeException.class)
    public ResponseEntity<?> handleRestRuntimeException(RestRuntimeException e) {

        // トレース
        CmnLogger.error(e);

        // エラーレスポンスを作成
        ErrorResource res = new ErrorResource();
        res.setStatus(e.getStatus());
        res.setMessage(e.getMessage());

        // バリデーションエラーがあれば返却
        if (e.getFieldErrors() != null) {
            // 念のため空ではないかチェック
            if (!e.getFieldErrors().isEmpty()) {
                res.setFieldErrors(e.getFieldErrors());
            }
        }

        // エラーレスポンスを返却する
        return new ResponseEntity<ErrorResource>(res, e.getStatus());
    }

    /**
     * <p>
     * {@link NullPointerException} を捕捉しエラーリソースを返却する
     * </p>
     * <p>
     * 返却される {@link HttpStatus} は {@link HttpStatus#INTERNAL_SERVER_ERROR} 固定
     * </p>
     * 
     * @param e NullPointerException
     * @return エラーリソース
     * @see ErrorResource
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(NullPointerException e) {

        // トレース
        CmnLogger.error(e);

        // エラーレスポンスを作成
        ErrorResource res = new ErrorResource();
        res.setStatus(SERVER_ERROR);
        res.setMessage(e.getMessage());

        // エラーレスポンスを返却する
        return new ResponseEntity<ErrorResource>(res, SERVER_ERROR);
    }
}
