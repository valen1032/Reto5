package com.grupog35.reto3.controller;


import com.grupog35.reto3.dbo.GamaDbo;
import com.grupog35.reto3.model.GamaModel;
import com.grupog35.reto3.service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Gama")
public class GamaController {
    @Autowired
    GamaService gamaService;

    @GetMapping ("/all")
    public List<GamaModel> obtener(){
        return gamaService.obtener();

    }

    @PostMapping ("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody GamaModel gama){
        gamaService.crear(gama);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        gamaService.eliminar(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody GamaDbo gamaDbo){
        gamaService.actualizar(gamaDbo);
    }







}
