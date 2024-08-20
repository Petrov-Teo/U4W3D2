package io.Petrov_Todor;

import io.Petrov_Todor.dao.GestioneEventiDAO;
import io.Petrov_Todor.entities.Evento;
import io.Petrov_Todor.entities.TipoEvento;
import io.Petrov_Todor.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneEventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        GestioneEventiDAO ev = new GestioneEventiDAO(em);

        Evento eventoPetrovi = new Evento("EventoPetrovi", LocalDate.of(2024, 8, 20), "Festa privata in maschera", TipoEvento.PRIVATO, 50);

        try {
            ev.save(eventoPetrovi);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }


    }


}
