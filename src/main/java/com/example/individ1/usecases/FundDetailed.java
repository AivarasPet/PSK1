package com.example.individ1.usecases;

import com.example.individ1.entities.Fund;
import com.example.individ1.entities.Manager;
import com.example.individ1.entities.Stock;
import com.example.individ1.persistence.FundsDAO;
import com.example.individ1.persistence.ManagersDAO;
import com.example.individ1.persistence.StocksDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;


@Model
public class FundDetailed implements Serializable {
    @Inject
    private FundsDAO fundsDAO;

    @Inject
    private StocksDAO stocksDAO;

    @Inject
    private ManagersDAO managersDAO;

    @Getter
    @Setter
    private Fund fund;

    @Getter @Setter
    private String fundId;

    @Getter @Setter
    private String stockToAddId;

    @Getter @Setter
    private String managerToAddId;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param = requestParameters.get("fundId");
        if(param == null) return;
        Integer fundId = Integer.parseInt(requestParameters.get("fundId"));
        this.fundId = fundId + "";
        this.fund = fundsDAO.findOne(fundId);
    }

    @Transactional
    public String addStockToFund() {
        Stock toAdd = stocksDAO.findOne(Integer.parseInt(stockToAddId));
        if(fund.getStocks().contains(toAdd) == false) {
            fund.getStocks().add(toAdd);
            fundsDAO.update(fund);
        }
        return "fundDetailed.xhtml?fundId=" + fund.getId();
    }
    @Transactional
    public void addManagerToFund() {
        Manager toAdd = managersDAO.findOne(Integer.parseInt(managerToAddId));
        if(fund.getManagers().contains(toAdd) == false) {
            fund.getManagers().add(toAdd);
            fundsDAO.update(fund);
        }
    }
}
