package com.grupog35.reto3.controller;


import com.grupog35.reto3.dbo.MessageDbo;
import com.grupog35.reto3.model.MessageModel;
import com.grupog35.reto3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    MessageService messageService;
    @GetMapping ("/all")
    public List<MessageModel> obtener(){
        return messageService.obtener();

    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody MessageModel message){
        messageService.crear(message);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        messageService.eliminar(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public  void actualizar(@RequestBody MessageDbo messageDbo){
        messageService.actualizar( messageDbo);
    }



}
