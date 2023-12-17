package com.akdenizbank.mls.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akdenizbank.mls.generic.rest.GenericApiResponse;
import com.akdenizbank.mls.user.AdminUser;
import com.akdenizbank.mls.user.service.AdminUserService;

@RestController
@RequestMapping("/api/v1/users/admin-users")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping
    public GenericApiResponse getAllAdmins(Pageable pageable) {
        Page<AdminUser> adminsPage = this.adminUserService.getAdminUsers(pageable);
        return new GenericApiResponse(200, "Success", "283475634", adminsPage);
    }

    @GetMapping("/{id}")
    public GenericApiResponse getById(@PathVariable String id) {
        AdminUser adminInDB = this.adminUserService.getById(id);
        return new GenericApiResponse(200, "Success", "21345876", adminInDB);
    }

    @DeleteMapping("/{id}")
    public GenericApiResponse delete(@PathVariable String id) {
        AdminUser adminInDB = this.adminUserService.getById(id);
        if(adminInDB == null){
            throw new RuntimeException("No Such User");
        }
        adminUserService.delete(adminInDB);
        return new GenericApiResponse(200, "Success", "21345876", adminInDB);
    }

}
