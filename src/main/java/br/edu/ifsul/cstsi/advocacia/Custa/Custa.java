package br.edu.ifsul.cstsi.advocacia.Custa;

import br.edu.ifsul.cstsi.advocacia.Processo.Processo;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

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
    @Basic
    @Column(name = "codprocesso", nullable = false)
    private Integer codprocesso;
    @ManyToOne
    @JoinColumn(name = "codprocesso", referencedColumnName = "codprocesso", nullable = false)
    private Processo processoByCodprocesso;

    public Integer getCodcusta() {
        return codcusta;
    }

    public void setCodcusta(Integer codcusta) {
        this.codcusta = codcusta;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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

        Custa custa = (Custa) o;

        if (codcusta != null ? !codcusta.equals(custa.codcusta) : custa.codcusta != null) return false;
        if (data != null ? !data.equals(custa.data) : custa.data != null) return false;
        if (descricao != null ? !descricao.equals(custa.descricao) : custa.descricao != null) return false;
        if (valor != null ? !valor.equals(custa.valor) : custa.valor != null) return false;
        if (codprocesso != null ? !codprocesso.equals(custa.codprocesso) : custa.codprocesso != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codcusta != null ? codcusta.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
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
