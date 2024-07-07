package com.example.projektdb_sandradrzewiecka.Controllers;

import com.example.projektdb_sandradrzewiecka.Entities.Zestawienie;
import com.example.projektdb_sandradrzewiecka.Repositories.ZestawienieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZestawienieController {
    @Autowired
    private ZestawienieRepository zestawienieRepository;

    @GetMapping("/zestawienie")
    public List<Zestawienie> getAllZestawienie() {
        return zestawienieRepository.findAll();
    }

    @PostMapping("/zestawienie")
    public Zestawienie createZestawienie(@RequestBody Zestawienie zestawienie) {
        return zestawienieRepository.save(zestawienie);
    }
}
