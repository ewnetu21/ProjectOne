package com.example.restApiExercise.security.Securityservices;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface UserDetail {
    String getUsername();

    String getPassword();

    Collection<? extends GrantedAuthority> getAuthorities();

    boolean isAccountNonExpired();

    boolean isAccountNonLocked();

    boolean isCredentialsNonExpired();

    boolean isEnabled();
}
