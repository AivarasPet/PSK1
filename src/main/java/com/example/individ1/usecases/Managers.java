package com.example.individ1.usecases;

import com.example.individ1.entities.Manager;
import com.example.individ1.entities.Stock;
import com.example.individ1.persistence.ManagersDAO;
import com.example.individ1.persistence.StocksDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Managers {
    @Inject
    private ManagersDAO managersDAO;

    @Getter
    @Setter
    private Manager managerToAdd = new Manager();

    @Getter
    private List<Manager> allManagers;

    @PostConstruct
    public void init(){
        loadAllStocks();
    }

    @Transactional
    public void createManager(){
        this.managersDAO.persist(managerToAdd);
    }

    private void loadAllStocks(){
        this.allManagers = managersDAO.loadAll();
    }
}
