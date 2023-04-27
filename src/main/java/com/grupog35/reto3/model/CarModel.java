package com.grupog35.reto3.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idCar;
    @Column(length = 45)
    private  String name;
    @Column(length = 45)
    private String brand;
    @Column (name = "yyear")
    private int year;
    @Column(length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_gama", nullable = false)
    @JsonIgnoreProperties({"cars"})
    private GamaModel gama;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "car")
    @JsonIgnoreProperties({"client", "car"})
    private List<MessageModel> messages;

    @OneToMany(cascade = CascadeType.PERSIST , mappedBy = "car")
    private List<ReservationModel> reservations;



}
