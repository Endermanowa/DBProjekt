package com.example.projektdb_sandradrzewiecka.Repositories;

import com.example.projektdb_sandradrzewiecka.Entities.MagazynP;
import com.example.projektdb_sandradrzewiecka.Entities.MagazynW;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface MagazynWRepository extends JpaRepository<MagazynW, String> {
    @Query("SELECT m.firma AS firma, SUM(m.masa) AS sumaMasa " +
            "FROM MagazynW m " +
            "JOIN Dostawca d ON m.nrKlienta = d.nrKlienta " +
            "JOIN Slownik s ON m.nrOdpadu = s.nrOdpadu " +
            "WHERE d.nrKlienta = :nrKlienta AND s.kod = :kod " +
            "GROUP BY m.firma")
    List<Map<String, Object>> findSumMasaByFirmaAndFilters(@Param("nrKlienta") Integer nrKlienta, @Param("kod") String kod);
}
