package com.project.database.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/ddos")
public class AntiDDosController {
    @GetMapping("/try")
    public ResponseEntity<String> tryToDDos() {
        return new ResponseEntity<String>("Try again", HttpStatus.OK); 
    }
}
