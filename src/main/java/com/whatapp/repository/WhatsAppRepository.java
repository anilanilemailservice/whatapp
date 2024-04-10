package com.whatapp.repository;

import com.whatapp.entity.WhatsApp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhatsAppRepository extends JpaRepository<WhatsApp,Long> {
}
