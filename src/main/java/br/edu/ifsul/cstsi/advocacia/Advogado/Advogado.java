package br.edu.ifsul.cstsi.advocacia.Advogado;

import br.edu.ifsul.cstsi.advocacia.Assume.Assume;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Advogado {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codadvogado", nullable = false)
    private Integer codadvogado;
    @Basic
    @Column(name = "oab", nullable = false, length = 255)
    private String oab;
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
    @Column(name = "cep", nullable = false, length = 255)
    private String cep;
    @Basic
    @Column(name = "email", nullable = false, length = 150)
    private String email;
    @OneToMany(mappedBy = "advogadoByCodadvogado")
    private Collection<Assume> assumesByCodadvogado;

    public Integer getCodadvogado() {
        return codadvogado;
    }

    public void setCodadvogado(Integer codadvogado) {
        this.codadvogado = codadvogado;
    }

    public String getOab() {
        return oab;
    }

    public void setOab(String oab) {
        this.oab = oab;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Advogado advogado = (Advogado) o;

        if (codadvogado != null ? !codadvogado.equals(advogado.codadvogado) : advogado.codadvogado != null)
            return false;
        if (oab != null ? !oab.equals(advogado.oab) : advogado.oab != null) return false;
        if (nome != null ? !nome.equals(advogado.nome) : advogado.nome != null) return false;
        if (endereco != null ? !endereco.equals(advogado.endereco) : advogado.endereco != null) return false;
        if (bairro != null ? !bairro.equals(advogado.bairro) : advogado.bairro != null) return false;
        if (cep != null ? !cep.equals(advogado.cep) : advogado.cep != null) return false;
        if (email != null ? !email.equals(advogado.email) : advogado.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codadvogado != null ? codadvogado.hashCode() : 0;
        result = 31 * result + (oab != null ? oab.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
        result = 31 * result + (cep != null ? cep.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public Collection<Assume> getAssumesByCodadvogado() {
        return assumesByCodadvogado;
    }

    public void setAssumesByCodadvogado(Collection<Assume> assumesByCodadvogado) {
        this.assumesByCodadvogado = assumesByCodadvogado;
    }
}
