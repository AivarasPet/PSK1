package com.example.individ1.persistence;

import com.example.individ1.entities.Fund;
import com.example.individ1.entities.Stock;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class StocksDAO {

    @Inject
    private EntityManager em;

    public void persist(Stock stock){
        this.em.persist(stock);
    }

    public Stock findOne(Integer id){
        return em.find(Stock.class, id);
    }

    public Stock update(Stock stock){
        return em.merge(stock);
    }

    public List<Stock> loadAll() {
        return em.createNamedQuery("Stock.findAll", Stock.class).getResultList();
    }

}
