package me.g1tommy.etfportfolioanalyzer.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MetaResponse {
    long totalItems;
    long currentPage;
    long lastPage;
    boolean isLast;
}
