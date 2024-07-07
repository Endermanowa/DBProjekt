package com.example.projektdb_sandradrzewiecka.Controllers;

import com.example.projektdb_sandradrzewiecka.Entities.Slownik;
import com.example.projektdb_sandradrzewiecka.Repositories.SlownikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SlownikController {
    @Autowired
    private SlownikRepository slownikRepository;

    @GetMapping("/slownik")
    public List<Slownik> getAllSlownik() {
        return slownikRepository.findAll();
    }

    @PostMapping("/slownik")
    public Slownik createSlownik(@RequestBody Slownik slownik) {
        return slownikRepository.save(slownik);
    }
}
