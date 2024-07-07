package com.example.projektdb_sandradrzewiecka.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Slownik {
    private int grupa;
    private int podgrupa;
    private int rodzina;
    private String kod;
    private String typ;
    @Column(length = 500)
    private String opis;
    @Id
    private int nrOdpadu;

    public Slownik(){ }

    public Slownik(int grupa, int podgrupa, int rodzina, String typ, String opis, int nrOdpadu){
        this.grupa = grupa;
        this.podgrupa = podgrupa;
        this.rodzina = rodzina;
        this.typ = typ;
        this.opis = opis;
        this.nrOdpadu = nrOdpadu;

        this.kod = String.format("%02d", grupa) + String.format("%02d", podgrupa) + String.format("%02d", rodzina);
    }

    public String getKod() {
        return kod;
    }

    public String getTyp() {
        return typ;
    }

    public String getOpis() {
        return opis;
    }

    public int getNrOdpadu() {
        return nrOdpadu;
    }
}
