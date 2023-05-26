package br.edu.ifsul.cstsi.advocacia.Custa;

import br.edu.ifsul.cstsi.advocacia.Processo.Processo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Custa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codcusta", nullable = false)
    private Integer codcusta;
    @Basic
    @Column(name = "data", nullable = false)
    private Date data;
    @Basic
    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;
    @Basic
    @Column(name = "valor", nullable = false, precision = 2)
    private BigDecimal valor;
//    @Basic
//    @Column(name = "codprocesso", nullable = false)
//    private Integer codprocesso;
    @ManyToOne
    @JoinColumn(name = "codprocesso", referencedColumnName = "codprocesso", nullable = false)
    private Processo processoByCodprocesso;


}
