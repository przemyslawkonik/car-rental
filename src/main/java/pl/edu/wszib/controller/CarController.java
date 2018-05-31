package pl.edu.wszib.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

    //TODO: write implementation to all those methods

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    @GetMapping
    public String getCarById() {
        return "car by id";
    }

    @RequestMapping(value = "/brand", method = RequestMethod.GET)
    @GetMapping
    public String getCarByBrand() {
        return "car by brand";
    }

    @RequestMapping(value = "/brand/model", method = RequestMethod.GET)
    @GetMapping
    public String getCarByModel() {
        return "car by model";
    }

    @RequestMapping(value = "/enginecapacity", method = RequestMethod.GET)
    @GetMapping
    public String getCarByEngineCapacity() {
        return "car by engine capacity";
    }

    @RequestMapping(value = "/enginetype", method = RequestMethod.GET)
    @GetMapping
    public String getCarByEngineType() {
        return "car by engine type";
    }

    @RequestMapping(value = "/car", method = RequestMethod.PUT)
    @GetMapping
    public String addCar() {
        return "added car";
    }

    @RequestMapping(value = "/id", method = RequestMethod.POST)
    @GetMapping
    public String updateCarById() {
        return "car updated";
    }

    @RequestMapping(value = "/id", method = RequestMethod.DELETE)
    @GetMapping
    public String delCarById() {
        return "car removed";
    }

}
