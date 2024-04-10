package com.whatapp.controller;

import com.whatapp.payload.WhatsAppDto;
import com.whatapp.service.WhatsAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WhatsAppController {

    @Autowired
    private WhatsAppService service;

    //http://localhost:8080/api
    @PostMapping
    public ResponseEntity<WhatsAppDto> sendMessage(@RequestBody WhatsAppDto dto){
        WhatsAppDto whatsDto=service.sendMessage(dto);
        return new ResponseEntity<>(whatsDto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/id
    @GetMapping("/{id}")
    public ResponseEntity<WhatsAppDto> getMessageBiId(@PathVariable("id") long id){
        final WhatsAppDto messageById = service.getMessageById(id);
        return new ResponseEntity<>(messageById,HttpStatus.OK);
    }

    //http://localhost:8080/api
    @GetMapping
public List<WhatsAppDto> getAllMessages(){
        List<WhatsAppDto> dto=service.getAllMessages();
        return dto;
}
@DeleteMapping("/{id}")
public ResponseEntity<?> deleteMessageById(@PathVariable("id" )long id){
      service.deleteMessageById(id);
       return new ResponseEntity<>("deleted",HttpStatus.OK);
}
}
