package com.Darshan.LearnException.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Darshan.LearnException.Exceptions.ProductNotFoundByIdException;
import com.Darshan.LearnException.Model.Products;
import com.Darshan.LearnException.Repository.ProductRepos;

@Service
public class ProductService {
	
	@Autowired
	ProductRepos repository;
	
	public Products addProduct(Products product) {
		return repository.save(product);
	}
	
	public List<Products> getAllProduct(){
		return repository.findAll();
	}
	
	public Products getProductById(long id) throws ProductNotFoundByIdException {
		
		Products product = repository.findByPid(id);
		if(product != null) {
			return product;
		}
		else {
			throw new ProductNotFoundByIdException("Product not found with id:"+id);
		}
		
	}

}
