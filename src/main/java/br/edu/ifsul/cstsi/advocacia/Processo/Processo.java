package br.edu.ifsul.cstsi.advocacia.Processo;

import br.edu.ifsul.cstsi.advocacia.Assume.Assume;
import br.edu.ifsul.cstsi.advocacia.Audiencia.Audiencia;
import br.edu.ifsul.cstsi.advocacia.Custa.Custa;
import br.edu.ifsul.cstsi.advocacia.Pessoa.Pessoa;
import br.edu.ifsul.cstsi.advocacia.Vara.Vara;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Processo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codprocesso", nullable = false)
    private Integer codprocesso;
    @Basic
    @Column(name = "numero", nullable = false, length = 255)
    private String numero;
    @Basic
    @Column(name = "abertura", nullable = false)
    private Date abertura;
    @Basic
    @Column(name = "conclusao", nullable = false)
    private Date conclusao;
    @Basic
    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;
    @Basic
    @Column(name = "situacao", nullable = false, length = 255)
    private String situacao;
//    @Basic
//    @Column(name = "codpessoa", nullable = false)
//    private Integer codpessoa;
//    @Basic
//    @Column(name = "codvara", nullable = false)
//    private Integer codvara;
    @OneToMany(mappedBy = "processoByCodprocesso")
    private Collection<Assume> assumesByCodprocesso;
    @OneToMany(mappedBy = "processoByCodprocesso")
    private Collection<Audiencia> audienciasByCodprocesso;
    @OneToMany(mappedBy = "processoByCodprocesso")
    private Collection<Custa> custasByCodprocesso;
    @ManyToOne
    @JoinColumn(name = "codpessoa", referencedColumnName = "codpessoa", nullable = false)
    private Pessoa pessoaByCodpessoa;
    @ManyToOne
    @JoinColumn(name = "codvara", referencedColumnName = "codvara", nullable = false)
    private Vara varaByCodvara;


}
