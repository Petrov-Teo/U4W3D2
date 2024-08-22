package io.Petrov_Todor.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Participation {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    private Person person_id;
    @ManyToOne
    private Evento evento_id;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Participation() {
    }

    public Participation(Person person_id, Evento evento_id, Stato stato) {
        this.person_id = person_id;
        this.evento_id = evento_id;
        this.stato = stato;
    }

    public UUID getId() {
        return id;
    }


    public Person getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Person person_id) {
        this.person_id = person_id;
    }

    public Evento getEvento_id() {
        return evento_id;
    }


    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "id=" + id +
                ", person_id=" + person_id +
                ", evento_id=" + evento_id +
                ", stato=" + stato +
                '}';
    }
}
