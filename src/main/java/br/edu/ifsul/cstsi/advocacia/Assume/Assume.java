package br.edu.ifsul.cstsi.advocacia.Assume;

import br.edu.ifsul.cstsi.advocacia.Advogado.Advogado;
import br.edu.ifsul.cstsi.advocacia.Processo.Processo;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Assume {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codassume", nullable = false)
    private Integer codassume;
    @Basic
    @Column(name = "dataInicio", nullable = false)
    private Date dataInicio;
    @Basic
    @Column(name = "dataFinal", nullable = false)
    private Date dataFinal;
    @Basic
    @Column(name = "codadvogado", nullable = false)
    private Integer codadvogado;
    @Basic
    @Column(name = "codprocesso", nullable = false)
    private Integer codprocesso;
    @ManyToOne
    @JoinColumn(name = "codadvogado", referencedColumnName = "codadvogado", nullable = false)
    private Advogado advogadoByCodadvogado;
    @ManyToOne
    @JoinColumn(name = "codprocesso", referencedColumnName = "codprocesso", nullable = false)
    private Processo processoByCodprocesso;

    public Integer getCodassume() {
        return codassume;
    }

    public void setCodassume(Integer codassume) {
        this.codassume = codassume;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Integer getCodadvogado() {
        return codadvogado;
    }

    public void setCodadvogado(Integer codadvogado) {
        this.codadvogado = codadvogado;
    }

    public Integer getCodprocesso() {
        return codprocesso;
    }

    public void setCodprocesso(Integer codprocesso) {
        this.codprocesso = codprocesso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Assume assume = (Assume) o;

        if (codassume != null ? !codassume.equals(assume.codassume) : assume.codassume != null) return false;
        if (dataInicio != null ? !dataInicio.equals(assume.dataInicio) : assume.dataInicio != null) return false;
        if (dataFinal != null ? !dataFinal.equals(assume.dataFinal) : assume.dataFinal != null) return false;
        if (codadvogado != null ? !codadvogado.equals(assume.codadvogado) : assume.codadvogado != null) return false;
        if (codprocesso != null ? !codprocesso.equals(assume.codprocesso) : assume.codprocesso != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codassume != null ? codassume.hashCode() : 0;
        result = 31 * result + (dataInicio != null ? dataInicio.hashCode() : 0);
        result = 31 * result + (dataFinal != null ? dataFinal.hashCode() : 0);
        result = 31 * result + (codadvogado != null ? codadvogado.hashCode() : 0);
        result = 31 * result + (codprocesso != null ? codprocesso.hashCode() : 0);
        return result;
    }

    public Advogado getAdvogadoByCodadvogado() {
        return advogadoByCodadvogado;
    }

    public void setAdvogadoByCodadvogado(Advogado advogadoByCodadvogado) {
        this.advogadoByCodadvogado = advogadoByCodadvogado;
    }

    public Processo getProcessoByCodprocesso() {
        return processoByCodprocesso;
    }

    public void setProcessoByCodprocesso(Processo processoByCodprocesso) {
        this.processoByCodprocesso = processoByCodprocesso;
    }
}
