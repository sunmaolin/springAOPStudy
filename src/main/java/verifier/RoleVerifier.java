package verifier;

import pojo.Role;

/**
 * 校验类
 */
public interface RoleVerifier {
    /**
     * 校验对象是否为空
     * @param role
     */
    boolean verifierRole(Role role);
}
