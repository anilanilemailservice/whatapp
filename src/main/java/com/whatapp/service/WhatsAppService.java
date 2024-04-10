package com.whatapp.service;

import com.whatapp.payload.WhatsAppDto;

import java.util.List;

public interface WhatsAppService {
 WhatsAppDto sendMessage(WhatsAppDto dto);

 WhatsAppDto getMessageById(long id);
 List<WhatsAppDto> getAllMessages();

 public void deleteMessageById(long id);
}
