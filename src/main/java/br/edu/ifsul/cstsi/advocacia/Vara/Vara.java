package br.edu.ifsul.cstsi.advocacia.Vara;

import br.edu.ifsul.cstsi.advocacia.Processo.Processo;
import br.edu.ifsul.cstsi.advocacia.Tribunal.Tribunal;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Vara {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codvara", nullable = false)
    private Integer codvara;
    @Basic
    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;
    @Basic
    @Column(name = "codtribunal", nullable = false)
    private Integer codtribunal;
    @OneToMany(mappedBy = "varaByCodvara")
    private Collection<Processo> processosByCodvara;
    @ManyToOne
    @JoinColumn(name = "codtribunal", referencedColumnName = "codtribunal", nullable = false)
    private Tribunal tribunalByCodtribunal;

    public Integer getCodvara() {
        return codvara;
    }

    public void setCodvara(Integer codvara) {
        this.codvara = codvara;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodtribunal() {
        return codtribunal;
    }

    public void setCodtribunal(Integer codtribunal) {
        this.codtribunal = codtribunal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vara vara = (Vara) o;

        if (codvara != null ? !codvara.equals(vara.codvara) : vara.codvara != null) return false;
        if (descricao != null ? !descricao.equals(vara.descricao) : vara.descricao != null) return false;
        if (codtribunal != null ? !codtribunal.equals(vara.codtribunal) : vara.codtribunal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codvara != null ? codvara.hashCode() : 0;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (codtribunal != null ? codtribunal.hashCode() : 0);
        return result;
    }

    public Collection<Processo> getProcessosByCodvara() {
        return processosByCodvara;
    }

    public void setProcessosByCodvara(Collection<Processo> processosByCodvara) {
        this.processosByCodvara = processosByCodvara;
    }

    public Tribunal getTribunalByCodtribunal() {
        return tribunalByCodtribunal;
    }

    public void setTribunalByCodtribunal(Tribunal tribunalByCodtribunal) {
        this.tribunalByCodtribunal = tribunalByCodtribunal;
    }
}
