package aopConfig;

import aspectConfig.RoleAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Bean配置类
 * EnableAspectJAutoProxy启用AspectJ框架自动代理，也可以在xml中配置
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"service"})
public class AopConfig {
    @Bean
    public RoleAspect getRoleAspect(){
        return new RoleAspect();
    }
}
