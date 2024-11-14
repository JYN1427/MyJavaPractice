package com.example.SpringDemosProject.controller.file;

import com.example.SpringDemosProject.service.file.FileInfoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-10-17 16:00:25
 */
@RestController
@RequestMapping("/fileInfo")
public class FileInfoController {

    @Resource
    private FileInfoService fileInfoService;

    @PutMapping("/uploadFile")
    public String uploadFile(MultipartFile file) {
        fileInfoService.uploadFileInfo(file);
        return "ok";
    }

}