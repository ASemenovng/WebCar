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
    public String registration(Model model){
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
      
        return "registration";
    }

//    @PostMapping("/registration")
//    public String addUser(@RequestParam String username,
//                          @RequestParam String name,
//                          @RequestParam String surname,
//                          @RequestParam String password,
//                          Model model) {
//        User user = new User(username, name, surname, password);
//
//        Iterable<User> users = userRepository.findAll();
//        model.addAttribute("users", users);
//
//        User userFromBd = userRepository.findByUsername(user.getUsername());
//
//        if (userFromBd != null) {
//            model.addAttribute("message", "The email exists!");
//            return "registration";
//        }
//
//        user.setActive(true);
//        user.setRoles(Collections.singleton(Role.USER));
//        ResponseEntity.ok(userRepository.save(user));
//
//        return "redirect:/login";
//    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        User userFromBd = userRepository.findByUsername(user.getUsername());

        if (userFromBd != null) {
            model.addAttribute("message", "The email exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        ResponseEntity.ok(userRepository.save(user));

        return "redirect:/login";
    }

}
