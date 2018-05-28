package pl.edu.wszib.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/hello")
    @GetMapping
    public String carHello() {
        return "Car controller in use";
    }
}
