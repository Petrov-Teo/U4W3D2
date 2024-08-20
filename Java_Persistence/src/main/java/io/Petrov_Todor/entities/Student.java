package io.Petrov_Todor.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "classe2024")
public class Student {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "cognome")
    private String surname;
    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TypeStudent typeStudent;

    public Student() {
    }


    public Student(String name, String surname, TypeStudent typeStudent) {
        this.name = name;
        this.surname = surname;
        this.typeStudent = typeStudent;
    }

    public long getId() {
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

    public TypeStudent getTypeStudent() {
        return typeStudent;
    }

    public void setTypeStudent(TypeStudent typeStudent) {
        this.typeStudent = typeStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", typeStudent=" + typeStudent +
                '}';
    }
}
