package br.edu.ifsul.cstsi.advocacia.Audiencia;

import br.edu.ifsul.cstsi.advocacia.Processo.Processo;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Audiencia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codaudiencia", nullable = false)
    private Integer codaudiencia;
    @Basic
    @Column(name = "data", nullable = false)
    private Date data;
    @Basic
    @Column(name = "parecer", nullable = false, length = 255)
    private String parecer;
    @Basic
    @Column(name = "codprocesso", nullable = false)
    private Integer codprocesso;
    @ManyToOne
    @JoinColumn(name = "codprocesso", referencedColumnName = "codprocesso", nullable = false)
    private Processo processoByCodprocesso;

    public Integer getCodaudiencia() {
        return codaudiencia;
    }

    public void setCodaudiencia(Integer codaudiencia) {
        this.codaudiencia = codaudiencia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getParecer() {
        return parecer;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
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

        Audiencia audiencia = (Audiencia) o;

        if (codaudiencia != null ? !codaudiencia.equals(audiencia.codaudiencia) : audiencia.codaudiencia != null)
            return false;
        if (data != null ? !data.equals(audiencia.data) : audiencia.data != null) return false;
        if (parecer != null ? !parecer.equals(audiencia.parecer) : audiencia.parecer != null) return false;
        if (codprocesso != null ? !codprocesso.equals(audiencia.codprocesso) : audiencia.codprocesso != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codaudiencia != null ? codaudiencia.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (parecer != null ? parecer.hashCode() : 0);
        result = 31 * result + (codprocesso != null ? codprocesso.hashCode() : 0);
        return result;
    }

    public Processo getProcessoByCodprocesso() {
        return processoByCodprocesso;
    }

    public void setProcessoByCodprocesso(Processo processoByCodprocesso) {
        this.processoByCodprocesso = processoByCodprocesso;
    }
}
