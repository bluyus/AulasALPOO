package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cliente;

@Repository // Componente sprint do tipo repositório
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
