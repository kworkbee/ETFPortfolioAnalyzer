package me.g1tommy.etfportfolioanalyzer.repository;

import me.g1tommy.etfportfolioanalyzer.entity.isustock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface StockRepository extends PagingAndSortingRepository<isustock, Long> {
    @RestResource(path="etf")
    Page<isustock> findByEtfCode(@Param("etfCode") String etfCode, Pageable p);
}
