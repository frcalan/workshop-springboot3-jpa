package io.productdemo.demo.resources;

import java.util.List;

import io.productdemo.demo.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.productdemo.demo.entities.Order;
import io.productdemo.demo.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PutMapping(value = "/status/{id}")
	public ResponseEntity<Order> updateStatus(@PathVariable Long id, @RequestBody Order obj) {
		obj = service.updateStatus(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@PutMapping(value = "/paying/{id}")
	public ResponseEntity<Order> updatePayment(@PathVariable Long id, @RequestBody Order obj) {
		obj = service.updatePayment(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
