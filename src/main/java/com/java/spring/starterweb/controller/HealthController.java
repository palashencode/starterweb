package com.java.spring.starterweb.controller;

import com.fasterxml.jackson.databind.util.EnumValues;
import com.java.spring.starterweb.model.AppFeature;
import com.java.spring.starterweb.model.Status;
import com.java.spring.starterweb.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
//@RequestMapping(value="health")
public class HealthController {

    private static final Logger LOGGER = LogManager.getLogger(HealthController.class);

    @Autowired
    Environment env;

    @GetMapping("home")
    public String statusJSP(ModelMap model, HttpServletRequest request){

        String servletContext = env.getProperty("server.servlet.context-path");
        model.put("contextpath", servletContext);

        model.put("msg", "Home page of starterweb app, timestamp="+Instant.now().toEpochMilli());
        model.put("features", getFeatureList());
        return "home";
    }

    private List<AppFeature> getFeatureList(){
        return Stream.of(
                new AppFeature("Microservices","Rest Spring Boot App")
                ,new AppFeature("JSP","Serve JSP WebPages")
        ).collect(Collectors.toList());
    }

    @GetMapping("/freemarker")
    public Status statusFreeMarker(){
        LOGGER.info("status called");
        return new Status("UP-Freemarker","web-application is up!, timestamp ="+ Instant.now());
    }

}
