package cn.liuhp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @description:
 * @author: liuhp534
 * @create: 2021-02-28 14:01
 */
@RestController
@RequestMapping("/provider")
@Slf4j
public class ProviderController {

    @GetMapping("/searchDate")
    public String searchDate() {
        log.info("进入provider.searchDate");
        return new Date().toString();
    }


}
