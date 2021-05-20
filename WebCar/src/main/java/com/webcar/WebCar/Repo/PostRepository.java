package com.webcar.WebCar.Repo;

import com.webcar.WebCar.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<User, Long> {
}
