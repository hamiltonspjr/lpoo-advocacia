package br.edu.ifsul.cstsi.advocacia.Custa;

import br.edu.ifsul.cstsi.advocacia.Processo.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CustaRepository extends JpaRepository<Custa, Integer> {
    @Query(value = "SELECT c FROM Custa c where c.data = ?1")
    List<Custa> findByData(LocalDate data);

    @Query(value = "SELECT c FROM Custa c where c.processoByCodprocesso = ?1")
    List<Custa> findByCodProcesso(Processo processo);
}
