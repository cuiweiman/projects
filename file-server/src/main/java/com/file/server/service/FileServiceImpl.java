package com.file.server.service;

import com.file.server.component.MinIoComponent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description: 文件服务器
 * @author: wei·man cui
 * @date: 2020/12/29 10:28
 */
@Service
@AllArgsConstructor
public class FileServiceImpl {

    private MinIoComponent minIoComponent;

    private static final String IMG_BUCKET = "images";
    private static final String FILE_BUCKET = "files";

    public List<Object> listImg() throws Exception {
        return minIoComponent.list(IMG_BUCKET);
    }

    public List<Object> listFile() throws Exception {
        return minIoComponent.list(FILE_BUCKET);
    }

    public void getImg(String fileName, HttpServletResponse response) {
        minIoComponent.get(IMG_BUCKET, fileName, response);
    }

    public void getFile(String fileName, HttpServletResponse response) {
        minIoComponent.get(FILE_BUCKET, fileName, response);
    }

    public void uploadImg(MultipartFile file) {
        minIoComponent.upload(file, IMG_BUCKET);
    }

    public void uploadFile(MultipartFile file) {
        minIoComponent.upload(file, FILE_BUCKET);
    }

}
