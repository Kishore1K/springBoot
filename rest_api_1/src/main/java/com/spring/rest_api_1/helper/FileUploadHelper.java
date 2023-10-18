package com.spring.rest_api_1.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

   // public final  String UPLOAD_DIR="D:\\JAVA\\JAVAEE\\springBoot\\rest_api_1\\src\\main\\resources\\static\\images";
    public final  String UPLOAD_DIR= new ClassPathResource("static/images").getFile().getAbsolutePath();
    public FileUploadHelper() throws IOException {
    }

    public  boolean uploadFile(MultipartFile file){
        boolean f = false;

        try {
/*
            InputStream inputStream=file.getInputStream();
            byte data[] = new byte[inputStream.available()];
            inputStream.read(data);

            FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR+ File.separator+file.getOriginalFilename());
            System.out.println(fileOutputStream);
            fileOutputStream.write(data);
            fileOutputStream.flush();
            fileOutputStream.close();
            inputStream.close();

*/
            System.out.println(UPLOAD_DIR);
            Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            f=true;

        }catch (Exception e){
            e.printStackTrace();
        }


        return  f;
    }
}
