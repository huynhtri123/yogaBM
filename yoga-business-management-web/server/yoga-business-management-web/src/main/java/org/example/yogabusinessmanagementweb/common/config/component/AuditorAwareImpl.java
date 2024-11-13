package org.example.yogabusinessmanagementweb.common.config.component;//package com.webiste.foodgate.component;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    public Optional<String> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.of("anonymousUser");
        }
        System.out.println("AuditorAwareImpl.getCurrentAuditor: " + authentication.getName());
        return Optional.of(authentication.getName());
    }
}

