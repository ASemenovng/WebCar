package com.webcar.WebCar.Controllers;

import com.webcar.WebCar.Models.User;
import com.webcar.WebCar.Models.Role;
import com.webcar.WebCar.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String authoMain(Model model){
        Iterable<User> posts = userRepository.findAll();
        model.addAttribute("posts", posts);
        return "registration";
    }

    @PostMapping("/registration")
    public String postAdd(@RequestParam String email,
                          @RequestParam String name,
                          @RequestParam String surname,
                          @RequestParam String password,
                          Model model){
        User post = new User(email, name, surname, password);

        post.setRoles(Collections.singleton(Role.USER));
        ResponseEntity.ok(userRepository.save(post));

        return "redirect:/rent";
    }

}
