package com.example.projektdb_sandradrzewiecka.Controllers;

import com.example.projektdb_sandradrzewiecka.Entities.MagazynP;
import com.example.projektdb_sandradrzewiecka.Repositories.MagazynPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MagazynPController {
    @Autowired
    private MagazynPRepository magazynPRepository;

    @GetMapping("/magazynp")
    public List<MagazynP> getAllMagazynP() {
        return magazynPRepository.findAll();
    }

    @PostMapping("/magazynp")
    public MagazynP createMagazynP(@RequestBody MagazynP magazynP) {
        return magazynPRepository.save(magazynP);
    }
}
