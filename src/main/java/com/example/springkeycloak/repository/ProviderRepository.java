package com.example.springkeycloak.repository;

import com.example.springkeycloak.domain.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, String> {
}