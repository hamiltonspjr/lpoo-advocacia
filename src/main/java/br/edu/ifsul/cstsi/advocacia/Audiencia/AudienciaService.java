package br.edu.ifsul.cstsi.advocacia.Audiencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AudienciaService {
    @Autowired
    private AudienciaRepository rep;

    public List<Audiencia> getAudiencias() {
        return rep.findAll();
    }
    public Audiencia getAudienciaById(Integer id) {
        Optional<Audiencia> optional = rep.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public List<Audiencia> getAudienciasByDate(LocalDate date) {
        return new ArrayList<>(rep.findByData(date));
    }

    public Audiencia insert(Audiencia audiencia) {
        Assert.isNull(audiencia.getCodaudiencia(), "Não foi possível inserir a audiencia.");
        return rep.save(audiencia);
    }
    public Audiencia update(Audiencia audiencia) {
        Assert.notNull(audiencia.getCodaudiencia(),"Não foi possível atualizar a audiencia. ");
        Optional<Audiencia> optional = rep.findById(audiencia.getCodaudiencia());
        if(optional.isPresent()) {
            Audiencia db = optional.get();
            db.setData(audiencia.getData());
            db.setParecer(audiencia.getParecer());
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
