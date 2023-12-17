package com.akdenizbank.mls.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akdenizbank.mls.user.AdminUser;

public interface AdminUserRepository extends JpaRepository<AdminUser, String> {

    Optional<AdminUser> findByEmail(String email);

}
