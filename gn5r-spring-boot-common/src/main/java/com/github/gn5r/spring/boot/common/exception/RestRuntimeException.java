package com.github.gn5r.spring.boot.common.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 独自例外クラス
 * </p>
 * <p>
 * ステータスコード、メッセージ、バリデーションエラーを内包
 * </p>
 *
 * @author gn5r
 * @see HttpStatus
 * @see FieldError
 */
public class RestRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Setter
	@Getter
	private HttpStatus status;

	@Setter
	@Getter
	private String message;

	@Setter
	@Getter
	private List<FieldError> fieldErrors;

	/**
	 * Httpステータスコードとエラーメッセージをthrowするコンストラクタ
	 *
	 * @param status  HttpStatus
	 * @param message エラーメッセージ
	 */
	public RestRuntimeException(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	/**
	 * Httpステータスコードとエラーメッセージ及びバリデーションエラーリストをthrowするコンストラクタ
	 *
	 * @param status      HttpStatus
	 * @param message     エラーメッセージ
	 * @param fieldErrors バリデーションエラーリスト
	 */
	public RestRuntimeException(HttpStatus status, String message, List<FieldError> fieldErrors) {
		this.status = status;
		this.message = message;
		this.fieldErrors = fieldErrors;
	}
}