package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {


    @RequestMapping(value="/hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld(@RequestParam("name") String name){
        return "Hello "+name;
    }

}
