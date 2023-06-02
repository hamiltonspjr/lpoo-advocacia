package br.edu.ifsul.cstsi.advocacia.Custa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CustaRepository extends JpaRepository<Custa, Integer> {
    @Query(value = "SELECT c FROM Custa c where c.data = ?1")
    List<Custa> findByData(Date data);

    @Query(value = "SELECT c FROM Custa c where c.processoByCodprocesso = ?1")
    List<Custa> findByCodProcesso(Integer codProcesso);
}
