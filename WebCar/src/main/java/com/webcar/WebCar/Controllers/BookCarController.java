package com.webcar.WebCar.Controllers;

import com.webcar.WebCar.Models.Car;
import com.webcar.WebCar.Models.User;
import com.webcar.WebCar.Repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookCarController {

    @Autowired
    CarRepository carRepository;

    @GetMapping("/book")
    public String book(Model model){
        model.addAttribute("title", "Your car");
        return "book";
    }

    @PostMapping("/book")
    public String book(
        @AuthenticationPrincipal User user,
        @RequestParam String modelcar,
        @RequestParam String price,
        Model model
    ){
        Car car = new Car(modelcar, price);
        carRepository.save(car);
        return "/";
    }
}
