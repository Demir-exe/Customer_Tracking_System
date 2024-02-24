package com.akdenizbank.mls.user.repository;
import com.akdenizbank.mls.user.CustomerUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerUserRepository extends JpaRepository<CustomerUser,String> {
    Optional<CustomerUser> findByEmail(String email);
}
