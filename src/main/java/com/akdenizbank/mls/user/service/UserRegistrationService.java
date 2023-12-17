package com.akdenizbank.mls.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.akdenizbank.mls.user.AppUser;

@Service
public class UserRegistrationService {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    
    public UserRegistrationService(AppUserService appUserService,
            BCryptPasswordEncoder passwordEncoder  ) {
        this.appUserService = appUserService;
        this.passwordEncoder = passwordEncoder;
    }

    // TODO : Register Employee user method
    public AppUser registerAppUser() {
        return null;
    }
}
