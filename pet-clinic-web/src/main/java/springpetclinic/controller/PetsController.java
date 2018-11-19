package springpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/pets")
public class PetsController {


    @RequestMapping({"", "/" , "index" , "index.html"})
    public String pets(){
        return "pets/index";
    }
}
