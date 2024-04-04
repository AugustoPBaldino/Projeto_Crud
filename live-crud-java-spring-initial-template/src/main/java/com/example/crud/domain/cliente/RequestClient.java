package com.example.crud.domain.cliente;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RequestClient(
        @JsonProperty("id") String id,
        @JsonProperty("Nome_Cliente") String nomeCliente,
        @JsonProperty("Estado_Civil") String estadoCivil,
        @JsonProperty("Situacao_Profissional") String situacaoProfissional,
        @JsonProperty("Email") String email,
        @JsonProperty("Apelido") String apelido,
        boolean active
) {}
