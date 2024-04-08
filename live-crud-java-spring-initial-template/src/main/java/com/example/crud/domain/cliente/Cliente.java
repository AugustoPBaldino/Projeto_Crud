package com.example.crud.domain.cliente;

import jakarta.persistence.*;
import lombok.*;

@Table(name="cliente")
@Entity(name="cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {


    @Id @GeneratedValue(strategy = GenerationType.UUID)

    private String  id;
    private String Nome_Cliente;
    private String Estado_Civil;
    private String Situacao_Profissional;
    private String Email;
    private String Apelido;
    private boolean active;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getNome_Cliente() {
        return Nome_Cliente;
    }

    public void setNome_Cliente(String nome_Cliente) {
        Nome_Cliente = nome_Cliente;
    }

    public String getEstado_Civil() {
        return Estado_Civil;
    }

    public void setEstado_Civil(String estado_Civil) {
        Estado_Civil = estado_Civil;
    }

    public String getSituacao_Profissional() {
        return Situacao_Profissional;
    }

    public void setSituacao_Profissional(String situacao_Profissional) {
        Situacao_Profissional = situacao_Profissional;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getApelido() {
        return Apelido;
    }

    public void setApelido(String apelido) {
        Apelido = apelido;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



    public Cliente(RequestClient requestClient) {
        this.Nome_Cliente = requestClient.nome_cliente();
        this.Estado_Civil = requestClient.estado_civil();
        this.Situacao_Profissional = requestClient.situacao_profissional();
        this.Email = requestClient.email();
        this.Apelido = requestClient.apelido();
        this.active = requestClient.active();
    }


}