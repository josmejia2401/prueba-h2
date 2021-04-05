package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.CustomerEntidad;
import com.example.demo.servicios.CustomerServicio;

@RestController("/customers")
public class CustomerController {

	@Autowired
	CustomerServicio customerServicio;

	@GetMapping("/")
	private List<CustomerEntidad> getAll() {
		return customerServicio.getAll();
	}

	@GetMapping("/{id}")
	private CustomerEntidad getById(@PathVariable("id") int id) {
		return customerServicio.getById(id);
	}

	@DeleteMapping("/{id}")
	private void delete(@PathVariable("id") int id) {
		customerServicio.delete(id);
	}

	@PostMapping("/")
	private int save(@RequestBody CustomerEntidad customer) {
		customerServicio.saveOrUpdate(customer);
		return (int) customer.getId();
	}
}