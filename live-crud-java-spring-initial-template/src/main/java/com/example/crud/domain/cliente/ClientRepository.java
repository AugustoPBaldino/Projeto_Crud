package com.example.crud.domain.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Cliente,String> {

    List<Cliente>findAllByActiveTrue();
}
