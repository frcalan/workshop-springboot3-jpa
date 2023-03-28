package io.productdemo.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import io.productdemo.demo.entities.Category;
import io.productdemo.demo.entities.User;
import io.productdemo.demo.resources.exceptions.DatabaseException;
import io.productdemo.demo.services.exceptions.ResourceNotFoundException;
import io.productdemo.demo.services.repositores.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
	public Category insert(Category category) {
		return repository.save(category);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}  catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Category update(Long id, Category category) {
		try {
			Category entity = repository.getReferenceById(id);
			updateData(entity, category);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Category entity, Category category) {
		entity.setName(category.getName());
	}

}
