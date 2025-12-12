package com.jay.cohension.case1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AopController {

    @RequestMapping(value = "/demo1")
    public void demo1() {
        log.info("method - demo1 內容");
    }

    @RequestMapping(value = "/demo2")
    public void demo2() {
        log.info("method - demo2 內容");
        throw new RuntimeException("拋出的錯誤資訊");
    }

    @CustomizedAspect
    @RequestMapping(value = "/demo3")
    public void demo3() {
        log.info("method - demo3 內容");
    }


}
