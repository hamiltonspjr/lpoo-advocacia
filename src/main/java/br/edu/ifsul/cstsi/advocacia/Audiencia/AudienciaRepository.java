package br.edu.ifsul.cstsi.advocacia.Audiencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AudienciaRepository extends JpaRepository<Audiencia, Integer> {

    @Query(value = "SELECT a FROM Audiencia a where a.data = ?1")
    List<Audiencia> findByData(LocalDate data);
}
