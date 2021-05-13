package com.example.springkeycloak.clients;

import com.example.springkeycloak.clients.dto.FileResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileResourceClient {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.rest.endpoints.file-upload}")
    private String imageResourceEndpoint;

    @Autowired
    private ObjectMapper objectMapper;

    private final String PATH_UPLOAD_FILE = "/upload-file";

    public KeycloakClientRequestFactory keycloakClientRequestFactory = new KeycloakClientRequestFactory();

    private final KeycloakRestTemplate restTemplate = new KeycloakRestTemplate(keycloakClientRequestFactory);


    public FileResponseDTO uploadFile(MultipartFile multipartFile) throws Exception {
        try {
            LinkedMultiValueMap<String, Object> requestParam = new LinkedMultiValueMap<>();

            if (null != multipartFile && !multipartFile.isEmpty()) {
                LinkedMultiValueMap<String, String> fileHeader = new LinkedMultiValueMap<>();
                fileHeader.add("Content-disposition",
                        "form-data; name=file; filename=" + multipartFile.getOriginalFilename());
                fileHeader.add("Content-type", multipartFile.getContentType());
                HttpEntity<byte[]> fileEntity = new HttpEntity<>(multipartFile.getBytes(), fileHeader);
                requestParam.add("file", fileEntity);
            }

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
            HttpEntity<LinkedMultiValueMap<String, Object>> httpEntity = new HttpEntity<>(requestParam, httpHeaders);
            ResponseEntity<String> result = restTemplate.postForEntity(imageResourceEndpoint + PATH_UPLOAD_FILE, httpEntity, String.class);
            FileResponseDTO fileResponseDTO = objectMapper.readValue(result.getBody(),FileResponseDTO.class);
            return fileResponseDTO;
        } catch (Throwable t) {
            log.error(this.getClass().getName(), t);
            throw t;
        }
    }
}
