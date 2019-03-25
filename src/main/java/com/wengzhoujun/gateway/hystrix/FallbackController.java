package com.wengzhoujun.gateway.hystrix;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/fallback")
    public String fallback() {
        JSONObject result = new JSONObject();
        result.put("success", false);
        result.put("message", "server error please try later");
        result.put("code", "fallback_error");
        result.put("result", null);
        result.put("timestamp", System.currentTimeMillis());
        logger.error("api-gateway触发熔断或重启中");
        return result.toJSONString();
    }

//    @HystrixCommand(commandKey="fallbackcmd")
//    public String fallbackcmd() {
//        JSONObject result = new JSONObject();
//        result.put("success", false);
//        result.put("message", "api-gateway触发断路由");
//        result.put("code", "");
//        result.put("result", null);
//        result.put("timestamp", System.currentTimeMillis());
//        return result.toJSONString();
//    }

}
