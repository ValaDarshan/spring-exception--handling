package com.Darshan.LearnException.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Darshan.LearnException.Exceptions.ProductNotFoundByIdException;
import com.Darshan.LearnException.Model.Products;
import com.Darshan.LearnException.Service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public ResponseEntity<Products> addProduct(@RequestBody @Valid Products product){
		return new ResponseEntity<>(service.addProduct(product), HttpStatus.CREATED);
		
	}

	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Products>> getProducts(){
		return ResponseEntity.ok(service.getAllProduct());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Products> getProductById(@PathVariable long id) throws ProductNotFoundByIdException{
		return ResponseEntity.ok(service.getProductById(id));
	}
}
