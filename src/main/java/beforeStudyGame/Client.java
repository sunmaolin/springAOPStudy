package beforeStudyGame;

import pojo.Role;

public class Client {
    public static void main(String[] args) {
        Role role = new Role();
        role.setRoleId(1);
        role.setRoleName("孙茂林");
        role.setNote("太帅了");
        RoleServiceImpl roleService = new RoleServiceImpl();
        RoleInterceptor roleInterceptor = new RoleInterceptor();
        RoleService proxy = (RoleService) ProxyBeanUtil.getBean(roleService,roleInterceptor);
        proxy.printRole(role);

        //测试发生异常
        role = null;
        proxy.printRole(role);
    }
}
