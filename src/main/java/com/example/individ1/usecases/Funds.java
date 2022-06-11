package com.example.individ1.usecases;

import com.example.individ1.entities.Fund;
import com.example.individ1.interceptors.LoggedInvocation;
import com.example.individ1.persistence.FundsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Funds {
    @Inject
    private FundsDAO fundsDAO;

    @Getter
    @Setter
    private Fund fundToCreate = new Fund();

    @Getter
    private List<Fund> allFunds;

    @PostConstruct
    public void init(){
        loadAllFunds();
    }

    @Transactional
    @LoggedInvocation
    public void createFund(){
        this.fundsDAO.persist(fundToCreate);
    }

    private void loadAllFunds(){
        this.allFunds = fundsDAO.loadAll();
    }
}
