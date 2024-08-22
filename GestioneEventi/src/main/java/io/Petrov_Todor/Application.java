package io.Petrov_Todor;

import io.Petrov_Todor.dao.GestioneEventiDAO;
import io.Petrov_Todor.dao.LocationEventsDAO;
import io.Petrov_Todor.dao.ParticipationDAO;
import io.Petrov_Todor.dao.PersonDAO;
import io.Petrov_Todor.entities.*;
import io.Petrov_Todor.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneEventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        GestioneEventiDAO gestioneEventiDAO = new GestioneEventiDAO(em);
        LocationEventsDAO locationEventsDAO = new LocationEventsDAO(em);
        ParticipationDAO participationDAO = new ParticipationDAO(em);
        PersonDAO personDAO = new PersonDAO(em);
//___________________________________________________ VARIABILI ID_________________________________________
        Location hiltonId = locationEventsDAO.findById("4acd44a5-f561-41d4-a0f8-b79e1febbade");
        Location torinoId = locationEventsDAO.findById("c5ae7fde-34aa-4b22-9155-03dba168b263");
        Location miamiId = locationEventsDAO.findById("4dd5a772-a66a-40b7-a65d-d3563919ab2d");
        Location vivaNapoliId = locationEventsDAO.findById("789e4c51-1f83-4441-9561-61774903a098");
        Person calemmeID = personDAO.findById("5a3126af-f3bf-4f0b-a331-6b7e90e39bb4");
        Person marianiID = personDAO.findById("6a040b50-e25a-4cf4-9cac-bd171f2ebbd7");
        Person colliID = personDAO.findById("a2fd9df3-22d6-4579-9098-2a2f3583963c");
        Evento petroviEventoID = gestioneEventiDAO.findById("9c053e79-e71f-472d-bc11-c224e7f8b706");
        Evento funeraleEventoID = gestioneEventiDAO.findById("cc8dd338-7380-49aa-9569-c94f7ef97063");
        Evento matimonioEventoID = gestioneEventiDAO.findById("af1e2730-f259-4264-8276-12a5e57fec89");


        //CREAZIONE EVENTI
        Evento eventoPetrovi = new Evento("EventoPetrovi",
                LocalDate.of(2024, 8, 20),
                "Festa privata in maschera",
                TipoEvento.PRIVATO,
                50, hiltonId);

        Evento eventoMorini = new Evento("Funerale",
                LocalDate.of(2023, 5, 1),
                "Evento privato + catering",
                TipoEvento.PRIVATO,
                23, miamiId);

        Evento eventoCalemme = new Evento("Matrimonio Napoletano",
                LocalDate.of(2023, 4, 5),
                "Matrimonio tradizionale con musica dal vivo",
                TipoEvento.PUBBLICO,
                2860, torinoId);
        Evento eventoTeatrale = new Evento("Spettacolo sotto le Stelle",
                LocalDate.of(2024, 8, 15),
                "Fornitura e organizzazione spazi esterni",
                TipoEvento.PUBBLICO,
                8500, vivaNapoliId);

// DATA SAVING

//        try {
//            gestioneEventiDAO.save(eventoPetrovi);
//            gestioneEventiDAO.save(eventoMorini);
//            gestioneEventiDAO.save(eventoCalemme);
//            gestioneEventiDAO.save(eventoTeatrale);
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }

//DATA RECOVERY

//        try {
//            Evento recoveryCalemme = gestioneEventiDAO.findById(102);
//            System.out.println(recoveryCalemme);
//DATA UPDATE

//            recoveryCalemme.setTitolo("Festa in piazza");
//            recoveryCalemme.setDescrizione("Viva la musica - evento musicale con musica dal vivo in piazza");
//            gestioneEventiDAO.save(recoveryCalemme);
//            System.out.println(recoveryCalemme);
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
        Location locationHilton = new Location("Hilton", "Roma");
        Location locationMiami = new Location("Miami", "Miami");
        Location locationSinfoni = new Location("Sinfoni", "Torino");
        Location locationNapoli = new Location("Viva", "Napoli");

//        try {
//
//            locationEventsDAO.save(locationHilton);
//            locationEventsDAO.save(locationMiami);
//            locationEventsDAO.save(locationSinfoni);
//            locationEventsDAO.save(locationNapoli);
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }


        Person person1 = new Person("Antonio",
                "Calemme",
                "calemme@gmail.com",
                LocalDate.of(1991, 9, 13),
                GenderType.MALE);
        Person person2 = new Person("Maria",
                "Mariani",
                "mariani@gmail.com",
                LocalDate.of(1986, 7, 25),
                GenderType.FEMALE);
        Person person3 = new Person("Stefania",
                "Colli",
                "colli@gmail.com",
                LocalDate.of(1981, 4, 1),
                GenderType.FEMALE);

//        try {
//            personDAO.save(person1);
//            personDAO.save(person2);
//            personDAO.save(person3);
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
// ************************************************** PARTECIPATION ****************************************************************************************

        Participation participation1 = new Participation(calemmeID, petroviEventoID, Stato.CONFERMATO);
        Participation participation2 = new Participation(marianiID, funeraleEventoID, Stato.DA_CONFERMARE);
        Participation participation3 = new Participation(colliID, matimonioEventoID, Stato.CONFERMATO);

        try {
            participationDAO.save(participation1);
            participationDAO.save(participation2);
            participationDAO.save(participation3);

        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
