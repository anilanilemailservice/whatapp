package com.whatapp.service.impl;

import com.whatapp.entity.WhatsApp;
import com.whatapp.exception.MessageNotFoundException;
import com.whatapp.payload.WhatsAppDto;
import com.whatapp.repository.WhatsAppRepository;
import com.whatapp.service.WhatsAppService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WhatsAppServiceImpl implements WhatsAppService {
    @Autowired
    private WhatsAppRepository repo;

@Autowired
ModelMapper modelMapper;

    WhatsApp mapToEntity(WhatsAppDto dto){
        final WhatsApp map = modelMapper.map(dto, WhatsApp.class);
        return map;
    }
WhatsAppDto mapToDto(WhatsApp app){
    final WhatsAppDto map = modelMapper.map(app, WhatsAppDto.class);
    return map;
}
    @Override
    public WhatsAppDto sendMessage(WhatsAppDto dto) {
        WhatsApp app=mapToEntity(dto);
        WhatsApp whatApp=repo.save(app);
        final WhatsAppDto whatsAppDto = mapToDto(whatApp);
        return whatsAppDto;
    }

    @Override
    public WhatsAppDto getMessageById(long id) {


         WhatsApp whatsApp = repo.findById(id).orElseThrow(()->new MessageNotFoundException(id));
         WhatsAppDto whatsAppDto = mapToDto(whatsApp);
        return whatsAppDto;
    }

    @Override
    public List<WhatsAppDto> getAllMessages() {
         List<WhatsApp> all = repo.findAll();
        List<WhatsAppDto> collect = all.stream().map(x -> mapToDto(x)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void deleteMessageById(long id) {
          repo.findById(id).orElseThrow(() -> new MessageNotFoundException(id));
        repo.deleteById(id);
    }
}
