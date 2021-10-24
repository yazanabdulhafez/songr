package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CapitalizeController {


    @GetMapping("/capitalize/{text}")
    public String capitalize(@PathVariable String text, Model model){
        String result=text.toUpperCase();
        model.addAttribute("result",result);
        return "capitalize.html";
    }
}
