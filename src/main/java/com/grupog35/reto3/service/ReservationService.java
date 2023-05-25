package com.grupog35.reto3.service;



import com.grupog35.reto3.dbo.ReportDbo;
import com.grupog35.reto3.dbo.ReservationDbo;
import com.grupog35.reto3.model.ReservationModel;
import com.grupog35.reto3.repository.ClientRepository;
import com.grupog35.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ClientRepository clientRepository;

    public List<ReservationModel> obtener(){

        return reservationRepository.findAll();
    }
    public void crear(ReservationModel reservation){
       if(!reservationRepository.existsById(reservation.getIdReservation())) {
           reservationRepository.save(reservation);
       }

    }

    public void eliminar(int id){
        reservationRepository.deleteById(id);
    }

    public void actualizar(ReservationDbo reservationDbo) {
        if(reservationRepository.existsById(reservationDbo.getIdReservation())){
            ReservationModel reservation = reservationRepository.findById(reservationDbo.getIdReservation()).get();
            reservation.setStartDate(reservationDbo.getStartDate());
            reservation.setDevolutionDate(reservationDbo.getDevolutionDate());
            reservation.setStatus("upgated");
            reservationRepository.save(reservation);
        }
    }

    public Optional<ReservationModel> obtenerPorId(int id){
        return reservationRepository.findById(id);
    }

    public List<ReservationModel> reportDate(String fechainicio, String fechafin) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-dd");
        Date fechainicioDate = format.parse(fechainicio);
        Date fechafinDate = format.parse(fechafin);
        if (fechafinDate.after(fechainicioDate)){
            System.out.println(fechainicioDate + "----" + fechafinDate);
            return reservationRepository.findByStartDateBetween(fechainicioDate,fechafinDate);
        }
        return null;
    }

    public ReportDbo reportStatus(){
        Integer cantidadCompletados = reservationRepository.countByStatus("completed");
        Integer cantidadCancelados = reservationRepository.countByStatus("cancelled");
        ReportDbo rta = new ReportDbo(cantidadCompletados,cantidadCancelados);
        return rta;
    }

}
