package com.example.individ1.services;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;


@ApplicationScoped
public @Alternative class AlternativeCardIdGenerator implements Serializable, ManagerCardIdGenerator {

    @Override
    public String generateCardId(String name) {
        return name.substring(0, 3);
    }
}
