package aopController;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Role;
import xmlAop.service.RoleService;

public class aspectByXMLController {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        RoleService roleService = context.getBean(RoleService.class);
        Role role = new Role(1,"孙茂林");
        roleService.printRole(role);
    }
}
