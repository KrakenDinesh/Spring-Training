package com.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.domain.Bank;
import com.payment.repository.BankRepository;

@RestController
@RequestMapping("/payment/bank")
public class BankController {
	public final BankRepository bankRepo;

	@Autowired
	public BankController(BankRepository bankRepo) {
		this.bankRepo = bankRepo;
	}

	@GetMapping
	public List<Bank> getAllBanks() {
		return bankRepo.findAll();
	}

	@GetMapping("/{bic}")
	public Bank getAllBanksByBic(@PathVariable String bic) {
		Bank bank = bankRepo.findById(bic).orElseThrow(RuntimeException::new);
		return bank;
	}

}
