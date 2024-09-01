package app.quantun.langchanin.services;

import app.quantun.langchanin.models.dto.UpdateRoleRequest;
import app.quantun.langchanin.models.dto.UserRecordDto;
import app.quantun.langchanin.models.enums.Permission;
import com.google.firebase.auth.UserRecord;

import java.util.List;

public interface UserManagementService {
    UserRecordDto setUserPermissions(UpdateRoleRequest updateRoleRequest);

    void updateUser(String uid, String email, String password);

    String getUserId(String idToken);
}
