package com.example.crud.domain.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RequestClient(
        String id,
        String nome_cliente,
        String estado_civil,
        String situacao_profissional,
        String email,
        String apelido,
        boolean active
) {}
