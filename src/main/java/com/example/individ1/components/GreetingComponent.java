package com.example.individ1.components;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Date;

//@SessionScoped
@Named
@RequestScoped
public class GreetingComponent {

    public String greeting() {
        return "Welcome! " + new Date();
    }

    @PostConstruct
    public void init() {
        System.out.println(toString() + " constructed.");
    }

    @PreDestroy
    public void aboutToDie() {
        System.out.println(toString() + " ready to die.");
    }
}