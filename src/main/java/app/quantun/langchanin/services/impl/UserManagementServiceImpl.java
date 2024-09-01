package app.quantun.langchanin.services.impl;


import app.quantun.langchanin.errors.InvalidSecurityBridgetException;
import app.quantun.langchanin.errors.InvalidTokenException;
import app.quantun.langchanin.models.dto.CustomClaimsDto;
import app.quantun.langchanin.models.dto.UpdateRoleRequest;
import app.quantun.langchanin.models.dto.UserRecordDto;
import app.quantun.langchanin.models.enums.Permission;
import app.quantun.langchanin.services.UserManagementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserManagementServiceImpl implements UserManagementService {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FirebaseAuth firebaseAuth;

    @Override
    public UserRecordDto setUserPermissions(UpdateRoleRequest updateRoleRequest) {
        List<String> permissions = updateRoleRequest.getPermissions().stream().map(Permission::name).collect(Collectors.toList());
        String uid = updateRoleRequest.getUserId();


        Map<String, Object> claims = Map.of("custom_claims", permissions);

        try {
            firebaseAuth.setCustomUserClaims(uid, claims);

            return mapToUserRecordDto(firebaseAuth.getUser(uid));


        } catch (FirebaseAuthException e) {
            log.error("Error setting user claims {}", e.getLocalizedMessage());
            throw new InvalidSecurityBridgetException(e.getLocalizedMessage());
        }

    }

    @Override
    public void updateUser(String uid, String email, String password) {
        UserRecord.UpdateRequest request = new UserRecord.UpdateRequest(uid)
                .setEmail(email)
                .setPassword(password);

        try {
            FirebaseAuth.getInstance().updateUser(request);
        } catch (FirebaseAuthException e) {
            log.error("Error updating user {}", e.getLocalizedMessage());
            throw new InvalidSecurityBridgetException(e.getLocalizedMessage());
        }
    }

    @Override
    public String getUserId(String idToken) {

        FirebaseToken decodedToken = null;
        try {
            decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken.replace("Bearer ", ""));
        } catch (FirebaseAuthException e) {
            log.error("Error verifying token {}", e.getLocalizedMessage());
            throw new InvalidTokenException(e.getLocalizedMessage());
        }
        return decodedToken.getUid();


    }

    private UserRecordDto mapToUserRecordDto(UserRecord userRecord) {
        UserRecordDto userRecordDto=this.objectMapper.convertValue(userRecord, UserRecordDto.class);
        userRecord.getCustomClaims().forEach((k,v)->{


            userRecordDto.setCustomClaims((Map.of(k,v)));


        });

        return userRecordDto;
    }


}
