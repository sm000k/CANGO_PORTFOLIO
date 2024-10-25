package pl.cango.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MySimpleController {

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }

}
