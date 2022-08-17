package com.springbootdb.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdb.repository.ClientRepository;
import com.springbootdb.domain.Client;

@RestController
@RequestMapping("/clients")
public class ClientsController {
	private final ClientRepository clientRepository;

	public ClientsController(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	// lets list all the clients from the repo
	@GetMapping
	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	// display by id
	@GetMapping("/{id}")
	public Client getClient(@PathVariable Long id) {
		return clientRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	// adding
	@PostMapping
	public ResponseEntity createClient(@RequestBody Client client) throws URISyntaxException {
		Client savedClient = clientRepository.save(client);
		return ResponseEntity.created(new URI("/clients/" + savedClient.getId())).body(savedClient);
	}

	// update
	@PutMapping("/{id}")
	public ResponseEntity updateClient(@PathVariable Long id, @RequestBody Client client) {
		Client currentClient = clientRepository.findById(id).orElseThrow(RuntimeException::new);
		currentClient.setName(client.getName());
		currentClient.setEmail(client.getEmail());

		return ResponseEntity.ok(currentClient);
	}

	// delete
	@DeleteMapping("/{id}")
	public String deleteClient(@PathVariable Long id) {
		clientRepository.deleteById(id);
		return "Deleted";
	}

}
