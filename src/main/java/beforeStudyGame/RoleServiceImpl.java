package beforeStudyGame;

import pojo.Role;

/**
 * Role服务层实现类
 */
public class RoleServiceImpl implements RoleService{

    @Override
    public void printRole(Role role) {
        System.out.println(role.getRoleId());
        System.out.println(role.getRoleName());
        System.out.println(role.getNote());
    }
}
