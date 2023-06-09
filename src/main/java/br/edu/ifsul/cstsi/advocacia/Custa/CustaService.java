package br.edu.ifsul.cstsi.advocacia.Custa;

import br.edu.ifsul.cstsi.advocacia.Processo.Processo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustaService {
    @Autowired
    private CustaRepository rep;

    public List<Custa> getCustos() {
        return rep.findAll();
    }

    public Custa getCustaById(Integer id) {
        Optional<Custa> optional = rep.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public List<Custa> getCustaByData(LocalDate data) {
        return new ArrayList<>(rep.findByData(data));
    }

    public List<Custa> getCustaByProcesso(Processo processo) {
        return new ArrayList<>(rep.findByCodProcesso(processo));
    }

    public Custa insert(Custa custa) {
        Assert.isNull(custa.getCodcusta(),"Não foi possível inserir o registro.");
        return rep.save(custa);
    }

    public Custa update(Custa custa) {
        Assert.notNull(custa.getCodcusta(),"Não foi possível atualizar o registro");
        Optional<Custa> optional = rep.findById(custa.getCodcusta());
        if (optional.isPresent()) {
            Custa db = optional.get();
            db.setData(custa.getData());
            db.setDescricao(custa.getDescricao());
            db.setValor(custa.getValor());
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
