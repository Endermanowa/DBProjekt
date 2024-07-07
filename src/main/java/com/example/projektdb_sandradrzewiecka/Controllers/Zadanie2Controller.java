package com.example.projektdb_sandradrzewiecka.Controllers;

import com.example.projektdb_sandradrzewiecka.Entities.MagazynP;
import com.example.projektdb_sandradrzewiecka.Repositories.MagazynPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Zadanie2Controller {
    @Autowired
    private MagazynPRepository magazynPRepository;

    @GetMapping("/zadanie2")
    public Map<Integer, Float> showZadanie2(
            @RequestParam(name = "nrKlienta") Integer nrKlienta,
            @RequestParam(name = "kod") String kod) {
        List<Map<String, Object>> results = magazynPRepository.findSumMasaByFirmaAndFilters(nrKlienta, kod);

        // Convert results to a Map<Integer, Float>
        Map<Integer, Float> firmaMasaMap = new HashMap<>();
        for (Map<String, Object> result : results) {
            Integer firma = (Integer) result.get("firma");
            Float sumaMasa = ((Number) result.get("sumaMasa")).floatValue();
            firmaMasaMap.put(firma, sumaMasa);
        }

        return firmaMasaMap;
    }
}
