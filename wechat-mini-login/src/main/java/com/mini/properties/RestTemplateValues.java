package com.mini.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>
 * http_pool:
 * max_total: 200
 * default_max_per_route: 100
 * connect_timeout: 5000
 * connection_request_timeout: 1000
 * socket_timeout: 65000
 * validate_after_inactivity: 2000
 * </p>
 *
 * @description: 读取参数
 * @author: wei·man cui
 * @date: 2020/9/29 16:54
 */
@Getter
@Component
public class RestTemplateValues {

    @Value("${http_pool.max_total}")
    private int maxTotal;

    @Value("${http_pool.default_max_per_route}")
    private int maxPerRoute;

    @Value("${http_pool.connect_timeout}")
    private int connTimeOut;

    @Value("${http_pool.connection_request_timeout}")
    private int connReqTimeOut;

    @Value("${http_pool.socket_timeout}")
    private int socketTimeout;

    @Value("${http_pool.validate_after_inactivity}")
    private int inactivity;

}
