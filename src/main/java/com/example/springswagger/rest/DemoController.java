package com.example.springswagger.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public DemoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String get(@RequestParam String message){
        ResponseEntity<String> response = restTemplate.getForEntity("https://www.google.com/search?q=" + message, String.class);
        logger.info(response.getStatusCode().toString());
        logger.info(response.getBody());
        return response.getBody();
    }
}
