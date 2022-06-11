package com.example.individ1.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
@Alternative
public class ShortCardIdGenerator extends AlternativeCardIdGenerator {
    @Override
    public String generateCardId(String name) {
        return name.substring(0, 2)+ new Random().nextInt(100);
    }
}
