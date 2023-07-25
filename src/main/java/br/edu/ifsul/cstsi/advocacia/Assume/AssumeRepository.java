package br.edu.ifsul.cstsi.advocacia.Assume;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AssumeRepository extends JpaRepository<Assume, Integer>{
    @Query(value = "SELECT a FROM Assume a where a.dataInicio = ?1")
    List<Assume> findByDataInicio(LocalDate data);

    @Query(value = "SELECT a FROM Assume a where a.dataFinal = ?1")
    List<Assume> findByDataFinal(LocalDate data);
}
