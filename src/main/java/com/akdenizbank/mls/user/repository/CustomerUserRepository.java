package com.akdenizbank.mls.user.repository;

import com.akdenizbank.mls.user.CustomerUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerUserRepository extends JpaRepository<CustomerUser,String> {
}
