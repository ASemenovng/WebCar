package com.webcar.WebCar.Controllers;

import com.webcar.WebCar.Repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorisationController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/login")
    public String greeting(Model model) {
        model.addAttribute("title", "Главная страница");
        return "login";
    }

    @PostMapping("/login")
    public String postAdd(@RequestParam String email,
                          @RequestParam String password,
                          Model model){
//        Post post = new Post(email, password);
//        postRepository.save(post);
        return "redirect:/rent";
    }

}