package br.edu.ifsul.cstsi.advocacia.Pessoa;

import br.edu.ifsul.cstsi.advocacia.Processo.Processo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codpessoa", nullable = false)
    private Integer codpessoa;
    @Basic
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;
    @Basic
    @Column(name = "endereco", nullable = false, length = 255)
    private String endereco;
    @Basic
    @Column(name = "bairro", nullable = false, length = 255)
    private String bairro;
    @Basic
    @Column(name = "cidade", nullable = false, length = 255)
    private String cidade;
    @Basic
    @Column(name = "cep", nullable = false, length = 255)
    private String cep;
    @Basic
    @Column(name = "uf", nullable = false, length = 255)
    private String uf;
    @Basic
    @Column(name = "telefone", nullable = false, length = 255)
    private String telefone;
    @Basic
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic
    @Column(name = "cpf", nullable = true, length = 255)
    private String cpf;
    @Basic
    @Column(name = "rg", nullable = true, length = 255)
    private String rg;
    @Basic
    @Column(name = "cpnj", nullable = true, length = 255)
    private String cpnj;
    @OneToMany(mappedBy = "pessoaByCodpessoa")
    private Collection<Processo> processosByCodpessoa;


}
