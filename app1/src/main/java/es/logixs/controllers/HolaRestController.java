package es.logixs.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaRestController {
    
    @RequestMapping("/hola")
    public String hola() {
    
        return "hola spring";
    }
}
