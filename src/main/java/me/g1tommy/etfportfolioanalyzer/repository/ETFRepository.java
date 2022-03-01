package me.g1tommy.etfportfolioanalyzer.repository;

import me.g1tommy.etfportfolioanalyzer.entity.etf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface ETFRepository extends PagingAndSortingRepository<etf, Long> {
    Page<etf> findByEtfNameContains(@Param("query") String query, Pageable p);
}
