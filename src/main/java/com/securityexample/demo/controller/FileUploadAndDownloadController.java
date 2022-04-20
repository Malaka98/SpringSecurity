package com.securityexample.demo.controller;

import com.securityexample.demo.dto.FileDTO;
import com.securityexample.demo.exception.BadRequestException;
import com.securityexample.demo.service.impl.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FileUploadAndDownloadController {

    private final FileStorageService fileStorageService;

    @PostMapping("/upload")
    ResponseEntity<FileDTO> fileUpload(@RequestParam("file") MultipartFile file) {

        try {
            String fileName = fileStorageService.storeFile(file);
            String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/download/")
                    .path(fileName)
                    .toUriString();
            String contentType = file.getContentType();

            FileDTO response = FileDTO.builder()
                    .fileName(fileName)
                    .contentType(contentType)
                    .url(url)
                    .build();

            return ResponseEntity.ok().body(response);
        }catch (Exception ex) {
            throw new BadRequestException(ex.getMessage());
        }
    }

    @GetMapping("/download/{fileName}")
    ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {

        try {
            Resource resource = fileStorageService.downloadFile(fileName);
            MediaType contentType = MediaType.IMAGE_JPEG;

            return ResponseEntity.ok()
                    .contentType(contentType)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;fileName" + resource.getFilename())
                    .body(resource);
        }catch (Exception ex) {
            throw new BadRequestException(ex.getMessage());
        }
    }
}
