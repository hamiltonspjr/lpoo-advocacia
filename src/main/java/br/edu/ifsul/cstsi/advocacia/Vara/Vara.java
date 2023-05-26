package br.edu.ifsul.cstsi.advocacia.Vara;

import br.edu.ifsul.cstsi.advocacia.Processo.Processo;
import br.edu.ifsul.cstsi.advocacia.Tribunal.Tribunal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vara {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codvara", nullable = false)
    private Integer codvara;
    @Basic
    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;
//    @Basic
//    @Column(name = "codtribunal", nullable = false)
//    private Integer codtribunal;
    @OneToMany(mappedBy = "varaByCodvara")
    private Collection<Processo> processosByCodvara;
    @ManyToOne
    @JoinColumn(name = "codtribunal", referencedColumnName = "codtribunal", nullable = false)
    private Tribunal tribunalByCodtribunal;

}
