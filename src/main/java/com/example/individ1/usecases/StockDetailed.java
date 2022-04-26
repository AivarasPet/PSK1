package com.example.individ1.usecases;

import com.example.individ1.entities.Fund;
import com.example.individ1.entities.Stock;
import com.example.individ1.persistence.FundsDAO;
import com.example.individ1.persistence.StocksDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class StockDetailed implements Serializable {
    @Inject
    private FundsDAO fundsDAO;

    @Inject
    private StocksDAO stocksDAO;

    @Getter
    @Setter
    private Stock stock;

    @Getter @Setter
    private String stockId;

    @Getter @Setter
    private String fundToAddId;

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
        this.stock = stocksDAO.findOne(stockId);
        marketCapToChange = stock.getMarketCap();
    }

    @Transactional
    public String updateMarketCap() {
        try{
            stock.setMarketCap(marketCapToChange);
            stocksDAO.update(this.stock);
        } catch (OptimisticLockException e) {
            return "/stockDetailed.xhtml?faces-redirect=true&stockId=" + this.stock.getId() + "&error=optimistic-lock-exception";
        }
        return "index.xhtml";
    }
}
