package com.grupog35.reto3.dbo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDbo {

    private int idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status;

}
