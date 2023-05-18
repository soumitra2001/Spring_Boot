package com.supriya.StockManagement.services;

import com.supriya.StockManagement.models.Stock;
import com.supriya.StockManagement.repositories.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private IStockRepository stockRepository;

    private List<Stock> stocks;
    public ResponseEntity<List<Stock>> getAll() {
        stocks =(List<Stock>) stockRepository.findAll();
        if(stocks.size()>0){
            return new ResponseEntity<>(stocks, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    public Stock getBystockName(String stockName) {
        return stockRepository.getByStockName(stockName);
    }

    public ResponseEntity<List<Stock>> getStocksByDateGreater(String date) {
        return stockRepository.findByReleasedDateGreaterThan(date);
    }

    public ResponseEntity<List<Stock>> getStockByDateLess(String date) {
    return stockRepository.findByReleasedDateLessThan(date);
    }

    public String addAllStock(List<Stock> stocks) {
        if(stocks.size()>0){
            stockRepository.saveAll(stocks);
            return "Stocks are added successfully...!";
        }
        return "Invalid user input...!";
    }


}
