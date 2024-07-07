package com.example.projektdb_sandradrzewiecka.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Comparator;

@Entity
public class Zestawienie {
    @Id
    private String nrKarty;
    private String data;
    private String kod;
    private float masa;
    private String jednostka;
    private int firma;
    private String typ;
    private String nazwa;
    private int nrMagazynu;
    private String opis;
    private Integer nrKlienta;

    public Zestawienie() { }

    public Zestawienie(MagazynP magazyn, Dostawca dostawca, Slownik slownik) {
        this.nrKarty = magazyn.getNrKarty();
        this.data = magazyn.getDataD();
        this.masa = magazyn.getMasa();
        this.jednostka = magazyn.getJednostka();
        this.firma = magazyn.getFirma();
        this.nrMagazynu = magazyn.getNrMagazynu();
        this.nrKlienta = magazyn.getNrKlienta();
        this.nazwa = dostawca.getNazwa();
        this.kod = slownik.getKod();
        this.typ = slownik.getTyp();
        this.opis = slownik.getOpis();
    }

    public String getNrKarty() {
        return nrKarty;
    }

    public String getData() {
        return data;
    }

    public String getKod() {
        return kod;
    }

    public float getMasa() {
        return masa;
    }

    public String getJednostka() {
        return jednostka;
    }

    public int getFirma() {
        return firma;
    }

    public String getTyp() {
        return typ;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getNrMagazynu() {
        return nrMagazynu;
    }

    public String getOpis() {
        return opis;
    }

    public Integer getNrKlienta() {
        return nrKlienta;
    }

    public static Comparator<String> getNrKartyComparator() {
        return (nrKarty1, nrKarty2) -> {
            String[] parts1 = nrKarty1.split("/");
            String[] parts2 = nrKarty2.split("/");

            int yearComparison = Integer.compare(Integer.parseInt(parts1[2]), Integer.parseInt(parts2[2]));
            if (yearComparison != 0) {
                return yearComparison;
            }

            int firmaComparison = parts1[1].compareTo(parts2[1]);
            if (firmaComparison != 0) {
                return firmaComparison;
            }

            return Integer.compare(Integer.parseInt(parts1[0]), Integer.parseInt(parts2[0]));
        };
    }

    @Override
    public String toString() {
        return  nrKarty + ';' + data + ';' + kod + ';' + masa + ';' + jednostka + ';' +
                firma + ';' + typ + ';' + nazwa + ';' + nrMagazynu + ';' + opis + ';' + nrKlienta;
    }
}
