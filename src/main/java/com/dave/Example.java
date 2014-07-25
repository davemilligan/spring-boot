package com.dave;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequestMapping("/Example")
public class Example {
	
    @RequestMapping("/")
    String home() {
        return "Hello World2!";
    }

}