package com.jiutian.jiutian.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FileUpload {
    public static String upload(MultipartFile fileUrl){
        String oldName = fileUrl.getOriginalFilename();
        String suffix = oldName.substring(oldName.lastIndexOf("."));

        String newFileName = UUIDUtils.getUUID() + suffix;
        try {
            fileUrl.transferTo(new File("/usr/video",newFileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String imgUrl="http://localhost:8082/video/"+newFileName;

        return imgUrl;
    }
}
