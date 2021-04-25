package com.example.springkeycloak.services;

import com.example.springkeycloak.domain.Provider;
import com.example.springkeycloak.repository.ProviderRepository;
import com.example.springkeycloak.services.dto.ProviderDTO;
import com.example.springkeycloak.services.mapper.ProviderMapper;
import com.example.springkeycloak.restDTO.Provider.ProviderResponse;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ProviderService {
    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    public ProviderResponse getAllProvider() throws ServiceException {
        List<Provider> providers = providerRepository.findAll();
        List<ProviderDTO> providerDTOS = providers.stream().map(providerMapper::toDto).collect(Collectors.toList());
        ProviderResponse response = new ProviderResponse();
        response.setProviderDTOS(providerDTOS);
        return response;
    }

}
