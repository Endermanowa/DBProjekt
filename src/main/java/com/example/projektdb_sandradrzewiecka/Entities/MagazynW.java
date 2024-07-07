package com.example.projektdb_sandradrzewiecka.Entities;

import com.example.projektdb_sandradrzewiecka.Repositories.DostawcyRepository;
import com.example.projektdb_sandradrzewiecka.Repositories.SlownikRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MagazynW {
    private String nrKarty;
    private String dataW;
    private float masa;
    private int firma;
    private String jednostka;
    @Id
    private int nrMagazynuW;
    private Integer nrOdpadu;
    private Integer nrKlienta;

    public MagazynW(){ }

    public MagazynW(String nrKarty, String dataW, float masa, int firma, String jednostka, int nrMagazynuW, Integer nrOdpadu, Integer nrKlienta) {
        this.nrKarty = nrKarty;
        this.dataW = dataW;
        this.masa = masa;
        this.firma = firma;
        this.jednostka = jednostka;
        this.nrMagazynuW = nrMagazynuW;
        this.nrOdpadu = nrOdpadu;
        this.nrKlienta = nrKlienta;
    }

    public String getNrKarty() {
        return nrKarty;
    }

    public void setNrKarty(String nrKarty) {
        this.nrKarty = nrKarty;
    }

    public String getDataW() {
        return dataW;
    }

    public void setDataW(String dataW) {
        this.dataW = dataW;
    }

    public float getMasa() {
        return masa;
    }

    public void setMasa(float masa) {
        this.masa = masa;
    }

    public int getFirma() {
        return firma;
    }

    public void setFirma(int firma) {
        this.firma = firma;
    }

    public String getJednostka() {
        return jednostka;
    }

    public void setJednostka(String jednostka) {
        this.jednostka = jednostka;
    }

    public int getNrMagazynuW() {
        return nrMagazynuW;
    }

    public void setNrMagazynuW(int nrMagazynuW) {
        this.nrMagazynuW = nrMagazynuW;
    }

    public Integer getNrOdpadu() {
        return nrOdpadu;
    }

    public void setNrOdpadu(Integer nrOdpadu) {
        this.nrOdpadu = nrOdpadu;
    }

    public Integer getNrKlienta() {
        return nrKlienta;
    }

    public void setNrKlienta(Integer nrKlienta) {
        this.nrKlienta = nrKlienta;
    }
}
