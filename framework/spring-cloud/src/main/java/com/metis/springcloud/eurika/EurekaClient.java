package springboot.eurika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * \@EnableDiscoveryClient 这个注解是开启SpringCloud服务发现客户端的注解,
 * 之所以这里没有说是开启Eureka客户端,是因为开启Eureka客户端的注解是 @EnableEurekaClient,
 * 由于SpringCloud在服务发现组件上不只支持Eureka,还支持例如Alibaba的Dubbo等,而前者才是SpringCloud开启服务发现的注解;
 * 倘若SpringCloud集成Dubbo,也许针对此的注解就是@EnableDubboClient了
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
public class EurekaClient {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient.class, args);
    }
}
