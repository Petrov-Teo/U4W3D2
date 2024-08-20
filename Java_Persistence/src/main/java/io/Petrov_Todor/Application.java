package io.Petrov_Todor;

import io.Petrov_Todor.dao.StudentsDAO;
import io.Petrov_Todor.entities.Student;
import io.Petrov_Todor.entities.TypeStudent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("prova");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        StudentsDAO sd = new StudentsDAO(em);

        Student pippp = new Student("Pippo", "Fini", TypeStudent.ECONOMIA);
        Student gino = new Student("Gino", "Conissimo", TypeStudent.FINANZA);
        Student mimma = new Student("Mimma", "Dotti", TypeStudent.MATEMATICA);
/*    SALVA ELEMENTI
        try {
            sd.save(pippp);
            sd.save(gino);
            sd.save(mimma);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
*/
        /*RICHIAMA ELEMENTI
        try {
            Student findStudent = sd.findById(1);
            System.out.println(findStudent);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

*/
        /* ELIMINIAMO UN OGGETTO

        try {
            sd.findByIdAndDelete(1);

        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
         */


    }


}
