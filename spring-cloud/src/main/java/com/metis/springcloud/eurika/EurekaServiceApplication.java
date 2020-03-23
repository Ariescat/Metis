package com.metis.springcloud.eurika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApplication {

    /**
     * @link https://www.cnblogs.com/xinzhao/p/5551828.html
     * @link spring-cloud-context/1.3.3.RELEASE/spring-cloud-context-1.3.3.RELEASE.jar!/META-INF/spring.factories
     * <p>
     * <p>
     * 执行顺序：
     *      首先看 BootstrapApplicationListener#onApplicationEvent(ApplicationEnvironmentPreparedEvent)：
     *      当 Environment 准备好的时候 springboot发出事件 springcloud 监听到 构造自己的context @see bootstrapServiceContext()
     *
     *      在 DefaultListableBeanFactory#registerBeanDefinition 断点
     *      registerBeanDefinition有三个地方:
     *          SpringApplication#createApplicationContext
     *              AnnotationConfigApplicationContext 构造的时候会 new AnnotatedBeanDefinitionReader 和 ClassPathBeanDefinitionScanner
     *              AnnotatedBeanDefinitionReader 构造的时候会 register 一些 BeanDefinition
     *          SpringApplication#prepareContext -> SpringApplication#load
     *              这里的sources是由 BootstrapApplicationListener#bootstrapServiceContext 读取 META-INF/spring.factories 的 BootstrapConfiguration 配置项
     *              然后交给 AnnotatedBeanDefinitionReader 执行注册
     *          SpringApplication#refreshContext -> AbstractApplicationContext#invokeBeanFactoryPostProcessors
     *              PostProcessorRegistrationDelegate#invokeBeanFactoryPostProcessors里的注释其实说得很清楚了：
     *                  // Invoke BeanDefinitionRegistryPostProcessors first, if any.
     *                  // First, invoke the BeanDefinitionRegistryPostProcessors that implement PriorityOrdered.
     *                  // Next, invoke the BeanDefinitionRegistryPostProcessors that implement Ordered.
     *                  // Finally, invoke all other BeanDefinitionRegistryPostProcessors until no further ones appear.
     *              这里就会出现一个很重要的类 [ConfigurationClassPostProcessor] !!!
     *
     *      下面说说 ConfigurationClassPostProcessor：
     *          这个类的作用注释里也有写：Parse each @Configuration class
     *          这里其实是取出 @Configuration 注解的配置类，也就是 上面registerBeanDefinition的第二步注册进去的sources（spring cloud是这个，springboot是启动类），
     *          然后解析这些配置类，相当于解析以前的xml文件
     *          ConfigurationClassParser 解析完成后交由 ConfigurationClassBeanDefinitionReader load进去
     *          ConfigurationClassParser 的 parse 过程中会调用 processDeferredImportSelectors，这时候 AutoConfigurationImportSelector 就上场了
     *
     *      AutoConfigurationImportSelector：
     *          这里会读取 META-INF/spring.factories（sptingcloud中的deferredImports集合为0, 大部分为spring-boot-autoconfigure Jar包）
     *          的 EnableAutoConfiguration 配置项
     *
     *
     *      上面流程结束后 springcloud的loadBeanDefinition结束，继续执行springboot的 createApplicationContext，prepareContext，refreshContext，流程同上
     *
     * @see ConfigurationClassPostProcessor
     * @see AutoConfigurationImportSelector
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }
}