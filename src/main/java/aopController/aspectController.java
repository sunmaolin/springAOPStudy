package aopController;

import aopConfig.AopConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Role;
import service.RoleService;
import service.impl.RoleServiceImpl;

/**
 * 测试切面，切点的控制器
 */
public class aspectController {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        RoleService roleService = context.getBean(RoleService.class);
        Role role = new Role(1,"孙茂林");
        roleService.printRole(role);
        //测试异常
        role = null;
        roleService.printRole(role);
    }
}
