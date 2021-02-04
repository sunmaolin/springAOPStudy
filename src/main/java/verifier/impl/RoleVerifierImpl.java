package verifier.impl;

import pojo.Role;
import verifier.RoleVerifier;

public class RoleVerifierImpl implements RoleVerifier {
    @Override
    public boolean verifierRole(Role role) {
        return role != null;
    }
}
