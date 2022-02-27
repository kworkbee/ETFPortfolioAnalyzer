package me.g1tommy.etfportfolioanalyzer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

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
}
