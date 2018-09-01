package pl.edu.wszib.desktop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DesktopController {

    @RequestMapping("")
    @GetMapping
    public String showDesktopOverview() {
        return "desktop/overview";
    }
}