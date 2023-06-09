package br.edu.ifsul.cstsi.advocacia.Assume;

import br.edu.ifsul.cstsi.advocacia.Advogado.Advogado;
import br.edu.ifsul.cstsi.advocacia.Processo.Processo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Assume {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codassume", nullable = false)
    private Integer codassume;
    @Basic
    @Column(name = "dataInicio", nullable = false)
    private LocalDate dataInicio;
    @Basic
    @Column(name = "dataFinal", nullable = false)
    private LocalDate dataFinal;
    //@Basic
    //@Column(name = "codadvogado", nullable = false)
    //private Integer codadvogado;
    //@Basic
    //@Column(name = "codprocesso", nullable = false)
    //private Integer codprocesso;
    @ManyToOne
    @JoinColumn(name = "codadvogado", referencedColumnName = "codadvogado", nullable = false)
    private Advogado advogadoByCodadvogado;
    @ManyToOne
    @JoinColumn(name = "codprocesso", referencedColumnName = "codprocesso", nullable = false)
    private Processo processoByCodprocesso;

    @Override
    public String toString() {
        return "\nAssume{" +
                "codassume=" + codassume +
                ", dataInicio=" + dataInicio +
                ", dataFinal=" + dataFinal +
                ", advogadoByCodadvogado=" + advogadoByCodadvogado +
                ", processoByCodprocesso=" + processoByCodprocesso +
                '}';
    }
}
