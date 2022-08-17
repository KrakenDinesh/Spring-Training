package com.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.domain.Sender;
import com.payment.repository.SenderRepository;

@RestController
@RequestMapping("/payment/sender")
public class SenderController {
	private final SenderRepository senderRepo;

	@Autowired
	public SenderController(SenderRepository senderRepo) {
		this.senderRepo = senderRepo;
	}

	@GetMapping
	public List<Sender> getAllSenderInfo() {
		return senderRepo.findAll();
	}

	@GetMapping("/{id}")
	public Sender getSenderById(@PathVariable String id) {
		Sender sender = senderRepo.findById(id).orElseThrow(RuntimeException::new);
		return sender;
	}

	@PutMapping("/{sender_Id}")
	public boolean updateSenderDetails(@PathVariable String sender_Id, @RequestBody Sender sender1) {
		Sender sender = senderRepo.findById(sender_Id).orElseThrow(RuntimeException::new);
		sender.setClearbalance(sender1.getClearbalance());
		senderRepo.save(sender);
		return true;
	}

}
