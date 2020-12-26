package com.github.gn5r.spring.boot.common.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * エラーリソース
 * </p>
 * <p>
 * 以下3つのフィールドを設定
 * </p>
 * <ul>
 * <li>{@link HttpStatus status} Httpステータスコード</li>
 * <li>{@link String message} エラーメッセージ</li>
 * <li>{@link FieldError fieldErrors} バリデーションエラーリスト</li>
 * </ul>
 *
 * @author gn5r
 */
@Data
@ApiModel(description = "エラーリソース")
public class ErrorResource {

	@ApiModelProperty(value = "HTTP Status Code", notes = "Httpステータスコードが格納されています")
	private HttpStatus status;

	@ApiModelProperty(value = "エラーメッセージ", notes = "代表的なエラーの原因を表示します")
	private String message;

	@ApiModelProperty(value = "バリデーションエラーのパラメータ一覧", notes = "バリデーションエラーになった項目の一覧が格納されます")
	private List<FieldError> fieldErrors;
}