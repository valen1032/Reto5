package com.grupog35.reto3.repository;


import com.grupog35.reto3.model.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationModel,Integer> {

    //@Query(value = "SELECT * FROM reto5.reservation where start_date BETWEEN ? AND ?",nativeQuery = true)
    List<ReservationModel> findByStartDateBetween(Date fechaInicio, Date fechaFinal);

    Integer countByStatus(String status);
    
}
