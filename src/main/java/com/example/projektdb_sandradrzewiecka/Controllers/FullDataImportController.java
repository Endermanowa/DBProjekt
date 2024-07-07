package com.example.projektdb_sandradrzewiecka.Controllers;

import com.example.projektdb_sandradrzewiecka.CSVService;
import com.example.projektdb_sandradrzewiecka.Entities.Dostawca;
import com.example.projektdb_sandradrzewiecka.Entities.MagazynP;
import com.example.projektdb_sandradrzewiecka.Entities.MagazynW;
import com.example.projektdb_sandradrzewiecka.Entities.Slownik;
import com.example.projektdb_sandradrzewiecka.Repositories.DostawcyRepository;
import com.example.projektdb_sandradrzewiecka.Repositories.MagazynPRepository;
import com.example.projektdb_sandradrzewiecka.Repositories.MagazynWRepository;
import com.example.projektdb_sandradrzewiecka.Repositories.SlownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Profile("full")
@RestController
public class FullDataImportController implements CommandLineRunner {
    @Autowired
    private CSVService csvService;

    @Autowired
    private DostawcyRepository dostawcyRepository;
    @Autowired
    private SlownikRepository slownikRepository;
    @Autowired
    private MagazynPRepository magazynPRepository;
    @Autowired
    private MagazynWRepository magazynWRepository;

    private static final int BATCH_SIZE = 1000;


    @Override
    public void run(String... args) throws Exception {
        Instant start = Instant.now();

        System.out.println("Database import begin: Dostawcy");
        List<Dostawca> dostawcy = csvService.readCSVd("Dostawcy.csv");
        System.out.println("File parsed");
        for (int i = 0; i < dostawcy.size(); i += BATCH_SIZE) {
            int end = Math.min(i + BATCH_SIZE, dostawcy.size());
            List<Dostawca> batch = dostawcy.subList(i, end);
            dostawcyRepository.saveAll(batch);
            dostawcyRepository.flush();
        }
        System.out.println("Database import complete: Dostawcy");
        System.out.println("localhost:8080/dostawcy\n");

        System.out.println("Database import begin: Slownik");
        List<Slownik> slownik = csvService.readCSVs("Slownik.csv");
        System.out.println("File parsed");
        slownikRepository.saveAll(slownik);
        System.out.println("Database import complete: Slownik");
        System.out.println("localhost:8080/slownik\n");

        System.out.println("Database import begin: MagazynP");
        List<MagazynP> magazynP = csvService.readCSVp("Magazynp.csv");
        System.out.println("File parsed");
        for (int i = 0; i < magazynP.size(); i += BATCH_SIZE) {
            int end = Math.min(i + BATCH_SIZE, magazynP.size());
            List<MagazynP> batch = magazynP.subList(i, end);
            magazynPRepository.saveAll(batch);
            magazynPRepository.flush();
        }
        System.out.println("Database import complete: MagazynP");
        System.out.println("localhost:8080/magazynp\n");

        System.out.println("Database import begin: MagazynW");
        List<MagazynW> magazynW = csvService.readCSVw("Magazynw.csv");
        System.out.println("File parsed");
        for (int i = 0; i < magazynW.size(); i += BATCH_SIZE) {
            int end = Math.min(i + BATCH_SIZE, magazynW.size());
            List<MagazynW> batch = magazynW.subList(i, end);
            magazynWRepository.saveAll(batch);
            magazynWRepository.flush();
        }
        System.out.println("Database import complete: MagazynW");
        System.out.println("localhost:8080/magazynw\n");

        System.out.println("Database setup complete");

        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);
        System.out.println("Time taken for database setup: " + duration.toMinutes() + " minutes and " +
                (duration.getSeconds() % 60) + " seconds\n\n");

        System.out.println("Stworzenie zestawienia dla magazynu P: localhost:8080/zadanie1?strona=X&liczbaElementow=X");
        System.out.println("Posortowanie zestawienia: ");
        System.out.println("localhost:8080/zadanie1/sortByNrKarty?strona=X&liczbaElementow=X");
        System.out.println("localhost:8080/zadanie1/sortByKod?strona=X&liczbaElementow=X");
        System.out.println("localhost:8080/zadanie1/sortByFirma?strona=X&liczbaElementow=X");
        System.out.println("(X zastąpić wybranymi wartościami)\n");

        System.out.println("Suma mas magazynP: localhost:8080/zadanie2?nrKlienta=X&kod=XXXXXX (X zastąpić wybranymi wartościami)\n");

        System.out.println("Suma mas magazynW: localhost:8080/zadanie3?nrKlienta=X&kod=XXXXXX (X zastąpić wybranymi wartościami)\n");
    }
}
