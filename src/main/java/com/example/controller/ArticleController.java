package com.example.controller;

import com.example.model.BoardArticle;
import com.example.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by arahansa on 2015-06-16.
 */
@Controller
public class ArticleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    ArticleRepository repository;
    @Autowired
    ServletContext servletContext;

    @RequestMapping(value="/blog", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("contents", repository.findAll());
        return "blog";
    }

    @RequestMapping(value = "/blog", method = RequestMethod.POST)
    public String save(BoardArticle article){
        repository.save(article);
        return "redirect:/";
    }
    private String uploadPath = System.getProperty("java.io.tmpdir");

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    @ResponseBody
    public String uploadByMultiparFile(
            @RequestParam("f") MultipartFile multipartFile,HttpServletRequest request,
             Model model) throws IOException {

        if(!multipartFile.isEmpty()){
            File file = new File(uploadPath, multipartFile.getOriginalFilename());


            //File file2 = new File(servletContext.getRealPath("/")+"/static/uploadimg/", multipartFile.getOriginalFilename());
            String webappRoot = servletContext.getRealPath("/");
            String relativeFolder = File.separator + "resources" + File.separator+ "static" + File.separator + "images" + File.separator;
            String filename = webappRoot + relativeFolder + multipartFile.getOriginalFilename();
            File file2 = new File(filename);

            multipartFile.transferTo(file);
            //multipartFile.transferTo(file2);
            model.addAttribute("fileName", multipartFile.getOriginalFilename());
            model.addAttribute("uploadPath", file.getAbsolutePath());
            model.addAttribute("uploadPath2", file2.getAbsolutePath());
            return model.toString();
        }
        return model.toString();
    }

    public byte[] getFile(String name) throws IOException {
        Path filePath = Paths.get("/", name);
        return Files.readAllBytes(filePath);
    }


}
