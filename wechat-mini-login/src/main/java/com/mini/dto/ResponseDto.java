package com.mini.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 小程序登录请求 微信端 相应信息
 * @author: wei·man cui
 * @date: 2020/9/29 17:34
 */
@Data
public class ResponseDto implements Serializable {

    /**
     * session key 不应该把会话密钥下发到小程序，也不应该对外提供这个密钥
     */
    @JsonIgnore
    private String session_key;

    private String openid;

    private int errcode;

    private String errmsg;

}
