package com.grupog35.reto3.service;


import com.grupog35.reto3.dbo.ScoreDbo;
import com.grupog35.reto3.model.ScoreModel;
import com.grupog35.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository scoreRepository;

    public List<ScoreModel> obtener(){
        return scoreRepository.findAll();
    }
    public void crear(ScoreModel score){
        if(!scoreRepository.existsById(score.getIdScore())) {
            scoreRepository.save(score);
        }

    }

    public void eliminar(int id){
        scoreRepository.deleteById(id);
    }

    public void actualizar(ScoreDbo scoreDbo){
        if(scoreRepository.existsById(scoreDbo.getIdScore())){
            ScoreModel score = scoreRepository.findById(scoreDbo.getIdScore()).get();
            score.setScore(scoreDbo.getScore());
            scoreRepository.save(score);
        }
    }


}
