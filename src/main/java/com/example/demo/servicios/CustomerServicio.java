package com.example.demo.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.CustomerEntidad;
import com.example.demo.repositorios.ClienteRepositorio;

@Service
public class CustomerServicio {

	private static final org.apache.logging.log4j.Logger LOGGER = org.apache.logging.log4j.LogManager
			.getLogger(CustomerServicio.class);

	@Autowired
	ClienteRepositorio clienteRepositorio;

	public List<CustomerEntidad> getAll() {
		try {
			final List<CustomerEntidad> customers = new ArrayList<CustomerEntidad>();
			clienteRepositorio.findAll().forEach(customer -> customers.add(customer));
			return customers;
		} catch (Exception e) {
			LOGGER.error("[CustomerServicio.getAll]", e);
			throw e;
		}
	}

	public CustomerEntidad getById(long id) {
		try {
			return clienteRepositorio.findById(id).get();
		} catch (Exception e) {
			LOGGER.error("[CustomerServicio.getById]", e);
			throw e;
		}
	}

	public void saveOrUpdate(CustomerEntidad customer) {
		try {
			clienteRepositorio.save(customer);
		} catch (Exception e) {
			LOGGER.error("[CustomerServicio.saveOrUpdate]", e);
			throw e;
		}
	}

	public void delete(long id) {
		try {
			clienteRepositorio.deleteById(id);
		} catch (Exception e) {
			LOGGER.error("[CustomerServicio.delete]", e);
			throw e;
		}
	}
}