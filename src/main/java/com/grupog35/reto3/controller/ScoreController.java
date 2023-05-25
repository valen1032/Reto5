package com.grupog35.reto3.controller;


import com.grupog35.reto3.dbo.ScoreDbo;
import com.grupog35.reto3.model.ScoreModel;
import com.grupog35.reto3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;
    @GetMapping ("/all")
    public List<ScoreModel> obtener(){
        return scoreService.obtener();

    }

    @GetMapping("/{id}")
    public Optional<ScoreModel> obtenerPorId(@PathVariable int id){
        return scoreService.obtenerPorId(id);
    }


    @PostMapping ("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ScoreModel score){
        scoreService.crear(score);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        scoreService.eliminar(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody ScoreDbo scoreDbo){
        scoreService.actualizar(scoreDbo);
    }

}
