package com.example.projektdb_sandradrzewiecka.Repositories;

import com.example.projektdb_sandradrzewiecka.Entities.Slownik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlownikRepository extends JpaRepository<Slownik, String> {
    Slownik findByNrOdpadu(Integer nrOdpadu);
}
