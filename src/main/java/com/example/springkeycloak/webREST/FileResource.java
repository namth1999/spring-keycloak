package com.example.springkeycloak.webREST;

import com.example.springkeycloak.clients.dto.FileResponseDTO;
import com.example.springkeycloak.services.FileService;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class FileResource {
    FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<List<FileResponseDTO>> getAllProducts(@RequestParam("files") List<MultipartFile> files) {
        try {
            List<FileResponseDTO> response = fileService.uploadFile(files);
            return new ResponseEntity(response, HttpStatus.valueOf(200));
        } catch (ServiceException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(500));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.valueOf(400));
        }
    }
}
