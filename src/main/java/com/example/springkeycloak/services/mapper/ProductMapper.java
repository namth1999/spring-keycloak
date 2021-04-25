package com.example.springkeycloak.services.mapper;

import com.example.springkeycloak.domain.Product;
import com.example.springkeycloak.services.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {
}