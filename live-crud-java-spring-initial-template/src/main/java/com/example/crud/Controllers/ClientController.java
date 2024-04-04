package com.example.crud.controllers;

import com.example.crud.domain.cliente.Cliente;
import com.example.crud.domain.cliente.ClientRepository;
import com.example.crud.domain.cliente.RequestClient;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @GetMapping
    public ResponseEntity getAllClients() {
        var allClients = repository.findAllByActiveTrue();
        return ResponseEntity.ok(allClients);
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid RequestClient data) {
        Cliente newProduct = new Cliente(data);
        repository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateClient(@RequestBody @Valid RequestClient data) {
        Optional<Cliente> optionalClient = repository.findById(data.id());
        if (optionalClient.isPresent()) {
            Cliente client = optionalClient.get();
            client.setNome_Cliente(data.nomeCliente());
            client.setEstado_Civil(data.estadoCivil());
            client.setSituacao_Profissional(data.situacaoProfissional());
            client.setEmail(data.email());
            client.setApelido(data.apelido());
            return ResponseEntity.ok(client);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteClient(@PathVariable String id) {
        Optional<Cliente> optionalClient = repository.findById(id);
        if (optionalClient.isPresent()) {
            Cliente client = optionalClient.get();
            client.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            throw new EntityNotFoundException();
        }
    }
}
