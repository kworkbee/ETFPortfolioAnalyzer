package me.g1tommy.etfportfolioanalyzer.dto;

import lombok.Builder;

@Builder
public class ETFDto {

    public String etfCode;
    public String etfName;
    public String issuerName;
    public Double closingPrice;

}
