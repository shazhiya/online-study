package com.shazhi.onlinestudy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@RestController
public class FileController {
    @Value("${file.save.path}")
    String path;

    @RequestMapping("file/{type}/upload")
    public Object uploadFile(@Param("file") MultipartFile file, @PathVariable String type){
        if (file.isEmpty()) return false;
        String name = new Date().getTime() + '_' + file.getOriginalFilename();
        try{
            file.transferTo(new File(path + '\\' + type + '\\' + name));
            return type + '/' + name;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
