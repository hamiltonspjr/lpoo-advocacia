package br.edu.ifsul.cstsi.advocacia.Advogado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AdvogadoRepository extends JpaRepository<Advogado,Integer> {
    @Query(value = "SELECT ad FROM Advogado ad where ad.nome like ?1")
    List<Advogado> findByNome(String nome);

    @Query(value = "SELECT ad FROM Advogado ad where ad.oab = ?1")
    Optional findByOab(String aob);
}
