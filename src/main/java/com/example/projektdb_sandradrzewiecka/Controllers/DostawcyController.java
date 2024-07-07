package com.example.projektdb_sandradrzewiecka.Controllers;

import com.example.projektdb_sandradrzewiecka.Entities.Dostawca;
import com.example.projektdb_sandradrzewiecka.Repositories.DostawcyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DostawcyController {

    @Autowired
    private DostawcyRepository dostawcyRepository;

    @GetMapping("/dostawcy")
    public List<Dostawca> getAllDostawcy() {
        return dostawcyRepository.findAll();
    }

    @PostMapping("/dostawcy")
    public Dostawca createDostawca(@RequestBody Dostawca dostawca) {
        return dostawcyRepository.save(dostawca);
    }
}
