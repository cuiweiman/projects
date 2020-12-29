package com.file.server.component;

import com.alibaba.fastjson.JSON;
import io.minio.*;
import io.minio.messages.Item;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @description: 文件服务器 操作
 * @author: wei·man cui
 * @date: 2020/12/29 9:37
 */
@Component
@AllArgsConstructor
public class MinIoComponent {

    private MinioClient minioClient;

    public List<Object> list(String bucket) throws Exception {
        ListObjectsArgs listObjectsArgs = ListObjectsArgs.builder().bucket(bucket).build();
        Iterable<Result<Item>> objects = minioClient.listObjects(listObjectsArgs);
        Iterator<Result<Item>> iterator = objects.iterator();
        List<Object> items = new ArrayList<>();
        String format = "{'fileName':'%s','fileSize':'%s'}";
        while (iterator.hasNext()) {
            Item item = iterator.next().get();
            items.add(JSON.parse(String.format(format, item.objectName().replace("+", " "), formatFileSize(item.size()))));
        }
        return items;
    }

    public void get(String bucket, String fileName, HttpServletResponse response) {
        String fileType = fileName.split("\\.")[1];
        try (InputStream inputStream = minioClient.getObject(GetObjectArgs.builder().bucket(bucket).object(fileName).build());
             OutputStream os = response.getOutputStream()) {
            BufferedImage image = ImageIO.read(inputStream);
            response.setContentType("image/" + fileType);
            if (Objects.nonNull(image)) {
                ImageIO.write(image, fileType, os);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void upload(MultipartFile file, String bucketName) {
        try {
            PutObjectArgs putObjectArgs = PutObjectArgs.builder().
                    bucket(bucketName).object(file.getOriginalFilename())
                    .stream(file.getInputStream(), file.getSize(), -1).build();
            minioClient.putObject(putObjectArgs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isBucketExists(String bucketName) {
        try {
            return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String formatFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        String wrongSize = "0B";
        if (fileS == 0) {
            return wrongSize;
        }
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + " B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + " KB";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + " MB";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + " GB";
        }
        return fileSizeString;
    }
}
