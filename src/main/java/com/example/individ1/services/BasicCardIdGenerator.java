package com.example.individ1.services;

import javax.enterprise.inject.Alternative;
import java.util.Random;

@Alternative
public class BasicCardIdGenerator implements ManagerCardIdGenerator{
    @Override
    public String generateCardId(String name) {
        return name.substring(0, 4)+ new Random().nextInt(1000);
    }
}
