package com.akdenizbank.mls.user.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.akdenizbank.mls.user.AdminUser;
import com.akdenizbank.mls.user.repository.AdminUserRepository;

@Service
public class AdminUserService {

    private AdminUserRepository adminUserRepository;

    public AdminUserService(AdminUserRepository adminUserRepository) {
        this.adminUserRepository = adminUserRepository;
    }

    public AdminUser getByEmail(String email) {
        return this.adminUserRepository.findByEmail(email).orElse(null);
    }

    public AdminUser create(AdminUser adminUser) {
        return this.adminUserRepository.save(adminUser);
    }

    public Page<AdminUser> getAdminUsers(Pageable pageable) {
        return this.adminUserRepository.findAll(pageable);
    }

    public AdminUser getById(String id) {
        return adminUserRepository.findById(id).orElse(null);
    }

    public void delete(AdminUser adminUser) {
        this.adminUserRepository.delete(adminUser);
    }
}
