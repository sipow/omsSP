package com.ubs.simonpowers.oms.datasource;

import org.springframework.stereotype.Repository;

import com.ubs.simonpowers.oms.domain.Stock;

@Repository
public class StockRepository extends InMemoryRepository<Stock> {}