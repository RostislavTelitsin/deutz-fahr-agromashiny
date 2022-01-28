package ru.deutzfahragromashiny.deutzfahragromashiny.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/catalog/catalog1")
    public String catalog1(Model model) {

        model.addAttribute("/catalog1");
        return "catalog1";

    }
}
