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

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private StorageServ storageServ;
    private Object Gson;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newsAndImgs", storageServ.getLastThreeNewsAndImgs());
        return "index";
    }

    @GetMapping("/catalog/catalog1")
    public String catalog1(Model model) {
        model.addAttribute("/catalog1");
        return "catalog1";

    }

    @GetMapping("/catalog/9seriaTTV")
    public String mod1(Model model) {
        model.addAttribute("/9seriaTTV");
        return "9seriaTTV";
    }

    @GetMapping("/catalog/6seria")
    public String mod2(Model model) {
        model.addAttribute("/6seria");
        return "6seria";
    }

    @GetMapping("/catalog/6seriaG")
    public String mod3(Model model) {
        model.addAttribute("/6seriaG");
        return "6seriaG";
    }

    @GetMapping("/catalog/6wseriaProfi")
    public String mod4(Model model) {
        model.addAttribute("/6wseriaProfi");
        return "6wseriaProfi";
    }

    @GetMapping("/catalog/6145whd")
    public String mod5(Model model) {
        model.addAttribute("/6145whd");
        return "6145whd";
    }

    @GetMapping("/catalog/agrofarm115g")
    public String mod6(Model model) {
        model.addAttribute("/agrofarm115g");
        return "agrofarm115g";
    }

    @GetMapping("/catalog/agroplusfvs")
    public String mod7(Model model) {
        model.addAttribute("/agroplusfvs");
        return "agroplusfvs";
    }

    @GetMapping("/catalog/agrolux480")
    public String mod8(Model model) {
        model.addAttribute("/agrolux480");
        return "agrolux480";
    }

    @GetMapping("/catalog/c7206")
    public String mod9(Model model) {
        model.addAttribute("/c7206");
        return "c7206";
    }






    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("/login");

        return "login";
    }

    @GetMapping("/newsadding")
    public String newsadding(Model model) {

        return "newsadding";
    }

    @PostMapping("/newsadding")
    public String newsAdd(@RequestParam String title, @RequestParam String announcement, @RequestParam String content, @RequestParam("files") MultipartFile[] files, Model model) {
        News n = new News(title, announcement, content);
        List<Integer> imgIdList = new ArrayList<Integer>();
        for (MultipartFile file: files) {
            imgIdList.add(storageServ.saveImgFile(file));
        }
        Gson gson = new Gson();
        String libId = gson.toJson(imgIdList);
        n.setImgLibJson(libId);
        newsRepository.save(n);

        return "redirect:/";
    }

    @GetMapping("/newsedit")
    public String newsedit(Model model) {

        model.addAttribute("newsAndImgs", storageServ.getAllNewsAndImgs());
        return "newsedit";

    }

    @GetMapping("/imgadd")
    public String imgadd(Model model) {
        List<ImgFile> imgs = storageServ.getFiles();
        model.addAttribute("imgs", imgs);
        return "imgadd";
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile (@PathVariable Integer fileId) {
        ImgFile img = storageServ.getFile(fileId).get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + img.getImgName() + "\"")
                .body(new ByteArrayResource(img.getData()));
    }

    @PostMapping("/deletenews/{idNews}")
    public String deletenews(@PathVariable(value = "idNews") int id) {
        storageServ.deleteNews(id);
        return "redirect:/newsedit";
    }



    @PostMapping("/imgadd")
    public String uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file: files) {
            storageServ.saveImgFile(file);
        }
        return "imgadd";
    }
}
