package io.Petrov_Todor.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    private String mail;
    private LocalDate date_of_birth;
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @OneToMany(mappedBy = "id")
    private List<Participation> partecipation_list;

    public Person() {
    }

    public Person(String name, String surname, String mail, LocalDate date_of_birth, GenderType gender) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public List<Participation> getPartecipation_list() {
        return partecipation_list;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", date_of_birth=" + date_of_birth +
                ", gender=" + gender +
                ", partecipation_list=" + partecipation_list +
                '}';
    }
}


