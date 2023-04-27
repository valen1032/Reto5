package com.grupog35.reto3.service;


import com.grupog35.reto3.dbo.CarDbo;
import com.grupog35.reto3.model.CarModel;
import com.grupog35.reto3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public  List<CarModel> obtener(){
        return carRepository.findAll();

    }
    public void Crear(CarModel car){
        System.out.println(car.toString());
        if(!carRepository.existsById(car.getIdCar())) {
            carRepository.save(car);
        }
    }

    public void eliminar(int id){
        carRepository.deleteById(id);
    }

    public void actualizar(CarDbo carDbo){
        if(carRepository.existsById(carDbo.getIdCar())){
            CarModel car = carRepository.findById(carDbo.getIdCar()).get();
            car.setName(carDbo.getName());
            car.setBrand(carDbo.getBrand());
            car.setYear(carDbo.getYear());
            car.setDescription(carDbo.getDescription());
            carRepository.save(car);
        }
    }

}
