package com.mini.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description: 微信小程序 参数
 * @author: wei·man cui
 * @date: 2020/9/29 17:04
 */
@Getter
@Component
public class MiniAppValues {

    @Value("${mini.app_id}")
    private String appId;

    @Value("${mini.app_secret}")
    private String appSecret;

    @Value("${mini.uri}")
    private String uri;

    @Value("${mini.grant_type}")
    private String grantType;

}
