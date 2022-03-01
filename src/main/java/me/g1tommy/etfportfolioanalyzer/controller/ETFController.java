package me.g1tommy.etfportfolioanalyzer.controller;

import lombok.AllArgsConstructor;
import me.g1tommy.etfportfolioanalyzer.entity.etf;
import me.g1tommy.etfportfolioanalyzer.entity.isustock;
import me.g1tommy.etfportfolioanalyzer.response.ETFResponse;
import me.g1tommy.etfportfolioanalyzer.response.MetaResponse;
import me.g1tommy.etfportfolioanalyzer.service.ETFService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ETFController {

    private final ETFService etfService;

    @GetMapping("/etfs")
    public ResponseEntity<ETFResponse<etf>> getETFList(
            @RequestParam(value = "size", required = false, defaultValue = "1") int size,
            @RequestParam(value = "page", required = false, defaultValue = "1") int currentPage,
            @RequestParam(value = "query", required = false, defaultValue = "") String query
    ) {
        Page<etf> result;
        if (query.isEmpty()) {
            result = etfService.getETFs(currentPage - 1, size);
        }

        result = etfService.filterETFs(currentPage - 1, size, query);

        MetaResponse metaResponse = MetaResponse.builder()
                .totalItems(result.getTotalElements())
                .currentPage(currentPage)
                .lastPage(result.getTotalPages())
                .isLast(currentPage == result.getTotalPages() - 1)
                .build();

        ETFResponse response = ETFResponse.builder()
                ._meta(Optional.ofNullable(metaResponse))
                .data(result.getContent())
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/etf/{etfCode}/stocks")
    public ResponseEntity<ETFResponse<isustock>> getStocksByETF(@PathVariable(name = "etfCode") String etfCode) {
        ETFResponse response = ETFResponse.builder()
                ._meta(Optional.ofNullable(null))
                .data(etfService.getStocksByETF(etfCode))
                .build();

        return ResponseEntity.ok(response);
    }

}
