package br.edu.ifsul.cstsi.advocacia.Tribunal;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class TribunalService {
    private TribunalRepository rep;

    public List<Tribunal> getTribunais() {
        return rep.findAll();
    }

    public Tribunal getTribunalById(Integer id) {
        Optional<Tribunal> optional = rep.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
    public List<Tribunal> getTribunalByDemoninacao(String denominacao) {
        //return new ArrayList<>(rep.findByDenominacao(denominacao + "%"));
        return null;
    }

    public Tribunal insert(Tribunal tribunal) {
        Assert.isNull(tribunal.getCodtribunal(), "Não foi possível inserir o registro");
        return (Tribunal) rep.save(tribunal);
    }
    public Tribunal update(Tribunal tribunal) {
        Assert.notNull(tribunal.getCodtribunal(), "Não foi possível atualizar o registro");
        Optional<Tribunal> optional = rep.findById(tribunal.getCodtribunal());
        if(optional.isPresent()) {
            Tribunal tribunalBanco = optional.get();
            tribunalBanco.setDenominacao(tribunal.getDenominacao());
            tribunalBanco.setEndereco(tribunal.getEndereco());
            rep.save(tribunalBanco);
            return tribunalBanco;
        } else {
            return null;
        }

    }
    public void delete(Integer id){
        rep.deleteById(id);
    }
}
