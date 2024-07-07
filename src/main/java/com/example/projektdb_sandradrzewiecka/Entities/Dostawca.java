package com.example.projektdb_sandradrzewiecka.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dostawcy")
public class Dostawca {
    @Id
    private Integer nrKlienta;
    private String miejscowosc;
    private String ulica;
    private String nazwa;

    public Dostawca() {
    }

    public Dostawca(Integer nrKlienta, String miejscowosc, String ulica, String nazwa) {
        this.nrKlienta = nrKlienta;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public Integer getNrKlienta() {
        return nrKlienta;
    }

}
