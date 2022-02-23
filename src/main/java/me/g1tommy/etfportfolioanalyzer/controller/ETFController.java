package me.g1tommy.etfportfolioanalyzer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import me.g1tommy.etfportfolioanalyzer.entity.StockEntity;
import me.g1tommy.etfportfolioanalyzer.entity.ETFListEntity;
import me.g1tommy.etfportfolioanalyzer.service.KRXServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/analyzer")
@CrossOrigin(origins = "*")
public class ETFController {

    @Autowired
    private KRXServiceImpl krxService;

    @Operation(summary = "Listing", description = "List all etfs")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Server Internal Error")
    })
    @ResponseBody
    @GetMapping("/etfs")
    public ResponseEntity<List<ETFListEntity>> list() throws IOException {
        return ResponseEntity.ok(krxService.getList());
    }

    @Operation(summary = "Querying", description = "Query ETF by code")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Server Internal Error")
    })
    @ResponseBody
    @GetMapping("/etf/{code}")
    public ResponseEntity<List<StockEntity>> portfolio(
            @PathVariable(name = "code") String code
    ) throws IOException {
        return ResponseEntity.ok(krxService.getStockDetail(code));
    }

}
