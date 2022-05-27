package com.java.spring.starterweb.controller;

import com.java.spring.starterweb.model.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;

@RestController
public class StatusController {

    private static final Logger LOGGER = LogManager.getLogger(StatusController.class);

    @GetMapping( value="/status")
    public Status status(){
        LOGGER.info("status called");
        return new Status("UP","web-application is up!, timestamp ="+ Instant.now());
    }
}
