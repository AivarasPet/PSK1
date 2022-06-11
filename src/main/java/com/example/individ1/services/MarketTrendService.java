package com.example.individ1.services;
import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.concurrent.Future;
import java.util.Random;

@ApplicationScoped
public class MarketTrendService implements Serializable {

    @Futureable
    public Future<Double> getStockPriceTrend() {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        final Double generatedPrice = Double.valueOf(Math.round((new Random().nextDouble()-0.5)*100))/100*20;
        return new AsyncResult<>(generatedPrice);
    }
}