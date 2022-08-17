package com.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.domain.Transaction;
import com.payment.repository.TransactionRepository;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	public final TransactionRepository transRepo;

	@Autowired
	public TransactionController(TransactionRepository transRepo) {
		this.transRepo = transRepo;
	}

	@GetMapping
	public List<Transaction> getAllTransaction() {
		return transRepo.findAll();
	}

	@PostMapping
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		return transRepo.save(transaction);
	}

	@GetMapping("{transaction_Id}")
	public Transaction getAllTransactionById(@PathVariable long transaction_Id) {
		Transaction transaction = transRepo.findById(transaction_Id).orElseThrow(RuntimeException::new);
		return transaction;
	}

}
