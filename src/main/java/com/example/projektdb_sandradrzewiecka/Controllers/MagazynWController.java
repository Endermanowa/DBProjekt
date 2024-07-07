package com.example.projektdb_sandradrzewiecka.Controllers;

import com.example.projektdb_sandradrzewiecka.Entities.MagazynW;
import com.example.projektdb_sandradrzewiecka.Repositories.MagazynWRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MagazynWController {
    @Autowired
    private MagazynWRepository magazynWRepository;

    @GetMapping("/magazynw")
    public List<MagazynW> getAllMagazynW() {
        return magazynWRepository.findAll();
    }

    @PostMapping("/magazynw")
    public MagazynW createMagazynW(@RequestBody MagazynW magazynW) {
        return magazynWRepository.save(magazynW);
    }
}
