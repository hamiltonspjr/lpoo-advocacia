package br.edu.ifsul.cstsi.advocacia.Tribunal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TribunalRepository extends JpaRepository {
    @Query(value = "Select t FROM Tribunal t where t.denominacao like ?1")
    List<Tribunal> findByDenominacao(String denominacao);
}
