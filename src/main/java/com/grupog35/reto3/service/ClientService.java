package com.grupog35.reto3.service;


import com.grupog35.reto3.dbo.ClientDbo;
import com.grupog35.reto3.model.ClientModel;
import com.grupog35.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<ClientModel> obtener(){

        return clientRepository.findAll();
    }
    public void crear(ClientModel model){
        if(!clientRepository.existsById(model.getIdClient())) {
            clientRepository.save(model);
        }
    }

    public void eliminar(int id){
        clientRepository.deleteById(id);
    }

    public void actualizar(ClientDbo clientDbo){
        if(clientRepository.existsById(clientDbo.getIdClient())){
            ClientModel client = clientRepository.findById(clientDbo.getIdClient()).get();
            client.setAge(clientDbo.getAge());
            client.setEmail(clientDbo.getEmail());
            client.setName(clientDbo.getName());
            client.setPassword(clientDbo.getPassword());
            clientRepository.save(client);
        }
    }




}
