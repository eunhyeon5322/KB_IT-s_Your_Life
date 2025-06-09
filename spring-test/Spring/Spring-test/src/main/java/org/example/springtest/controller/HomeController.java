package org.example.springtest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {
    //get 매서드에 대한 mapping
    @GetMapping("/")
    public String home() {
        log.info("==============================> HomeController /");
        return "index";
    }
}
