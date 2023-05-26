package br.edu.ifsul.cstsi.advocacia.Pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class PessoaService {
    @Autowired
    private PessoaRepository rep;

    public List<Pessoa> getPessoas() {
        return rep.findAll();
    }
    public Pessoa getPessoaById(Integer id) {
        Optional<Pessoa> optional = rep.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
    public List<Pessoa> getPessoasByNome(String nome) {
        return new ArrayList<>(rep.findByNome(nome + "%"));
    }

    public Pessoa getPessoaByCpf(String cpf) {
        Optional<Pessoa> optional = rep.findByCpf(cpf);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Pessoa getPessoaByRg(String rg) {
        Optional<Pessoa> optional = rep.findByRg(rg);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Pessoa getPessoaByCnpj(String cnpj) {
        Optional<Pessoa> optional = rep.findByCnpj(cnpj);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Pessoa insert(Pessoa pessoa) {
        Assert.isNull(pessoa.getCodpessoa(),"Não foi possível inserir o registro");
        return rep.save(pessoa);
    }

    public Pessoa update(Pessoa pessoa) {
        Assert.notNull(pessoa.getCodpessoa(),"Não foi possível atualizar o registro");
        Optional<Pessoa> optional = rep.findById(pessoa.getCodpessoa());
        if(optional.isPresent()){
            Pessoa db = optional.get();
            db.setNome(pessoa.getNome());
            db.setEndereco(pessoa.getEndereco());
            db.setBairro(pessoa.getBairro());
            db.setCidade(pessoa.getCidade());
            db.setCep(pessoa.getCep());
            db.setUf(pessoa.getUf());
            db.setTelefone(pessoa.getTelefone());
            db.setEmail(pessoa.getEmail());
            db.setCpf(pessoa.getCpf());
            db.setRg(pessoa.getRg());
            db.setCpnj(pessoa.getCpnj());
            rep.save(db);
            return db;
        } else {
            return null;
        }
    }
    public void delete(Integer id) {
        rep.deleteById(id);
    }
}
