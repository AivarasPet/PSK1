package com.example.individ1.usecases.mybatis;

import com.example.individ1.mybatis.dao.StockMapper;
import com.example.individ1.mybatis.model.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class StocksMyBatis {
    @Inject
    private StockMapper stockMapper;

    @Getter
    private List<Stock> allStocks;

    @Getter @Setter
    private Stock stockToCreate = new Stock();

    @PostConstruct
    public void init() {
        this.loadAllStocks();
    }

    private void loadAllStocks() {
        this.allStocks = stockMapper.selectAll();
    }

    @Transactional
    public String createStock() {
        stockMapper.insert(stockToCreate);
        return "/myBatis/main?faces-redirect=true";
    }
}
