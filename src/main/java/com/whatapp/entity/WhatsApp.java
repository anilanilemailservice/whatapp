package com.whatapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class WhatsApp {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sendMessage;
    private String sendPhoto;
    private String sendContact;
    private long sendNumber;
}