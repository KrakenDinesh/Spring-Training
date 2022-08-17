package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.domain.Bank;

public interface BankRepository extends JpaRepository<Bank, String> {

}
