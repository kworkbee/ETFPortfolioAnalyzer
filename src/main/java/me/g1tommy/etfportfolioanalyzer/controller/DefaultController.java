package me.g1tommy.etfportfolioanalyzer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String main() {
        return "redirect:/swagger-ui.html";
    }
}
