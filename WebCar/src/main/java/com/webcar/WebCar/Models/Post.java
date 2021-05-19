package com.webcar.WebCar.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "post_role", joinColumns = @JoinColumn(name = "post_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private String email, name, surname, password;
    private int rating;

    public Post(String email, String name, String surname, String  password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public Post(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Post() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String sername) {
        this.surname = sername;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public int getRating() {
        return rating;
    }

    @Id
    public Long getId() {
        return id;
    }
}