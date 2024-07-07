package com.example.projektdb_sandradrzewiecka.Repositories;

import com.example.projektdb_sandradrzewiecka.Entities.Dostawca;
import com.example.projektdb_sandradrzewiecka.Entities.MagazynP;
import com.example.projektdb_sandradrzewiecka.Entities.Zestawienie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface MagazynPRepository extends JpaRepository<MagazynP, String> {
    @Query("SELECT new Zestawienie(mag, dost, slo) " +
            "FROM MagazynP mag " +
            "JOIN Dostawca dost ON mag.nrKlienta = dost.nrKlienta " +
            "JOIN Slownik slo ON mag.nrOdpadu = slo.nrOdpadu")
    List<Zestawienie> generateZestawienie();

    @Query("SELECT m.firma AS firma, SUM(m.masa) AS sumaMasa " +
            "FROM MagazynP m " +
            "JOIN Dostawca d ON m.nrKlienta = d.nrKlienta " +
            "JOIN Slownik s ON m.nrOdpadu = s.nrOdpadu " +
            "WHERE d.nrKlienta = :nrKlienta AND s.kod = :kod " +
            "GROUP BY m.firma")
    List<Map<String, Object>> findSumMasaByFirmaAndFilters(@Param("nrKlienta") Integer nrKlienta, @Param("kod") String kod);
}

