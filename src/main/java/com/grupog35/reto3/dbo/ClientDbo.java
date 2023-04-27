package com.grupog35.reto3.dbo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDbo {

    private int idClient;
    private String email;
    private String password;
    private  String name;
    private int age;

}
