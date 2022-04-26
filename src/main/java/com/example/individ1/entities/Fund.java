package com.example.individ1.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Fund.findAll", query = "select t from Fund as t")
})
@Table(name = "FUND")
@Getter
@Setter
public class Fund implements Serializable {

    public Fund(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "funds_stocks",
            joinColumns = @JoinColumn(name = "fund_id"),
            inverseJoinColumns = @JoinColumn(name = "stock_id"))
    private Set<Stock> stocks;

    @OneToMany
    @JoinColumn(name="FUND_ID")
    private List<Manager> managers;
}