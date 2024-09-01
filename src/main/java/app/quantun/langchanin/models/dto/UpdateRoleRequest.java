package app.quantun.langchanin.models.dto;

import app.quantun.langchanin.models.enums.Permission;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
public class UpdateRoleRequest {
    private String userId;
    private List<Permission> permissions;
}
