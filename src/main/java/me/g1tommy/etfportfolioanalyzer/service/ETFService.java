package me.g1tommy.etfportfolioanalyzer.service;

import lombok.AllArgsConstructor;
import me.g1tommy.etfportfolioanalyzer.entity.etf;
import me.g1tommy.etfportfolioanalyzer.entity.isustock;
import me.g1tommy.etfportfolioanalyzer.repository.ETFRepository;
import me.g1tommy.etfportfolioanalyzer.repository.StockRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ETFService {

    private final ETFRepository etfRepository;
    private final StockRepository stockRepository;

    public Page<etf> getETFs(int page, int limit) {
        Pageable p = PageRequest.of(page, limit);
        return etfRepository.findAll(p);
    }

    public Page<etf> filterETFs(int page, int limit, String query) {
        Pageable p = PageRequest.of(page, limit);
        return etfRepository.findByEtfNameContains(query, p);
    }

    public List<isustock> getStocksByETF(String code) {
        return stockRepository.findByEtfCode(code);
    }
}
