package com.example.individ1.persistence;

import com.example.individ1.entities.Fund;
import com.example.individ1.entities.Stock;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FundsDAO {

    @Inject
    private EntityManager em;

    public List<Fund> loadAll() {
        return em.createNamedQuery("Fund.findAll", Fund.class).getResultList();
    }
    public Fund update(Fund fund){
        return em.merge(fund);
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Fund fund){
        this.em.persist(fund);
    }

    public Fund findOne(Integer id) {
        return em.find(Fund.class, id);
    }
}
