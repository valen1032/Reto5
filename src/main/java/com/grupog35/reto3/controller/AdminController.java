package com.grupog35.reto3.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {


    @GetMapping ("/all")
    public void obtenerAdmin(){

    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crearAdmin(){

    }

}
