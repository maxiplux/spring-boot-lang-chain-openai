package app.quantun.langchanin.controllers;


import app.quantun.langchanin.models.enums.Permission;
import app.quantun.langchanin.services.UserManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secure")
@Slf4j
public class SecureController {

    @Autowired
    private UserManagementService userManagementService;

    @GetMapping("/hello")
    public String sayHello(@RequestHeader(value = "Authorization", required = true) String idToken) {
        return "Hello, secure world!";
    }

    @PutMapping("/roles")
    public String updateRoles(@RequestHeader(value = "Authorization", required = true) String idToken, @RequestBody List<Permission> requestedPermissions)
    {
        this.userManagementService.setUserPermissions(userManagementService.getUserId(idToken), requestedPermissions);
        return "Role set!";
    }
}

