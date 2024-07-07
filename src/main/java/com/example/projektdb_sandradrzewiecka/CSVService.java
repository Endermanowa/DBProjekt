package com.example.projektdb_sandradrzewiecka;

import com.example.projektdb_sandradrzewiecka.Entities.Dostawca;
import com.example.projektdb_sandradrzewiecka.Entities.MagazynP;
import com.example.projektdb_sandradrzewiecka.Entities.MagazynW;
import com.example.projektdb_sandradrzewiecka.Entities.Slownik;
import com.example.projektdb_sandradrzewiecka.Repositories.DostawcyRepository;
import com.example.projektdb_sandradrzewiecka.Repositories.SlownikRepository;
import org.apache.commons.csv.CSVFormat;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVService {
    @Autowired
    private DostawcyRepository dostawcyRepository;
    @Autowired
    private SlownikRepository slownikRepository;

    public List<Dostawca> readCSVd(String resourcePath) throws IOException{
        List<Dostawca> dataList = new ArrayList<>();
        ClassPathResource resource = new ClassPathResource(resourcePath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                     .withDelimiter(';')
                     .withHeader("NR_KLIENTA","MIEJSCOWOSC","ULICA","NAZWA_SKROCONA")
                     .withSkipHeaderRecord())) {
            for (CSVRecord csvRecord : csvParser) {
                Dostawca data = new Dostawca(
                        Integer.parseInt(csvRecord.get("NR_KLIENTA").replaceAll("[^\\d]", "")),
                        csvRecord.get("MIEJSCOWOSC"),
                        csvRecord.get("ULICA"),
                        csvRecord.get("NAZWA_SKROCONA")
                );
                dataList.add(data);
            }
        }
        return dataList;
    }

    public List<Slownik> readCSVs(String resourcePath) throws IOException{
        List<Slownik> dataList = new ArrayList<>();
        ClassPathResource resource = new ClassPathResource(resourcePath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                     .withDelimiter(';')
                     .withHeader("GR","PODGR","RODZ","TYP","OPIS","NR_ODPADU")
                     .withSkipHeaderRecord())) {
            for (CSVRecord csvRecord : csvParser) {
                int gr;
                int podgr;
                int rodz;

                if(csvRecord.get("GR").isEmpty()){
                    gr=0;
                }
                else{
                    gr = Integer.parseInt(csvRecord.get("GR"));
                }

                if(csvRecord.get("PODGR").isEmpty()){
                    podgr=0;
                }
                else{
                    podgr = Integer.parseInt(csvRecord.get("PODGR"));
                }

                if(csvRecord.get("RODZ").isEmpty()){
                    rodz=0;
                }
                else{
                    rodz = Integer.parseInt(csvRecord.get("RODZ"));
                }

                Slownik data = new Slownik(
                        gr,
                        podgr,
                        rodz,
                        csvRecord.get("TYP"),
                        csvRecord.get("OPIS"),
                        Integer.parseInt(csvRecord.get("NR_ODPADU").replaceAll("[^\\d]", ""))
                );
                dataList.add(data);
            }
        }
        return dataList;
    }

    public List<MagazynP> readCSVp(String resourcePath) throws IOException{
        List<MagazynP> dataList = new ArrayList<>();
        ClassPathResource resource = new ClassPathResource(resourcePath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                     .withDelimiter(';')
                     .withHeader("NRKARTY","DATAD","MASA","JEDN","FIRMA","NR_MAG","NR_ODPADU","NR_KLIENTA")
                     .withSkipHeaderRecord())) {

            for (CSVRecord csvRecord : csvParser) {
                MagazynP data = new MagazynP(
                        csvRecord.get("NRKARTY"),
                        csvRecord.get("DATAD"),
                        Float.parseFloat(csvRecord.get("MASA").replaceAll("[^\\d.]", "")),
                        csvRecord.get("JEDN"),
                        Integer.parseInt(csvRecord.get("FIRMA")),
                        Integer.parseInt(csvRecord.get("NR_MAG").replaceAll("[^\\d]", "")),
                        Integer.parseInt(csvRecord.get("NR_ODPADU").replaceAll("[^\\d]", "")),
                        Integer.parseInt(csvRecord.get("NR_KLIENTA").replaceAll("[^\\d]", ""))
                );
                dataList.add(data);
            }
        }
        return dataList;
    }

    public List<MagazynW> readCSVw(String resourcePath) throws IOException{
        List<MagazynW> dataList = new ArrayList<>();
        ClassPathResource resource = new ClassPathResource(resourcePath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                     .withDelimiter(';')
                     .withHeader("NRKARTY","DATAW","MASA","FIRMA","JEDN","NR_MAGW","NR_ODPADU","NR_KLIENTA")
                     .withSkipHeaderRecord())) {

            for (CSVRecord csvRecord : csvParser) {
                MagazynW data = new MagazynW(
                        csvRecord.get("NRKARTY"),
                        csvRecord.get("DATAW"),
                        Float.parseFloat(csvRecord.get("MASA").replaceAll("[^\\d.]", "")),
                        Integer.parseInt(csvRecord.get("FIRMA")),
                        csvRecord.get("JEDN"),
                        Integer.parseInt(csvRecord.get("NR_MAGW").replaceAll("[^\\d]", "")),
                        Integer.parseInt(csvRecord.get("NR_ODPADU").replaceAll("[^\\d]", "")),
                        Integer.parseInt(csvRecord.get("NR_KLIENTA").replaceAll("[^\\d]", ""))
                );
                dataList.add(data);
            }
        }
        return dataList;
    }
}
