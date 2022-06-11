package com.example.individ1.rest;

import com.example.individ1.entities.Stock;
import com.example.individ1.persistence.StocksDAO;
import com.example.individ1.rest.contracts.StockDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/stocks")
public class StocksController {
    @Inject
    private StocksDAO stocksDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Stock stock = stocksDAO.findOne(id);
        if (stock == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        StockDto stockDto = new StockDto();
        stockDto.setName(stock.getName());
        stockDto.setMarketCap(stock.getMarketCap());

        return Response.ok(stockDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer stockId,
            StockDto stockData) {
        try {
            Stock existingStock = stocksDAO.findOne(stockId);
            if (existingStock == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingStock.setName(stockData.getName());
            existingStock.setMarketCap(stockData.getMarketCap());
            stocksDAO.update(existingStock);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response insert(StockDto stockData) {
        try {
            Stock stock = new Stock();
            stock.setMarketCap(stockData.getMarketCap());
            stock.setName(stockData.getName());
            stocksDAO.persist(stock);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
