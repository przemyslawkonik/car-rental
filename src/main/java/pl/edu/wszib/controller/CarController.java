package pl.edu.wszib.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    //TODO: write implementation to all those methods

    @RequestMapping(value = "/{id}")
    @GetMapping
    public String getCarById(@PathVariable("id") Integer id) {
        return "car by id";
    }

    @RequestMapping(value = "/{brand}")
    @GetMapping
    public String getCarByBrand(@PathVariable("brand") String brand) {
        return "car by brand";
    }

    @RequestMapping(value = "/brand/{model}")
    @GetMapping
    public String getCarByModel(@PathVariable("model") String model) {
        return "car by model";
    }

    @RequestMapping(value = "/{enginecapacity}")
    @GetMapping
    public String getCarByEngineCapacity(@PathVariable("enginecapacity") String enginecapacity) {
        return "car by engine capacity";
    }

    @RequestMapping(value = "/enginetype")
    @GetMapping
    public String getCarByEngineType() {
        return "car by engine type";
    }

    @RequestMapping(value = "/car")
    @PutMapping
    public String addCar() {
        return "added car";
    }

    @RequestMapping(value = "/{id}")
    @PostMapping
    public String updateCarById(@PathVariable("id") Integer id) {
        return "car updated";
    }

    @RequestMapping(value = "/{id}")
    @DeleteMapping
    public String delCarById(@PathVariable("id") Integer id) {
        return "car removed";
    }

}
