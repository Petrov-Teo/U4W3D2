package io.Petrov_Todor.dao;

import io.Petrov_Todor.entities.Student;
import io.Petrov_Todor.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class StudentsDAO {

    private final EntityManager em;

    public StudentsDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Student student) {
        // Fase uno - chiediamo a Manager di fornirci una transazione
        EntityTransaction transaction = em.getTransaction();
        // Fase due - Eseguiamo la transazione
        transaction.begin();
        // Fase tre - Aggiungiamo l'oggetto al Persistence Context
        em.persist(student);
        // Fase quattro - concludiamo la transazione
        transaction.commit();
        System.out.println(student + "- E' stato salvato correttamente!");
    }

    public Student findById(long studentId) {
        Student found = em.find(Student.class, studentId);
        if (found == null) throw new NotFoundException(studentId);
        return found;
    }

    public void findByIdAndDelete(long studentId) {
        // fase zero - ricerchiamo l'oggetto
        Student found = this.findById(studentId);

        // Fase uno - chiediamo a Manager di fornirci una transazione
        EntityTransaction transaction = em.getTransaction();
        // Fase due - Eseguiamo la transazione
        transaction.begin();
        // Fase tre - Rimuoviamo l'oggetto al Persistence Context

        em.remove(found);
        // Fase quattro - concludiamo la transazione
        transaction.commit();

        System.out.println(studentId + " - E' stato eliminato!");
    }
}
