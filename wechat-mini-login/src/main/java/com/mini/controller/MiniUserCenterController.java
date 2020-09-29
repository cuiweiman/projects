package com.mini.controller;

import com.mini.dto.ResponseDto;
import com.mini.properties.MiniAppValues;
import com.mini.utils.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: 小程序 用户中心
 * @author: wei·man cui
 * @date: 2020/9/29 16:49
 */
@Slf4j
@RestController
@RequestMapping("mini")
public class MiniUserCenterController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MiniAppValues miniAppValues;

    private static final String APP_ID = "appid=";
    private static final String APP_SECRET = "secret=";
    private static final String JS_CODE = "js_code=";
    private static final String GRANT_TYPE = "grant_type=";
    private static final String SEPARATE = "&";


    /**
     * @param param code
     * @return 用户信息
     */
    @PostMapping("login")
    public Object miniLogin(@RequestBody Map<String, String> param) {
        String code = param.get("code");
        log.info("【code】= {}", code);
        String requestUri = miniAppValues.getUri() + APP_ID + miniAppValues.getAppId() + SEPARATE
                + APP_SECRET + miniAppValues.getAppSecret() + SEPARATE
                + JS_CODE + code + SEPARATE
                + GRANT_TYPE + miniAppValues.getGrantType();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(requestUri, String.class);
        return JacksonUtil.jsonToPojo(responseEntity.getBody(), ResponseDto.class);
    }
}
