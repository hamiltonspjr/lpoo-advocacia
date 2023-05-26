package br.edu.ifsul.cstsi.advocacia.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    @Query(value = "SELECT p FROM Pessoa p where p.nome like ?1")
    List<Pessoa> findByNome(String nome);

    @Query(value = "SELECT p FROM Pessoa p where p.cpf = ?1")
    Optional findByCpf(String cpf);

    @Query(value = "SELECT p FROM Pessoa p where p.rg = ?1")
    Optional findByRg(String rg);

    @Query(value = "SELECT p FROM Pessoa p where p.cpnj = ?1")
    Optional findByCnpj(String cnpj);
}
