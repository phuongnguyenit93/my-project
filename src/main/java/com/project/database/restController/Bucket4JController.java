package com.project.database.restController;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.database.service.Bucket4JService;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;

@RestController
@RequestMapping("/bucket")
public class Bucket4JController {

    @Autowired
    Bucket4JService bucket4jService;

    @Autowired
    Bucket limit5PerMinute;

    @GetMapping("/limit5") 
    public ResponseEntity<String> consumeTest() {
        ConsumptionProbe probe = bucket4jService.consumeToken(limit5PerMinute, 1);
        if (probe.isConsumed()) {
            return new ResponseEntity<String>("Còn " + probe.getRemainingTokens() + " tokens", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Hết token, chờ " + TimeUnit.NANOSECONDS.toSeconds(probe.getNanosToWaitForRefill()) + " giây nữa", HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
        }
    }
}
