package xmlAop.service.impl;
import pojo.Role;
import xmlAop.service.RoleService;

public class RoleServiceImpl implements RoleService {

    @Override
    public void printRole(Role role) {
        System.out.println(role.getRoleId());
        System.out.println(role.getRoleName());
        System.out.println(role.getNote());
    }

}
