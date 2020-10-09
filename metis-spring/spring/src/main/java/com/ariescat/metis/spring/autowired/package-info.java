/**
 * Spring 源码（九）@Autowired注解实现原理（Spring Bean的自动装配） @link https://my.oschina.net/xiaolyuh/blog/3113215
 *
 * 注册 AutowiredAnnotationBeanPostProcessor:
 * org.springframework.context.annotation.AnnotationConfigBeanDefinitionParser
 *      <context:annotation-config> -> CompositeComponentDefinition -> 使用@ Resource 、@ PostConstruct、@ PreDestroy等注解
 *      <context:component-scan base-package="xxx"/> -> ComponentScanBeanDefinitionParser -> 除了具有上面的功能之外，还具有自动将带有@component,@service,@Repository等注解的对象注册到spring容器中的功能。
 *
 * AutowiredAnnotationBeanPostProcessor#findAutowiringMetadata #buildAutowiringMetadata
 */

package com.ariescat.metis.spring.autowired;