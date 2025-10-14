package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.repository.IClienteRepository;

@RestController // Indica que a classe é um controller
@RequestMapping("/cliente") // Estabelece a rota base do controller
public class ClienteController {

	@Autowired // cria uma instância automaticamente
	private IClienteRepository clienteRepository;
	
	@GetMapping // Quando houver um get nesse controller, esse método irá responder
	public List<Cliente> listar()
	{
		return clienteRepository.findAll();
	}
	
	@GetMapping(params = "id")
	public ResponseEntity<Cliente> getCliente(@RequestParam Long id) {
	    var cliente = clienteRepository.findById(id);
	    
	    if (cliente.isPresent())
	        return ResponseEntity.ok(cliente.get());
	    else
	        return ResponseEntity.notFound().build();
	}
	
	@PostMapping // Quando houver um post nesse controller, esse método irá responder
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente)
	{
		return clienteRepository.save(cliente);
	}
}
