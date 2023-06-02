package br.edu.ifsul.cstsi.advocacia.Assume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class AssumeService {
    @Autowired
    private AssumeRepository rep;

    public List<Assume> getAllAssume() {
        return rep.findAll();
    }
    public Assume getAssumeById(Integer id) {
        Optional<Assume> optional = rep.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public List<Assume> getAssumeByDataInicio(Date data) {
        return new ArrayList<>(rep.findByDataInicio(data));
    }
    public List<Assume> getAssumeByDataFinal(Date data) {
        return new ArrayList<>(rep.findByDataFinal(data));
    }
    public Assume insert(Assume assume) {
        Assert.isNull(assume.getCodassume(),"Não foi possível inserir o registro");
        return rep.save(assume);
    }

    public Assume update(Assume assume) {
        Assert.notNull(assume.getCodassume(),"Não foi possível atualizar o registro");
        Optional<Assume> optional = rep.findById(assume.getCodassume());
        if(optional.isPresent()) {
            Assume db = optional.get();
            db.setDataInicio(assume.getDataInicio());
            db.setDataFinal(assume.getDataFinal());
            db.setAdvogadoByCodadvogado(assume.getAdvogadoByCodadvogado());
            db.setProcessoByCodprocesso(assume.getProcessoByCodprocesso());
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
