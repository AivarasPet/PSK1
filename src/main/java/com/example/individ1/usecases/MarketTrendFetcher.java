package com.example.individ1.usecases;

import com.example.individ1.interceptors.LoggedInvocation;
import com.example.individ1.services.MarketTrendService;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SessionScoped
@Named
public class MarketTrendFetcher implements Serializable {
    @Inject
    MarketTrendService marketTrendService;

    private Future<Double> snpTrend = null;

    @LoggedInvocation
    public String fetchStockPriceTrend() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        snpTrend = marketTrendService.getStockPriceTrend();
        String stockId = requestParameters.get("stockId");
        return  "stockDetailed?stockId=" + stockId;
    }

    public boolean isStockTrendFetchingRunning() {
        return snpTrend != null && !snpTrend.isDone();
    }

    public String stockPriceTrendFetchingStatus() throws ExecutionException, InterruptedException {
        if (snpTrend == null) {
            return null;
        } else if (isStockTrendFetchingRunning()) {
            return "Trend fetching in progress";
        }
        return "Current price trend: " + snpTrend.get();
    }
}
