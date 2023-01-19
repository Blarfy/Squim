package com.example.squim.controller.rest;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class RESTController {
    @GetMapping("/createGame")
    public String createGame(HttpServletResponse response){
        return "Game created";
    }

    @GetMapping("/updateGame")
    public String updateGame(){
        return "Game updated";
    }
}
