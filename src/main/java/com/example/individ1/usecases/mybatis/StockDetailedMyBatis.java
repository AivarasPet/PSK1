package com.example.individ1.usecases.mybatis;

import com.example.individ1.mybatis.dao.FundMapper;
import com.example.individ1.mybatis.dao.FundsStocksMapper;
import com.example.individ1.mybatis.dao.StockMapper;
import com.example.individ1.mybatis.model.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.util.Map;

@Model
public class StockDetailedMyBatis {

    @Inject
    private StockMapper stockMapper;

    @Getter
    @Setter
    private Stock stock;

    @Getter @Setter
    private String stockId;

    @Getter @Setter
    private String marketCapToChange;


    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String param = requestParameters.get("stockId");
        if(param == null) return;
        Integer stockId = Integer.parseInt(requestParameters.get("stockId"));
        this.stockId = stockId + "";
        this.stock = stockMapper.selectByPrimaryKey(stockId);
    }

    @Transactional
    public String updateMarketCap() {
        try{
            stockMapper.updateByPrimaryKey(this.stock);
        } catch (OptimisticLockException e) {
            return "/myBatis/stockDetailed.xhtml?faces-redirect=true&stockId=" + this.stock.getId() + "&error=optimistic-lock-exception";
        }
        return "/myBatis/stockDetailed.xhtml?faces-redirect=true&stockId=" + this.stock.getId();
    }

}
