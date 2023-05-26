package br.edu.ifsul.cstsi.advocacia.Processo;

import br.edu.ifsul.cstsi.advocacia.Assume.Assume;
import br.edu.ifsul.cstsi.advocacia.Audiencia.Audiencia;
import br.edu.ifsul.cstsi.advocacia.Custa.Custa;
import br.edu.ifsul.cstsi.advocacia.Pessoa.Pessoa;
import br.edu.ifsul.cstsi.advocacia.Vara.Vara;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

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
    @Basic
    @Column(name = "codpessoa", nullable = false)
    private Integer codpessoa;
    @Basic
    @Column(name = "codvara", nullable = false)
    private Integer codvara;
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

    public Integer getCodprocesso() {
        return codprocesso;
    }

    public void setCodprocesso(Integer codprocesso) {
        this.codprocesso = codprocesso;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    public Date getConclusao() {
        return conclusao;
    }

    public void setConclusao(Date conclusao) {
        this.conclusao = conclusao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Integer getCodpessoa() {
        return codpessoa;
    }

    public void setCodpessoa(Integer codpessoa) {
        this.codpessoa = codpessoa;
    }

    public Integer getCodvara() {
        return codvara;
    }

    public void setCodvara(Integer codvara) {
        this.codvara = codvara;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Processo processo = (Processo) o;

        if (codprocesso != null ? !codprocesso.equals(processo.codprocesso) : processo.codprocesso != null)
            return false;
        if (numero != null ? !numero.equals(processo.numero) : processo.numero != null) return false;
        if (abertura != null ? !abertura.equals(processo.abertura) : processo.abertura != null) return false;
        if (conclusao != null ? !conclusao.equals(processo.conclusao) : processo.conclusao != null) return false;
        if (descricao != null ? !descricao.equals(processo.descricao) : processo.descricao != null) return false;
        if (situacao != null ? !situacao.equals(processo.situacao) : processo.situacao != null) return false;
        if (codpessoa != null ? !codpessoa.equals(processo.codpessoa) : processo.codpessoa != null) return false;
        if (codvara != null ? !codvara.equals(processo.codvara) : processo.codvara != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codprocesso != null ? codprocesso.hashCode() : 0;
        result = 31 * result + (numero != null ? numero.hashCode() : 0);
        result = 31 * result + (abertura != null ? abertura.hashCode() : 0);
        result = 31 * result + (conclusao != null ? conclusao.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (situacao != null ? situacao.hashCode() : 0);
        result = 31 * result + (codpessoa != null ? codpessoa.hashCode() : 0);
        result = 31 * result + (codvara != null ? codvara.hashCode() : 0);
        return result;
    }

    public Collection<Assume> getAssumesByCodprocesso() {
        return assumesByCodprocesso;
    }

    public void setAssumesByCodprocesso(Collection<Assume> assumesByCodprocesso) {
        this.assumesByCodprocesso = assumesByCodprocesso;
    }

    public Collection<Audiencia> getAudienciasByCodprocesso() {
        return audienciasByCodprocesso;
    }

    public void setAudienciasByCodprocesso(Collection<Audiencia> audienciasByCodprocesso) {
        this.audienciasByCodprocesso = audienciasByCodprocesso;
    }

    public Collection<Custa> getCustasByCodprocesso() {
        return custasByCodprocesso;
    }

    public void setCustasByCodprocesso(Collection<Custa> custasByCodprocesso) {
        this.custasByCodprocesso = custasByCodprocesso;
    }

    public Pessoa getPessoaByCodpessoa() {
        return pessoaByCodpessoa;
    }

    public void setPessoaByCodpessoa(Pessoa pessoaByCodpessoa) {
        this.pessoaByCodpessoa = pessoaByCodpessoa;
    }

    public Vara getVaraByCodvara() {
        return varaByCodvara;
    }

    public void setVaraByCodvara(Vara varaByCodvara) {
        this.varaByCodvara = varaByCodvara;
    }
}
