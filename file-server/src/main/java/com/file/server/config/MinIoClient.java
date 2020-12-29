package com.file.server.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: MinIO 文件服务器配置
 * @author: wei·man cui
 * @date: 2020/12/28 18:08
 */
@Configuration
public class MinIoClient {

    @Value("${minio.url}")
    private String url;

    @Value("${minio.username}")
    private String username;

    @Value("${minio.password}")
    private String password;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint(this.url).credentials(this.username, this.password).build();
    }

}


