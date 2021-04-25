package com.example.springkeycloak.services.mapper;

import com.example.springkeycloak.domain.Provider;
import com.example.springkeycloak.services.dto.ProviderDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProviderMapper extends EntityMapper<ProviderDTO, Provider>{
}
