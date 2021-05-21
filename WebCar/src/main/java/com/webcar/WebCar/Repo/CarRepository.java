package com.webcar.WebCar.Repo;

import com.webcar.WebCar.Models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByModel(String model);
}
