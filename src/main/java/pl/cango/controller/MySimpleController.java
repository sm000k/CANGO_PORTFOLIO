package pl.cango.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.cango.service.HeartbeatService;

@RestController
public class MySimpleController {

    @RequestMapping("/")
    public String hello() {

        return "Hello, World";

    }

}
