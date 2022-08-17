package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.domain.Message;

public interface MessageRepository extends JpaRepository<Message, String>{

}
