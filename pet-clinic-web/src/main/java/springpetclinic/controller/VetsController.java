package springpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springpetclinic.model.Vet;
import springpetclinic.services.VetService;

import java.util.Set;


@Controller
@RequestMapping("/vets")
public class VetsController {

    private final VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/", "vets.html", "index", "index.html"})
    public String vets(Model theModel) {

        theModel.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

    @GetMapping("/api")
    public @ResponseBody Set<Vet> getVets(){

        return vetService.findAll();
    }
}
