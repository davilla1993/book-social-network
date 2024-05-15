package com.follygbossou.booksocial.fileStorage;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileStorageService {

    @Value("${application.file.upload.photos-output-path}")
    private String fileUploadPath;

    public String saveFile(@NonNull MultipartFile sourceFile, @NonNull Integer userId) {

        final String fileUploadSubPath = "users" + File.separator + userId;

        return uploadFile(sourceFile, fileUploadSubPath);
    }

    private String uploadFile(@NonNull MultipartFile sourceFile, @NonNull String fileUploadSubPath) {
        final String finalUploadPath = fileUploadPath + File.separator + fileUploadSubPath;
        File targetFolder = new File(finalUploadPath);
        if(!targetFolder.exists()) {
            boolean folderCreated = targetFolder.mkdirs();
            if(!folderCreated) {
                log.warn("Failed to create the target folder");
                return null;
            }
        }

        final String fileExtension = getFileExtension(sourceFile.getOriginalFilename());
        String targetFilePath = finalUploadPath + File.separator +  System.currentTimeMillis() + "." + fileExtension;
        Path targetPath = Paths.get(targetFilePath);

        try{

            Files.write(targetPath, sourceFile.getBytes());
            return targetFilePath;

        }catch(IOException e){
            log.error("File was not saved", e);
        }
        return null;
    }

    private String getFileExtension(String filename) {
        if(filename == null || filename.isEmpty()) {
            return "";
        }

        int lastDotIndex = filename.lastIndexOf(".");
        if(lastDotIndex == -1) {
            return "";
        }
        return filename.substring(lastDotIndex + 1).toLowerCase();
    }
}
