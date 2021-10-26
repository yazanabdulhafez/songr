package com.ASAC.songr.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePageController {

    @GetMapping("/")
    public String welcomeToHome(Model model){
        String greeting="Welcome To The Home Page";
        model.addAttribute("text",greeting);
        return "home";
    }

}
