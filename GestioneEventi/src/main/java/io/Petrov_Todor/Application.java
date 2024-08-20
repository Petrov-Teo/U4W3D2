package io.Petrov_Todor;

import io.Petrov_Todor.dao.GestioneEventiDAO;
import io.Petrov_Todor.entities.Evento;
import io.Petrov_Todor.entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneEventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        GestioneEventiDAO ev = new GestioneEventiDAO(em);

        //CREAZIONE EVENTI
        Evento eventoPetrovi = new Evento("EventoPetrovi",
                LocalDate.of(2024, 8, 20),
                "Festa privata in maschera",
                TipoEvento.PRIVATO,
                50);

        Evento eventoMorini = new Evento("Funerale",
                LocalDate.of(2023, 5, 1),
                "Evento privato + catering",
                TipoEvento.PRIVATO,
                23);

        Evento eventoCalemme = new Evento("Matrimonio Napoletano",
                LocalDate.of(2023, 4, 5),
                "Matrimonio tradizionale con musica dal vivo",
                TipoEvento.PUBBLICO,
                2860);
        Evento eventoTeatrale = new Evento("Spettacolo sotto le Stelle",
                LocalDate.of(2024, 8, 15),
                "Fornitura e organizzazione spazi esterni",
                TipoEvento.PUBBLICO,
                8500);

// DATA SAVING
/*
        try {
            ev.save(eventoPetrovi);
            ev.save(eventoMorini);
            ev.save(eventoCalemme);
            ev.save(eventoTeatrale);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
*/
//DATA RECOVERY
/*
        try {
            Evento recoveryCalemme = ev.findById(102);
            System.out.println(recoveryCalemme);
//DATA UPDATE

            recoveryCalemme.setTitolo("Festa in piazza");
            recoveryCalemme.setDescrizione("Viva la musica - evento musicale con musica dal vivo in piazza");
            ev.save(recoveryCalemme);
            System.out.println(recoveryCalemme);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
*/

    }
}
