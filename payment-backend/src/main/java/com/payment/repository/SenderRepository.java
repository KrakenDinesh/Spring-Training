package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.domain.Sender;

public interface SenderRepository extends JpaRepository<Sender, String>{

}
