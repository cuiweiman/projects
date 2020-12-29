package com.file.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: MinIO文件服务
 * @author: wei·man cui
 * @date: 2020/12/28 17:50
 */
@SpringBootApplication
public class FileServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileServiceApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ 文件服务器启动成功 ლ(´ڡ`ლ)ﾞ");
    }
}
