package com.example.springkeycloak.services;

import com.example.springkeycloak.clients.FileResourceClient;
import com.example.springkeycloak.clients.dto.FileResponseDTO;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class FileService {
    private final Logger log = LoggerFactory.getLogger(FileService.class);

    private final FileResourceClient fileResourceClient;

    private final String fileDir = "file/img";

    public List<FileResponseDTO> uploadFile(List<MultipartFile> files) {
        List<FileResponseDTO> results = new ArrayList<>();
        if (files != null && !files.isEmpty()) {
            for (MultipartFile file : files) {
                try {
                    results.add(fileResourceClient.uploadFile(file, fileDir));
                } catch (Exception e) {
                    log.error(this.getClass().getName(), e);
                    throw new SecurityException(e);

                }
            }
        }
        return results;
    }
}
