package com.ubs.simonpowers.oms.presentation;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubs.simonpowers.oms.datasource.InMemoryRepository;
import com.ubs.simonpowers.oms.domain.Order;
import com.ubs.simonpowers.oms.domain.Stock;
import com.ubs.simonpowers.oms.domain.User;

@CrossOrigin(origins = "*")
@RestController
@ExposesResourceFor(Stock.class)
@RequestMapping(value = "/stock", produces = "application/json")
public class OMSController {

	@Autowired
	private InMemoryRepository<Stock> stockRepository;

	@Autowired
	private InMemoryRepository<User> userRepository;
	
	@Autowired
	private StockResourceAssembler assembler;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<StockResource>> findAllStocks() {
		if ( stockRepository.getCount() == 0 ) {
			// TODO Thread Safety
			init();
		}
		List<Stock> stocks = stockRepository.findAll();
		return new ResponseEntity<>(assembler.toResourceCollection(stocks), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<StockResource> updateOrder(@RequestBody Order order) {
		/*
		 * TODO - Make this accessible via browser.
		 * This has been tested by disabling security and using
		 * "Advanced Rest Client" plugin for Google Chrome, as
		 * the HTML frontend doesn't link in yet
		 */
		if ( stockRepository.getCount() == 0 ) {
			// TODO Thread Safety
			init();
		}
		boolean success = false;
		Optional<Stock> stockOptional = stockRepository.findById(order.getStockId());
		if (stockOptional.isPresent()) {
			Stock stock = stockOptional.get();
			Optional<User> userOptional = userRepository.findById(order.getUserId());
			if ( userOptional.isPresent() ) {
				User user = userOptional.get();
				System.out.println("User Balance " + user.getBalance());
				if ( order.getBuy() == 0 ) {
					user.setBalance( user.getBalance() - stock.getPrice() * order.getQty() );
				} else {
					user.setBalance( user.getBalance() + stock.getPrice() * order.getQty() );
				}
				System.out.println("User Balance New " + user.getBalance());
				success = true;
			}
		}
		
		return new ResponseEntity<>( success ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	public void init() {
		stockRepository.create(new Stock(1l, "STOCK1", 50));
		stockRepository.create(new Stock(2l, "STOCK2", 150));
		stockRepository.create(new Stock(3l, "STOCK3", 20));
		stockRepository.create(new Stock(4l, "STOCK4", 500));
		stockRepository.create(new Stock(5l, "STOCK5", 230));
		
		userRepository.create(new User(1l, "Simon", "Powers", 50));
		userRepository.create(new User(2l, "Andy", "NG", 100));
	}
}