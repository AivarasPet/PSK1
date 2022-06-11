package com.example.individ1.usecases.mybatis;

import com.example.individ1.mybatis.dao.FundMapper;
import com.example.individ1.mybatis.dao.FundsStocksMapper;
import com.example.individ1.mybatis.dao.ManagerMapper;
import com.example.individ1.mybatis.dao.StockMapper;
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
import java.util.List;
import java.util.Map;
import com.example.individ1.mybatis.model.*;

@Model
public class FundDetailedMyBatis {

    @Inject
    private FundMapper fundMapper;

    @Inject
    private StockMapper stockMapper;

    @Inject
    private FundsStocksMapper fundsStocksMapper;

    @Getter
    @Setter
    private com.example.individ1.mybatis.model.Fund fund;

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
        this.fund = fundMapper.selectByPrimaryKey(fundId);
    }



//    @Transactional
//    public String addStockToFund() {
//        Stock toAdd = stockMapper.selectByPrimaryKey(Integer.parseInt(stockToAddId));
//        if(fund.getStocks().contains(toAdd) == false) {
//            List<Stock> stocks = fund.getStocks();
//            stocks.add(toAdd);
//            fund.setStocks(stocks);
//            fundMapper.updateByPrimaryKey(fund);
//        }
//        return "/myBatis/fundDetailed.xhtml?fundId=" + fund.getId();
//    }

    @Transactional
    public String addStockToFund() {
        try {
            FundsStocks fundsStocks = new FundsStocks();
            fundsStocks.setFundId(fund.getId());
            fundsStocks.setStockId(Integer.parseInt(stockToAddId));
            fundsStocksMapper.insert(fundsStocks);
            return "/myBatis/fundDetailed.xhtml?faces-redirect=true&fundId=" + fund.getId();
        }
        catch (Exception ex) {
            return "/error.xhtml";
        }
    }

    /*
    @Transactional
    public void addManagerToFund() {
        Manager toAdd = managerMapper.selectByPrimaryKey(Integer.parseInt(managerToAddId));
        if(fund.getManagers().contains(toAdd) == false) {
            fund.getManagers().add(toAdd);
            fundMapper.updateByPrimaryKey(fund);
        }
    }*/

}
