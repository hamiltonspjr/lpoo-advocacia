package br.edu.ifsul.cstsi.advocacia.Advogado;

import br.edu.ifsul.cstsi.advocacia.Assume.Assume;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Advogado {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codadvogado", nullable = false)
    private Integer codadvogado;
    @Basic
    @Column(name = "oab", nullable = false, length = 255)
    private String oab;
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
    @Column(name = "cep", nullable = false, length = 255)
    private String cep;
    @Basic
    @Column(name = "email", nullable = false, length = 150)
    private String email;
    @OneToMany(mappedBy = "advogadoByCodadvogado")
    private Collection<Assume> assumesByCodadvogado;


}
