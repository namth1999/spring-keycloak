package com.example.springkeycloak.restDTO.Product;

import com.example.springkeycloak.services.dto.ProductDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {
    private List<ProductDTO> products;
}
