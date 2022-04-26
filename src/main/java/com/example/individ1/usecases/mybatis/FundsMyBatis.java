package com.example.individ1.usecases.mybatis;


import com.example.individ1.mybatis.dao.FundMapper;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class FundsMyBatis {
    @Inject
    private FundMapper fundMapper;

    @Getter
    private List<com.example.individ1.mybatis.model.Fund> allFunds;

    @Getter @Setter
    private com.example.individ1.mybatis.model.Fund fundToCreate = new com.example.individ1.mybatis.model.Fund();

    @PostConstruct
    public void init() {
        this.loadAllFunds();
    }

    private void loadAllFunds() {
        this.allFunds = fundMapper.selectAll();
    }

    @Transactional
    public String createFund() {
        fundMapper.insert(fundToCreate);
        return "/myBatis/main?faces-redirect=true";
    }
}
