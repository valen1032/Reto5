package com.grupog35.reto3.dbo;


import com.grupog35.reto3.model.ClientModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportClientDbo {

    public Integer total;
    private ClientModel client;

}
