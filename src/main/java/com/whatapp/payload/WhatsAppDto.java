package com.whatapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WhatsAppDto {

    private long id;
    private String sendMessage;
    private String sendPhoto;
    private String sendContact;
    private long sendNumber;
}
