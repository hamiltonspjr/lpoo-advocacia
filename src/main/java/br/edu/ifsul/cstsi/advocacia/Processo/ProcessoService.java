package br.edu.ifsul.cstsi.advocacia.Processo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class ProcessoService {
    @Autowired
    private ProcessoRepository rep;

    public List<Processo> getProcessos() {
        return rep.findAll();
    }

    public Processo getProcessoById(Integer id) {
        Optional<Processo> optional = rep.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    public Processo getProcessoByNumero(String numero) {
        Optional<Processo> optional = rep.findByNumero(numero);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Processo insert(Processo processo) {
        Assert.isNull(processo.getCodprocesso(), "Não foi possível inserir o processo");
        return rep.save(processo);
    }

    public Processo update(Processo processo) {
        Assert.notNull(processo.getCodprocesso(), "Não foi possível atualizar o processo");
        Optional<Processo> optional = rep.findById(processo.getCodprocesso());
        if(optional.isPresent()){
            Processo db = optional.get();
            db.setNumero(processo.getNumero());
            db.setAbertura(processo.getAbertura());
            db.setConclusao(processo.getConclusao());
            db.setDescricao(processo.getDescricao());
            db.setSituacao(processo.getSituacao());
            db.setPessoaByCodpessoa(processo.getPessoaByCodpessoa());
            db.setReuByCodpessoa(processo.getReuByCodpessoa());
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
