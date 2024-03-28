package tn.esprit.coexist.controller;

import jakarta.annotation.Resource;
import lombok.*;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.coexist.dto.StringToJsonDto;
import tn.esprit.coexist.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/v1/file")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FileUploadController {

    private final FileUploadService fileUploadService;
    @Value("${profile.images.upload.directory}")
    private String uploadDirectory;

    @PostMapping("/upload-profile-picture")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String filePath = fileUploadService.uploadFile(file);
        return ResponseEntity.ok(
                StringToJsonDto.builder()
                        .message("path of image uploaded: " + filePath)
                        .build()
        );
    }
    @PostMapping("/upload-profile-image")
    public ResponseEntity<?> handleImageUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String filePath = fileUploadService.uploadImage(file);
        return ResponseEntity.ok(
                StringToJsonDto.builder()
                        .message("path of uniqueFilename image uploaded: " + filePath)
                        .build()
        );
    }

    /*@GetMapping("/images/{filename:.+}")
    public ResponseEntity<?> serveImage(@PathVariable String filename) throws IOException {
        Path imagePath = Paths.get(uploadDirectory).resolve(filename);
        Resource fileResource = new ByteArrayResource(Files.readAllBytes(imagePath));

        return ResponseEntity.ok()
                .contentLength(Files.size(imagePath))
                .body(fileResource);
    }*/
}
