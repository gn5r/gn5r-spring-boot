package com.github.gn5r.spring.boot.common.config;

import org.modelmapper.ModelMapper;

/**
 * 基底ModelMapperConfigクラス
 * 
 * @author gn5r
 */
public abstract class AbstractModelMapperConfig {

    /**
     * <p>
     * ModelMapperの設定をするメソッド
     * </p>
     * 
     * <pre>
     * &#64;Bean
     * &#64;Override
     * protected ModelMapper modelMapper() {
     *     ModelMapper modelMapper = new ModelMapper();
     *     modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
     *     return modelMapper;
     * }
     * </pre>
     */
    protected abstract ModelMapper modelMapper();
}
