package com.grupog35.reto3.service;


import com.grupog35.reto3.dbo.ClientDbo;
import com.grupog35.reto3.dbo.ReportClientDbo;
import com.grupog35.reto3.model.ClientModel;
import com.grupog35.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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

    public Optional<ClientModel> obtenerPorId(int id){
        return clientRepository.findById(id);

    }

    public List<ReportClientDbo> reportClients(){
        List<ReportClientDbo> listReportClient = new LinkedList<>();
        List<ClientModel> listClient = clientRepository.findClientByStatusCompleted();
        for (ClientModel client : listClient){
            int totalReservation = client.getReservations().size();
            listReportClient.add(new ReportClientDbo(totalReservation,client));
        }
        return listReportClient;
    }


}
