package br.edu.ifsul.cstsi.advocacia.Audiencia;

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
public class Audiencia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codaudiencia", nullable = false)
    private Integer codaudiencia;
    @Basic
    @Column(name = "data", nullable = false)
    private LocalDate data;
    @Basic
    @Column(name = "parecer", nullable = false, length = 255)
    private String parecer;
//    @Basic
//    @Column(name = "codprocesso", nullable = false)
//    private Integer codprocesso;
    @ManyToOne
    @JoinColumn(name = "codprocesso", referencedColumnName = "codprocesso", nullable = false)
    private Processo processoByCodprocesso;

    @Override
    public String toString() {
        return "\nAudiencia{" +
                "codaudiencia=" + codaudiencia +
                ", data=" + data +
                ", parecer='" + parecer + '\'' +
                ", processoByCodprocesso=" + processoByCodprocesso +
                '}';
    }
}
