package me.g1tommy.etfportfolioanalyzer.repository;

import me.g1tommy.etfportfolioanalyzer.entity.isustock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockRepository extends JpaRepository<isustock, Long> {
    List<isustock> findByEtfCode(@Param("etfCode") String etfCode);
}
