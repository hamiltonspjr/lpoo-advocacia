package br.edu.ifsul.cstsi.advocacia.Pessoa;

import br.edu.ifsul.cstsi.advocacia.Processo.Processo;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Pessoa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codpessoa", nullable = false)
    private Integer codpessoa;
    @Basic
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;
    @Basic
    @Column(name = "endereco", nullable = false, length = 255)
    private String endereco;
    @Basic
    @Column(name = "bairro", nullable = false, length = 255)
    private String bairro;
    @Basic
    @Column(name = "cidade", nullable = false, length = 255)
    private String cidade;
    @Basic
    @Column(name = "cep", nullable = false, length = 255)
    private String cep;
    @Basic
    @Column(name = "uf", nullable = false, length = 255)
    private String uf;
    @Basic
    @Column(name = "telefone", nullable = false, length = 255)
    private String telefone;
    @Basic
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic
    @Column(name = "cpf", nullable = true, length = 255)
    private String cpf;
    @Basic
    @Column(name = "rg", nullable = true, length = 255)
    private String rg;
    @Basic
    @Column(name = "cpnj", nullable = true, length = 255)
    private String cpnj;
    @OneToMany(mappedBy = "pessoaByCodpessoa")
    private Collection<Processo> processosByCodpessoa;

    public Integer getCodpessoa() {
        return codpessoa;
    }

    public void setCodpessoa(Integer codpessoa) {
        this.codpessoa = codpessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        if (codpessoa != null ? !codpessoa.equals(pessoa.codpessoa) : pessoa.codpessoa != null) return false;
        if (nome != null ? !nome.equals(pessoa.nome) : pessoa.nome != null) return false;
        if (endereco != null ? !endereco.equals(pessoa.endereco) : pessoa.endereco != null) return false;
        if (bairro != null ? !bairro.equals(pessoa.bairro) : pessoa.bairro != null) return false;
        if (cidade != null ? !cidade.equals(pessoa.cidade) : pessoa.cidade != null) return false;
        if (cep != null ? !cep.equals(pessoa.cep) : pessoa.cep != null) return false;
        if (uf != null ? !uf.equals(pessoa.uf) : pessoa.uf != null) return false;
        if (telefone != null ? !telefone.equals(pessoa.telefone) : pessoa.telefone != null) return false;
        if (email != null ? !email.equals(pessoa.email) : pessoa.email != null) return false;
        if (cpf != null ? !cpf.equals(pessoa.cpf) : pessoa.cpf != null) return false;
        if (rg != null ? !rg.equals(pessoa.rg) : pessoa.rg != null) return false;
        if (cpnj != null ? !cpnj.equals(pessoa.cpnj) : pessoa.cpnj != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codpessoa != null ? codpessoa.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
        result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
        result = 31 * result + (cep != null ? cep.hashCode() : 0);
        result = 31 * result + (uf != null ? uf.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (rg != null ? rg.hashCode() : 0);
        result = 31 * result + (cpnj != null ? cpnj.hashCode() : 0);
        return result;
    }

    public Collection<Processo> getProcessosByCodpessoa() {
        return processosByCodpessoa;
    }

    public void setProcessosByCodpessoa(Collection<Processo> processosByCodpessoa) {
        this.processosByCodpessoa = processosByCodpessoa;
    }
}
