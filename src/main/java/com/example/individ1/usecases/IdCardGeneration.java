package com.example.individ1.usecases;

import com.example.individ1.entities.Manager;
import com.example.individ1.services.ManagerCardIdGenerator;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named
public class IdCardGeneration {

    @Inject
    ManagerCardIdGenerator managerCardIdGenerator;

    @Getter
    @Setter
    private String inputForGeneration = "";


    @Getter
    @Setter
    private String generatedId = "";

    public String generateCardId() {
        String whatToRet = managerCardIdGenerator.generateCardId(inputForGeneration);
        generatedId = whatToRet;
        return whatToRet;
    }
}
