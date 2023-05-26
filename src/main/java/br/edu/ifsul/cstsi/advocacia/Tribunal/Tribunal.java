package br.edu.ifsul.cstsi.advocacia.Tribunal;

import br.edu.ifsul.cstsi.advocacia.Vara.Vara;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tribunal {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codtribunal", nullable = false)
    private Integer codtribunal;
    @Basic
    @Column(name = "denominacao", nullable = false, length = 255)
    private String denominacao;
    @Basic
    @Column(name = "endereco", nullable = false, length = 255)
    private String endereco;
    @OneToMany(mappedBy = "tribunalByCodtribunal")
    private Collection<Vara> varasByCodtribunal;

    @Override
    public String toString() {
        return "\nTribunal{" +
                "codtribunal=" + codtribunal +
                ", denominacao='" + denominacao + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
