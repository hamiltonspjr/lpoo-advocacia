package br.edu.ifsul.cstsi.advocacia.Vara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VaraService {
    @Autowired
    private VaraRepository rep;

    public List<Vara> getVaras() {
        return rep.findAll();
    }
    public Vara getVaraById(Integer id) {
        Optional<Vara> optional = rep.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
    public List<Vara> getVaraByNome(String nome) {
        return new ArrayList<>(rep.findByNome(nome + "%"));
    }
    public Vara insert(Vara vara) {
        Assert.isNull(vara.getCodvara(), "Não foi possível inserir o registro");
        return rep.save(vara);
    }
    public Vara update(Vara vara) {
        Assert.notNull(vara.getCodvara(),"Não foi possível atualizar o registro");
        Optional<Vara> optional = rep.findById(vara.getCodvara());
        if(optional.isPresent()) {
            Vara db = optional.get();
            db.setNome(vara.getNome());
            db.setDescricao(vara.getDescricao());
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
