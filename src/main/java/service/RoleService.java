package service;

import pojo.Role;

/**
 * role服务层接口
 */
public interface RoleService {

    /**
     * 测试aop切面
     * @param role
     */
    void printRole(Role role);

    /**
     * 测试aop切面通知添加参数
     * @param role
     * @param sort
     */
    void printRole(Role role,int sort);

}
