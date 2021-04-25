package com.example.springkeycloak.rest;

import com.example.springkeycloak.restDTO.Product.ProductResponse;
import com.example.springkeycloak.services.ProductService;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ProductsResource {
    private final ProductService productService;

    @GetMapping("/product/all")
    public ResponseEntity<ProductResponse> getAllProducts() {
        try {
            ProductResponse response = productService.getAllProducts();
            return new ResponseEntity<>(response, HttpStatus.valueOf(200));
        } catch (ServiceException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(500));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(400));
        }
    }
}