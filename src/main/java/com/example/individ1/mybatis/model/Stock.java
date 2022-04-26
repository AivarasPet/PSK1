package com.example.individ1.mybatis.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Stock {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STOCK.ID
     *
     * @mbg.generated Sat Apr 23 14:40:33 EEST 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STOCK.MARKETCAP
     *
     * @mbg.generated Sat Apr 23 14:40:33 EEST 2022
     */
    private String marketcap;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.STOCK.NAME
     *
     * @mbg.generated Sat Apr 23 14:40:33 EEST 2022
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STOCK.ID
     *
     * @return the value of PUBLIC.STOCK.ID
     *
     * @mbg.generated Sat Apr 23 14:40:33 EEST 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STOCK.ID
     *
     * @param id the value for PUBLIC.STOCK.ID
     *
     * @mbg.generated Sat Apr 23 14:40:33 EEST 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STOCK.MARKETCAP
     *
     * @return the value of PUBLIC.STOCK.MARKETCAP
     *
     * @mbg.generated Sat Apr 23 14:40:33 EEST 2022
     */
    public String getMarketcap() {
        return marketcap;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STOCK.MARKETCAP
     *
     * @param marketcap the value for PUBLIC.STOCK.MARKETCAP
     *
     * @mbg.generated Sat Apr 23 14:40:33 EEST 2022
     */
    public void setMarketcap(String marketcap) {
        this.marketcap = marketcap;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.STOCK.NAME
     *
     * @return the value of PUBLIC.STOCK.NAME
     *
     * @mbg.generated Sat Apr 23 14:40:33 EEST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.STOCK.NAME
     *
     * @param name the value for PUBLIC.STOCK.NAME
     *
     * @mbg.generated Sat Apr 23 14:40:33 EEST 2022
     */
    public void setName(String name) {
        this.name = name;
    }

    public List<Fund> funds;
}