package com.project.database.restController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log4j")
public class Log4jController {
    private static Logger log = LogManager.getLogger(Log4jController.class);

    @GetMapping("/example")
    public void log4jExample() {
        log.debug("This is debug");
        log.info("This is info");
        log.warn("This is warn");
        log.error("This is error");
        log.fatal("This is trace");
    }
}
