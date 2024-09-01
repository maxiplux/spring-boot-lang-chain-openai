package app.quantun.langchanin.services;

import app.quantun.langchanin.models.enums.Permission;

import java.util.List;

public interface UserManagementService {
    Boolean setUserPermissions(String uid, List<Permission> requestedPermissions);

    void updateUser(String uid, String email, String password);

    String getUserId(String idToken);
}
