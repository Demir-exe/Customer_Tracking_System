package com.akdenizbank.mls.user.service;

import com.akdenizbank.mls.user.CustomerUser;
import com.akdenizbank.mls.xaction.CreateCustomerUserXAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.akdenizbank.mls.user.AdminUser;
import com.akdenizbank.mls.user.AppUser;
import com.akdenizbank.mls.user.AppUserRole;
import com.akdenizbank.mls.xaction.CreateAdminUserXAction;

@Service
public class UserRegistrationService {
    @Autowired
    private CustomerUserService customerUserService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AdminUserService adminUserService;

    public UserRegistrationService(AdminUserService adminUserService,
            BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.adminUserService = adminUserService;
    }

    public AdminUser registerAdminUser(CreateAdminUserXAction xAction) {
        AdminUser adminUser = new AdminUser();
        adminUser.setName(xAction.getName());
        adminUser.setSurname(xAction.getSurname());
        adminUser.setRole(AppUserRole.ADMIN);
        adminUser.setPassword(passwordEncoder.encode(xAction.getPassword()));
        adminUser.setEmail(xAction.getEmail());
        return adminUserService.create(adminUser);
    }

    public CustomerUser registerCustomerUser(CreateCustomerUserXAction xAction){
        CustomerUser customerUser=new CustomerUser();
        customerUser.setName(xAction.getName());
        customerUser.setSurname(xAction.getSurname());
        customerUser.setEmail(xAction.getEmail());
        return customerUserService.create(customerUser);
    }

}
