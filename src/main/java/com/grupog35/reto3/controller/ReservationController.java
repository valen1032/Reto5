package com.grupog35.reto3.controller;


import com.grupog35.reto3.dbo.ReservationDbo;
import com.grupog35.reto3.model.ReservationModel;
import com.grupog35.reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    @GetMapping ("/all")
    public List<ReservationModel> obtener(){
        return reservationService.obtener();

    }

    @PostMapping ("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ReservationModel reservation){
        reservationService.crear(reservation);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        reservationService.eliminar(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody ReservationDbo reservationDbo){
        reservationService.actualizar(reservationDbo);
    }



}
