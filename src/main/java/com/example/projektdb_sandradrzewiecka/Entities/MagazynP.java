package com.example.projektdb_sandradrzewiecka.Entities;

import com.example.projektdb_sandradrzewiecka.Repositories.DostawcyRepository;
import com.example.projektdb_sandradrzewiecka.Repositories.SlownikRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MagazynP {
    private String nrKarty;
    private String dataD;
    private float masa;
    private String jednostka;
    private int firma;
    @Id
    private int nrMagazynu;
    private Integer nrOdpadu;
    private Integer nrKlienta;

    public MagazynP(){ }

    public MagazynP(String nrKarty, String dataD, float masa, String jednostka, int firma, int nrMagazynu, Integer nrOdpadu, Integer nrKlienta) {
        this.nrKarty = nrKarty;
        this.dataD = dataD;
        this.masa = masa;
        this.jednostka = jednostka;
        this.firma = firma;
        this.nrMagazynu = nrMagazynu;
        this.nrOdpadu = nrOdpadu;
        this.nrKlienta = nrKlienta;
    }

    public String getNrKarty() {
        return nrKarty;
    }

    public void setNrKarty(String nrKarty) {
        this.nrKarty = nrKarty;
    }

    public String getDataD() {
        return dataD;
    }

    public void setDataD(String dataD) {
        this.dataD = dataD;
    }

    public float getMasa() {
        return masa;
    }

    public void setMasa(float masa) {
        this.masa = masa;
    }

    public String getJednostka() {
        return jednostka;
    }

    public void setJednostka(String jednostka) {
        this.jednostka = jednostka;
    }

    public int getFirma() {
        return firma;
    }

    public void setFirma(int firma) {
        this.firma = firma;
    }

    public int getNrMagazynu() {
        return nrMagazynu;
    }

    public void setNrMagazynu(int nrMagazynu) {
        this.nrMagazynu = nrMagazynu;
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
