package com.example.individ1.persistence;

import com.example.individ1.entities.Fund;
import com.example.individ1.entities.Manager;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ManagersDAO {
    @Inject
    private EntityManager em;

    public List<Manager> loadAll() {
        return em.createNamedQuery("Manager.findAll", Manager.class).getResultList();
    }
    public Manager update(Manager manager){
        return em.merge(manager);
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Manager manager){
        this.em.persist(manager);
    }

    public Manager findOne(Integer id) {
        return em.find(Manager.class, id);
    }
}
