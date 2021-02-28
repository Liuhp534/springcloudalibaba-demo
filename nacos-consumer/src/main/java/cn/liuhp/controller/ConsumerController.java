package cn.liuhp.controller;

import cn.liuhp.config.ServerConfig;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: liuhp534
 * @create: 2021-02-28 13:56
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
@RefreshScope
public class ConsumerController {


    @Autowired
    private RestTemplate restTemplate;

    @Value(value = "${nacosConfigName}")
    public String nacosConfigName;


    private String serviceName = "http://nacos-provider";

    private String serviceUrl = "http://127.0.0.1:7001";

    @GetMapping("/sayHello")
    public String sayHello() {
        log.info("获取配置 {}", nacosConfigName);
        //return "xxx";
        //return restTemplate.getForObject(serviceUrl + "/provider/searchDate", String.class);
        return restTemplate.getForObject(serviceName + "/provider/searchDate", String.class);
    }

}
