package com.grupog35.reto3.controller;


import com.grupog35.reto3.dbo.ReportClientDbo;
import com.grupog35.reto3.dbo.ReportDbo;
import com.grupog35.reto3.dbo.ReservationDbo;
import com.grupog35.reto3.model.ReservationModel;
import com.grupog35.reto3.service.ClientService;
import com.grupog35.reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    ClientService clientService;
    @GetMapping ("/all")
    public List<ReservationModel> obtener(){
        return reservationService.obtener();

    }

    @GetMapping("/{id}")
    public Optional<ReservationModel> obtenerPorId(@PathVariable int id ){
        return reservationService.obtenerPorId(id);
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

    @GetMapping("/report-dates/{fechainicio}/{fechafin}")
    public List<ReservationModel> reportDate(@PathVariable String fechainicio, @PathVariable String fechafin) throws ParseException {
        return reservationService.reportDate(fechainicio,fechafin);
    }

    @GetMapping("/report-status")
    public ReportDbo reportStatus(){
        return reservationService.reportStatus();
    }

    @GetMapping("/report-clients")
    public List<ReportClientDbo> reportClients(){
        return clientService.reportClients();
    }




}
