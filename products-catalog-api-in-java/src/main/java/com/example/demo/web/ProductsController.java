package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@RestController
@RequestMapping(value = "/v1/api/products")
public class ProductsController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping(produces = { "application/json" })
	public ResponseEntity<List<Product>> getAll() {
		List<Product> products = productRepository.findAll();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

//		HttpHeaders headers = new HttpHeaders();
//		headers.add("location", "http://localhost:8080/v2/api/products");
//		return new ResponseEntity<List<Product>>(null, headers, HttpStatus.MOVED_PERMANENTLY);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> get(@PathVariable int id) {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent())
			return new ResponseEntity<Product>(optional.get(), HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(consumes = { "application/json" })
	public ResponseEntity<Product> post(@RequestBody Product product) {
		Product prod = productRepository.save(product);
		return new ResponseEntity<Product>(prod, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}", consumes = { "application/json" })
	public ResponseEntity<Product> put(@PathVariable int id, @RequestBody Product product) {
		Product prod = productRepository.getOne(id);
		// ..
		return new ResponseEntity<Product>(prod, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Product> delete(@PathVariable int id) {
		productRepository.delete(productRepository.getOne(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
