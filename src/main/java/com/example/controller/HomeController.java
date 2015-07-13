package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by arahansa on 2015-03-15.
 */
@Controller
public class HomeController {

    @Autowired
    ServletContext servletContext;

    @RequestMapping("/")
    public  String helloworld(HttpServletRequest request){
        String filePath = request.getServletContext().getRealPath("/");

        System.out.println(filePath);
        System.out.println("servlet context : "+servletContext.getRealPath("/"));
        System.out.println("context path:"+request.getServletContext().getContextPath());
        System.out.println("contexnt path:"+request.getContextPath());
        System.out.println(request.getServletPath());
        System.out.println(request.getServletContext());

        return "index";
    }


}
