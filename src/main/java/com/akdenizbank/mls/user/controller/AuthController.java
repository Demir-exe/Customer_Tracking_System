package com.akdenizbank.mls.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akdenizbank.mls.generic.rest.GenericApiResponse;
import com.akdenizbank.mls.login.LoginRequest;
import com.akdenizbank.mls.security.JwtService;
import com.akdenizbank.mls.user.AdminUser;
import com.akdenizbank.mls.user.AppUser;
import com.akdenizbank.mls.user.service.AdminUserService;
import com.akdenizbank.mls.user.service.UserLoginService;
import com.akdenizbank.mls.user.service.UserRegistrationService;
import com.akdenizbank.mls.xaction.CreateAdminUserXAction;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Autowired
    private AdminUserService adminUserService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/user-registrations/admins")
    public GenericApiResponse createAdminUser(@RequestBody CreateAdminUserXAction xaction) {
        AdminUser adminUser = adminUserService.getByEmail(xaction.getEmail());
        if (adminUser == null) {
            adminUser = userRegistrationService.registerAdminUser(xaction);
        }
        return new GenericApiResponse(200, "Success", "34892567", adminUser);

    }

    @PostMapping("/login")
    public GenericApiResponse login(@RequestBody LoginRequest loginRequest) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                        loginRequest.getPassword()));
        AppUser user = (AppUser) userLoginService.loadUserByUsername(loginRequest.getEmail());

        String accessToken = null;
        if (user != null) {
            accessToken = this.jwtService.generateAccessToken(user);
        }
        return new GenericApiResponse(200, "Success", "3487529", accessToken);
    }

}
