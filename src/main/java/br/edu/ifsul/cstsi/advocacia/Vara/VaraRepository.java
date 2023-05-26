package br.edu.ifsul.cstsi.advocacia.Vara;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VaraRepository extends JpaRepository<Vara, Integer> {
    @Query(value = "SELECT v FROM Vara v where v.nome like ?1")
    List<Vara> findByNome(String nome);
}
