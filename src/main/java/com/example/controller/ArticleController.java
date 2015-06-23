package com.example.controller;

import com.example.model.BoardArticle;
import com.example.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by arahansa on 2015-06-16.
 */
@Controller
public class ArticleController {

    @Autowired
    ArticleRepository repository;

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


}
