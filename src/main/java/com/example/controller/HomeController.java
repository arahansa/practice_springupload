package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by arahansa on 2015-03-15.
 */
@Controller
public class HomeController {

    @RequestMapping("/") public  String helloworld(){
        return "index";
    }


}
