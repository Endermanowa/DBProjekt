package com.example.projektdb_sandradrzewiecka.Repositories;

import com.example.projektdb_sandradrzewiecka.Entities.Dostawca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DostawcyRepository extends JpaRepository<Dostawca, Integer> {
    Dostawca findByNrKlienta(Integer nrKlienta);
}
