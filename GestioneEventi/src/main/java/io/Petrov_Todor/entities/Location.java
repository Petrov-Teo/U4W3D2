package io.Petrov_Todor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private UUID id;
    private String nome;
    private String citta;

    public Location() {
    }

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public UUID getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Location_events{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", città='" + citta + '\'' +
                '}';
    }
}