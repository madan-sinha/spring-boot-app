package org.brightly.springbootapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public String hello() {
        return "Hello Spring-Boot !!";
    }

    @GetMapping("/{name}")
    public String helloName(@PathVariable("name") String name) {
        return "Hello "+name+", Welcome to Spring-Boot World !!";
    }
}