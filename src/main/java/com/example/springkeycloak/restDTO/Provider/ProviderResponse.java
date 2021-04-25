package com.example.springkeycloak.restDTO.Provider;

import com.example.springkeycloak.services.dto.ProviderDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProviderResponse  {
    private List<ProviderDTO> providerDTOS;
}