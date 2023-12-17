package com.akdenizbank.mls.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.akdenizbank.mls.user.repository.AppUserRepository;

@Service
public class UserLoginService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    public UserLoginService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findUserByEmail(email);
    }

}
