package com.supriya.StockManagement.controllers;

import com.supriya.StockManagement.models.Stock;
import com.supriya.StockManagement.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStock(){
        return stockService.getAll();
    }

    @GetMapping(value = "/{stockName}")
    public Stock getStockByName(@PathVariable String stockName){
        return stockService.getBystockName(stockName);
    }

    @GetMapping(value = "/released-greater/{date}")
    public ResponseEntity<List<Stock>> getAllByDateGreater(@PathVariable String date){
        return stockService.getStocksByDateGreater(date);
    }

    @GetMapping(value = "/released-less/{date}")
    public ResponseEntity<List<Stock>> getAllByDateLess(@PathVariable String date){
        return stockService.getStockByDateLess(date);
    }

    @PostMapping
    public String insertStocks(@RequestBody List<Stock> stocks){
        return stockService.addAllStock(stocks);
    }

}
