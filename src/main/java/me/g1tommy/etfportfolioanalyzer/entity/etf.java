package me.g1tommy.etfportfolioanalyzer.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table
public class etf {
    @Id
    public String etfCode;

    @Column(nullable = false)
    public String etfName;

    @Column(nullable = false)
    public String etfQueryCode;

    @Column(nullable = false)
    public String issuerName;

    @Column(nullable = false)
    public Double closingPrice;
}
