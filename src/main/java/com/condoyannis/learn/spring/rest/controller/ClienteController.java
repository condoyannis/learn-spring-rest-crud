package com.condoyannis.learn.spring.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.condoyannis.learn.spring.rest.repository.Cliente;
import com.condoyannis.learn.spring.rest.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/consultar")
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> listarTodosPath() {
		return listarTodos();
	}
	
	@GetMapping("/{idCliente}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Cliente> listarCliente(@PathVariable Long idCliente) {
		return clienteRepository.findById(idCliente);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/{idCliente}")
	@ResponseStatus(HttpStatus.OK)
	public void removerCliente(@PathVariable Long idCliente) {
		Cliente cliente=new Cliente();
		cliente.setId(idCliente);
		clienteRepository.delete((cliente));
	}
	
	@DeleteMapping                                                         
	@ResponseStatus(HttpStatus.OK)
	public void removerTodosCliente() {
		clienteRepository.deleteAll();
	}
}