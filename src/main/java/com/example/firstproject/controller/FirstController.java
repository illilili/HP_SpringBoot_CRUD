package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")

    public String nice(Model model){
        model.addAttribute("username","김경문");
        return "greetings";
    }

    @GetMapping("/bye")
    public String see(Model model) {
        model.addAttribute("nick","경문");
        return "goodbye";
    }
}
