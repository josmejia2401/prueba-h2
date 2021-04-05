package com.example.demo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.CustomerEntidad;

public interface ClienteRepositorio extends JpaRepository<CustomerEntidad, Long> {
	List<CustomerEntidad> findByFirstName(String firstName);
}