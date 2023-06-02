package br.edu.ifsul.cstsi.advocacia.Processo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProcessoRepository extends JpaRepository<Processo, Integer> {
    @Query(value = "SELECT p FROM Processo p where p.numero = ?1")
    Optional findByNumero(String numero);
}
