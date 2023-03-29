package io.productdemo.demo.services;

import java.util.List;
import java.util.Optional;

import io.productdemo.demo.entities.Payment;
import io.productdemo.demo.entities.Product;
import io.productdemo.demo.resources.exceptions.DatabaseException;
import io.productdemo.demo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import io.productdemo.demo.entities.Order;
import io.productdemo.demo.services.repositores.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	public Order insert(Order order) {
		return repository.save(order);
	}

	public void delete(Long id) {

		try{
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Order updateStatus(Long id, Order order) {
		try {
			Order entity = repository.getReferenceById(id);
			updateDataStatus(entity, order);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	private void updateDataStatus(Order entity, Order order) {
		entity.setOrderStatus(order.getOrderStatus());
	}
	public Order updatePayment(Long id, Order order) {
		try {
			Order entity = repository.getReferenceById(id);
			updateDataPayment(entity, order);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateDataPayment(Order entity, Order order) {

		entity.setMoment(order.getMoment());
		entity.setOrderStatus(order.getOrderStatus());
		Payment pay = new Payment();
		pay.setId(order.getId());
		pay.setMoment(order.getPayment().getMoment());
		pay.setOrder(order);
		entity.setPayment(pay);
	}
}

/*		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		orderRepository.save(o1);*/
