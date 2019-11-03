package com.jiutian.jiutian.controller;

import com.jiutian.jiutian.resultVo.ResultVo;
import com.jiutian.jiutian.utils.FileUpload;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AfetrVideoController {
    @PostMapping("/uploadVidoe")
    public ResultVo savaVideo( MultipartFile file) {
        String url = FileUpload.upload(file);
        return  ResultVo.setOk(url) ;

    }

}
