package com.example.projektdb_sandradrzewiecka.Controllers;

import com.example.projektdb_sandradrzewiecka.Entities.Zestawienie;
import com.example.projektdb_sandradrzewiecka.Repositories.MagazynPRepository;
import com.example.projektdb_sandradrzewiecka.Repositories.ZestawienieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class Zadanie1Controller {
    @Autowired
    private MagazynPRepository magazynPRepository;
    @Autowired
    private ZestawienieRepository zestawienieRepository;

    @GetMapping("/zadanie1")
    public List<Zestawienie> showZadanie1(@RequestParam(defaultValue = "0") int strona,
                                          @RequestParam(defaultValue = "10000") int liczbaElementow) {
        Pageable pageable = PageRequest.of(strona, liczbaElementow);

        if(zestawienieRepository.count() == 0){
            generateZestawienie();
        }

        Page<Zestawienie> zestawieniePage = zestawienieRepository.findAll(pageable);

        return zestawieniePage.getContent();
    }


    @GetMapping("/zadanie1/sortByNrKarty")
    public List<Zestawienie> showZadanie1SortedByNrKarty(@RequestParam(defaultValue = "0") int strona,
                                                         @RequestParam(defaultValue = "10") int liczbaElementow) {
        Pageable pageable = PageRequest.of(strona, liczbaElementow);

        if(zestawienieRepository.count() == 0){
            generateZestawienie();
        }

        List<Zestawienie> zestawienieList = new ArrayList<>(zestawienieRepository.findAll(pageable).getContent());

        zestawienieList.sort(Comparator.comparing(Zestawienie::getNrKarty, Zestawienie.getNrKartyComparator()));

        return zestawienieList;
    }

    @GetMapping("/zadanie1/sortByKod")
    public List<Zestawienie> showZadanie1SortedByKod(@RequestParam(defaultValue = "0") int strona,
                                                     @RequestParam(defaultValue = "10") int liczbaElementow) {
        Pageable pageable = PageRequest.of(strona, liczbaElementow);

        if(zestawienieRepository.count() == 0){
            generateZestawienie();
        }

        List<Zestawienie> zestawienieList = new ArrayList<>(zestawienieRepository.findAll(pageable).getContent());

        zestawienieList.sort(Comparator.comparing(Zestawienie::getKod));

        return zestawienieList;
    }

    @GetMapping("/zadanie1/sortByFirma")
    public List<Zestawienie> showZadanie1SortedByFirma(@RequestParam(defaultValue = "0") int strona,
                                                       @RequestParam(defaultValue = "10") int liczbaElementow) {
        Pageable pageable = PageRequest.of(strona, liczbaElementow);

        if(zestawienieRepository.count() == 0){
            generateZestawienie();
        }

        List<Zestawienie> zestawienieList = new ArrayList<>(zestawienieRepository.findAll(pageable).getContent());

        zestawienieList.sort(Comparator.comparing(Zestawienie::getFirma));

        return zestawienieList;
    }

    public void generateZestawienie() {
        Instant start = Instant.now();

        List<Zestawienie> zestawienieList = magazynPRepository.generateZestawienie();
        zestawienieRepository.saveAll(zestawienieList);

        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);
        System.out.println("Wygenerowano zestawienie w " + duration.toMinutes() + " minut i " +
                (duration.getSeconds() % 60) + " sekund");
    }
}
