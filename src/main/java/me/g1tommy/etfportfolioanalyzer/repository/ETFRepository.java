package me.g1tommy.etfportfolioanalyzer.repository;

import me.g1tommy.etfportfolioanalyzer.entity.etf;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ETFRepository extends PagingAndSortingRepository<etf, Long> {

}
