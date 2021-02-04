package com.multidatasource.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.multidatasource.test.secondary.model.ProductEntity;
import com.multidatasource.test.secondary.repositories.ProductRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final @NonNull ProductRepository productRepository;

	public ProductEntity saveProduct(ProductEntity product) {
		return productRepository.save(product);
	}

	public List<ProductEntity> getAll() {
		return productRepository.findAll();
	}

}
