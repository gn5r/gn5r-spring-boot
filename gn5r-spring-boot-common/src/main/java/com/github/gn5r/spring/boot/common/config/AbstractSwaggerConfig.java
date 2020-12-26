package com.github.gn5r.spring.boot.common.config;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 基底SwaggerConfigクラス
 * 
 * @author gn5r
 */
public abstract class AbstractSwaggerConfig {

    /**
     * <p>
     * ドキュメント化したいパッケージ等を設定するメソッド
     * </p>
     * 
     * <pre>
     * &#64;Bean
     * &#64;Override
     * protected Docket petApi() {
     *     return new Docket(DocumentationType.SWAGGER_2).select()
     *             .apis(RequestHandlerSelectors.basePackage("com.github.gn5r.spring.boot.common"))
     *             .paths(PathSelectors.any()).build().apiInfo(apiInfo());
     * }
     * </pre>
     */
    protected abstract Docket petApi();

    /**
     * <p>
     * swagegr-ui.htmlに表示されるタイトルや説明などを設定するメソッド
     * </p>
     * 
     * <pre>
     * &#64;Override
     * protected ApiInfo apiInfo() {
     *     return new ApiInfoBuilder().title("Spring Boot Common Library for gn5r")
     *             .description("gn5r向けにカスタマイズしたSpring Bootのライブラリを提供する").build();
     * }
     * </pre>
     */
    protected abstract ApiInfo apiInfo();
}
