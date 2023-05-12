package com.supriya.StockManagement.repositories;

import com.supriya.StockManagement.models.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStockRepository extends CrudRepository<Stock,Integer> {

    public Stock getByStockName(String stockName);

    public ResponseEntity<List<Stock>> findByReleasedDateGreaterThan(String date);

    public ResponseEntity<List<Stock>> findByReleasedDateLessThan(String date);
}
