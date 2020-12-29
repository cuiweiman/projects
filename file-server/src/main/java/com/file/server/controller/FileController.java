package com.file.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.file.server.service.FileServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description: 文件服务器测试
 * @author: wei·man cui
 * @date: 2020/12/29 9:54
 */
@RestController
@AllArgsConstructor
@RequestMapping("test")
public class FileController {

    private FileServiceImpl fileService;

    @GetMapping("/img/list")
    public String listImg() {
        try {
            List<Object> list = fileService.listImg();
            return JSONObject.toJSONString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        }
    }

    @GetMapping("/img/get/{fileName}")
    public void getImg(@PathVariable("fileName") String fileName, HttpServletResponse response) {
        fileService.getImg(fileName, response);
    }

    @PostMapping("/img/upload")
    public void uploadImg(MultipartFile file) {
        fileService.uploadImg(file);
    }

    @GetMapping("/file/list")
    public String listFile() {
        try {
            List<Object> list = fileService.listFile();
            return JSONObject.toJSONString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return "error: " + e.getMessage();
        }
    }

    @GetMapping("/file/get/{fileName}")
    public void getFile(@PathVariable("fileName") String fileName, HttpServletResponse response) {
        fileService.getFile(fileName, response);
    }

    @PostMapping("/file/upload")
    public void uploadFile(MultipartFile file) {
        fileService.uploadFile(file);
    }

}
