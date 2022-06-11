package com.example.individ1.decorators;

import com.example.individ1.services.ManagerCardIdGenerator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.Locale;


@Decorator
public class CardIdGeneratorDecorated implements ManagerCardIdGenerator {

    @Inject
    @Delegate
    @Any
    ManagerCardIdGenerator generator;

    @Override
    public String generateCardId(String name) {
        return generator.generateCardId(name.toUpperCase(Locale.ROOT));
    }
}
