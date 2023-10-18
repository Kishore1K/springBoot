package com.spring.rest_api_1.controller;

import com.spring.rest_api_1.helper.FileUploadHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {
    private FileUploadHelper fileUploadHelper;
    public FileUploadController(FileUploadHelper fileUploadHelper) {
        this.fileUploadHelper = fileUploadHelper;
    }




    @PostMapping("/upload-file")
    public ResponseEntity<?> fileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        try{
            if(file.isEmpty()){
                return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File not availbele");
            }
            if(!file.getContentType().equals("image/jpeg")){

                return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Enter the Correct format");
            }
            boolean f = fileUploadHelper.uploadFile(file);
            if(f){
                return ResponseEntity.ok("Uploaded File Successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok("Working");
    }
}
