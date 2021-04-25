package com.example.springkeycloak.services;

import com.example.springkeycloak.domain.Product;
import com.example.springkeycloak.repository.ProductRepository;
import com.example.springkeycloak.restDTO.Product.ProductResponse;
import com.example.springkeycloak.services.dto.ProductDTO;
import com.example.springkeycloak.services.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponse getAllProducts() throws ServiceException {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = products.stream().map(productMapper::toDto).collect(Collectors.toList());
        ProductResponse response = new ProductResponse();
        response.setProducts(productDTOS);
        return response;
    }
}
