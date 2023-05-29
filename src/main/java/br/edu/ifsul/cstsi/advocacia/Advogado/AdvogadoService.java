package br.edu.ifsul.cstsi.advocacia.Advogado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdvogadoService {

    @Autowired
    private AdvogadoRepository rep;

    public List<Advogado> getAdvogados() {
        return rep.findAll();
    }

    public Advogado getAdvogadoById(Integer id) {
        Optional<Advogado> optional = rep.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public List<Advogado> getAdvogadoByNome(String nome) {
        return new ArrayList<>(rep.findByNome(nome));
    }

    public Advogado getAdvogadoByAob(String oab) {
        Optional<Advogado> optional = rep.findByOab(oab);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Advogado insert(Advogado advogado) {
        Assert.isNull(advogado.getCodadvogado(), "Não foi possível inserir esse advogado!");
        return rep.save(advogado);
    }

    public Advogado update(Advogado advogado) {
        Assert.notNull(advogado.getCodadvogado(), "Não foi possível atualizar o advogado");

        Optional<Advogado> optional = rep.findById(advogado.getCodadvogado());
        if (optional.isPresent()) {
            Advogado db = optional.get();
            db.setOab(advogado.getOab());
            db.setNome(advogado.getNome());
            db.setEndereco(advogado.getEndereco());
            db.setBairro(advogado.getBairro());
            db.setCep(advogado.getCep());
            db.setEmail(advogado.getEmail());
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
