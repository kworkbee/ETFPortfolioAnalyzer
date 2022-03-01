package me.g1tommy.etfportfolioanalyzer.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Optional;

@Builder
@Getter
public class ETFResponse<T> {
    Optional<MetaResponse> _meta;
    T data;
}
