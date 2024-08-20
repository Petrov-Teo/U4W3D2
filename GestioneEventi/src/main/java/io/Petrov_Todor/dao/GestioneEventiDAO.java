package io.Petrov_Todor.dao;

import io.Petrov_Todor.entities.Evento;
import io.Petrov_Todor.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class GestioneEventiDAO {
    private final EntityManager em;

    public GestioneEventiDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        // Fase uno - chiediamo a Manager di fornirci una transazione
        EntityTransaction transaction = em.getTransaction();
        // Fase due - Eseguiamo la transazione
        transaction.begin();
        // Fase tre - Aggiungiamo l'oggetto al Persistence Context
        em.persist(evento);
        // Fase quattro - concludiamo la transazione
        transaction.commit();
        System.out.println(evento + "- E' stato salvato correttamente!");
    }

    public Evento findById(long id) {
        Evento find = em.find(Evento.class, id);
        if (find == null) throw new NotFoundException(id);
        return find;
    }

    public void findByIdAndDelete(long id) {
        // fase zero - ricerchiamo l'oggetto
        Evento find = this.findById(id);

        // Fase uno - chiediamo a Manager di fornirci una transazione
        EntityTransaction transaction = em.getTransaction();
        // Fase due - Eseguiamo la transazione
        transaction.begin();
        // Fase tre - Rimuoviamo l'oggetto al Persistence Context

        em.remove(find);
        // Fase quattro - concludiamo la transazione
        transaction.commit();

        System.out.println(id + " - E' stato eliminato!");
    }
}
