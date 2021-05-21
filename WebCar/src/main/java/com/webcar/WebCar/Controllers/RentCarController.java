package com.webcar.WebCar.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RentCarController {

    @GetMapping("/rent")
    public String rent(Model model) {
        model.addAttribute("title", "Choose a car");
        return "rent";
    }

//    @PostMapping
//    public String rent()

}


