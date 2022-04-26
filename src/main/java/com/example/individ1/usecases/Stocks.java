package com.example.individ1.usecases;

import com.example.individ1.entities.Fund;
import com.example.individ1.entities.Stock;
import com.example.individ1.persistence.StocksDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Stocks {
    @Inject
    private StocksDAO stocksDAO;

    @Getter
    @Setter
    private Stock stockToCreate = new Stock();

    @Getter
    private List<Stock> allStocks;

    @PostConstruct
    public void init(){
        loadAllStocks();
    }

    @Transactional
    public void createStock(){
        this.stocksDAO.persist(stockToCreate);
    }

    private void loadAllStocks(){
        this.allStocks = stocksDAO.loadAll();
    }
}
