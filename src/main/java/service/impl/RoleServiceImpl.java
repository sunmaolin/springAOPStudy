package service.impl;
import org.springframework.stereotype.Component;
import pojo.Role;
import service.RoleService;

/**
 * Role服务层实现类
 * 方法为定义的切点
 */
@Component
public class RoleServiceImpl implements RoleService {

    @Override
    public void printRole(Role role) {
        System.out.println(role.getRoleId());
        System.out.println(role.getRoleName());
        System.out.println(role.getNote());
    }
}
