package me.g1tommy.etfportfolioanalyzer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table
public class isustock {

    @Id
    public Long id;

    @Column
    public String etfCode;

    @Column
    public String stockName;

    @Column
    public String stockCode;

    @Column
    public Double stockRatio;

    @Column
    public Long stockCount;

    @Column
    public Long stockInitValue;

    @Column
    public Long stockCurrentValue;

    @Column
    public boolean isOverseas;
}
