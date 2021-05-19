package com.webcar.WebCar.Repo;

import com.webcar.WebCar.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
