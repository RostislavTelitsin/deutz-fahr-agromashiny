package ru.deutzfahragromashiny.deutzfahragromashiny.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.deutzfahragromashiny.deutzfahragromashiny.repo.NewsRepository;
import ru.deutzfahragromashiny.deutzfahragromashiny.service.StorageServ;


import com.google.gson.Gson;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import ru.deutzfahragromashiny.deutzfahragromashiny.models.ImgFile;
import ru.deutzfahragromashiny.deutzfahragromashiny.models.News;
import ru.deutzfahragromashiny.deutzfahragromashiny.models.NewsAndImg;
import ru.deutzfahragromashiny.deutzfahragromashiny.repo.NewsRepository;
import ru.deutzfahragromashiny.deutzfahragromashiny.service.StorageServ;

@Controller
public class MainController {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private StorageServ storageServ;
    private Object Gson;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/catalog/catalog1")
    public String catalog1(Model model) {
        model.addAttribute("/catalog1");
        return "catalog1";

    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("/login");

        return "login";
    }
}
