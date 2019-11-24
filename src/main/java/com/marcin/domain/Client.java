package com.marcin.domain;


import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String adress;
    private String email;

    public Client() {

    }

      /* zawsze klient nowy będzie miał ten identyfikator
        równy zero, bo używasz tutaj typy "int"
        więc możesz tak sprawdzać czy encja jest nowa czy nie
        Jakby był typ "String" to wtedy trzeba by było sprawdzić czy sting jest pusty.
        Jest to zwiazane z tym, że nowe obiekty z typami prymitywnymi są od razu inicjalizowane
        i taki int ma przy inicjalizacji 0
       */

    public boolean isNew() {
        return id == 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fitstName) {
        this.firstName = fitstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fitstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
