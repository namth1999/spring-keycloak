package com.example.springkeycloak.webREST;

import com.example.springkeycloak.restDTO.Provider.ProviderResponse;
import com.example.springkeycloak.services.ProviderService;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/sudo")
public class ProviderResource {
    private final ProviderService providerService;

    @GetMapping("/providers")
    public ResponseEntity getAllProviders() {
        try {
            ProviderResponse response = providerService.getAllProvider();
            return new ResponseEntity(response, HttpStatus.valueOf(200));
        } catch (ServiceException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(500));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(400));
        }
    }
}