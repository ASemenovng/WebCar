package com.webcar.WebCar.Controllers;

import com.webcar.WebCar.Models.Post;
import com.webcar.WebCar.Repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RegistrationController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/registration")
    public String authoMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "registration";
    }

    @PostMapping("/registration")
    public String postAdd(@RequestParam String email,
                          @RequestParam String name,
                          @RequestParam String surname,
                          @RequestParam String password,
                          Model model){
        Post post = new Post(email, name, surname, password);
        ResponseEntity.ok(postRepository.save(post));
        return "redirect:/rent";
    }

}
