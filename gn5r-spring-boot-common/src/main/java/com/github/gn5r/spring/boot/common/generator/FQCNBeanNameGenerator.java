package com.github.gn5r.spring.boot.common.generator;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * Bean名をパッケージ名と紐づけるクラス
 *
 * @author gn5r
 * @see AnnotationBeanNameGenerator
 */
public final class FQCNBeanNameGenerator extends AnnotationBeanNameGenerator {

	/**
	 * Bean登録時にパッケージ名を付与した名称にする
	 *
	 * @param definition BeanDefinition
	 * @return パッケージ名付きBean名
	 */
	@Override
	protected String buildDefaultBeanName(BeanDefinition definition) {
		return definition.getBeanClassName();
	}
}