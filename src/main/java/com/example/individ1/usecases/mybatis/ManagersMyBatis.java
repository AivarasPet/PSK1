package com.example.individ1.usecases.mybatis;

import com.example.individ1.mybatis.dao.ManagerMapper;
import com.example.individ1.mybatis.model.Manager;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ManagersMyBatis {
    @Inject
    private ManagerMapper managerMapper;

    @Getter
    private List<Manager> allManagers;

    @Getter @Setter
    private Manager managerToCreate = new Manager();

    @PostConstruct
    public void init() {
        this.loadAllStocks();
    }

    private void loadAllStocks() {
        this.allManagers = managerMapper.selectAll();
    }

    @Transactional
    public String createManager() {
        managerMapper.insert(managerToCreate);
        return "/myBatis/main?faces-redirect=true";
    }

}
