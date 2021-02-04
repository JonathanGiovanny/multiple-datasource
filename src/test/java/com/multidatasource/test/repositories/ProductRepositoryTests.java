package com.multidatasource.test.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.multidatasource.test.secondary.model.ProductEntity;
import com.multidatasource.test.secondary.repositories.ProductRepository;

@SpringBootTest
@EnableTransactionManagement
public class ProductRepositoryTests {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void testProduct() {
		ProductEntity entity = ProductEntity.builder()
				.name("Product1")
				.description("Desc")
				.build();

		ProductEntity product = productRepository.save(entity);

		assertThat(product).isNotNull();
		assertThat(productRepository.findAll()).isNotEmpty();
	}
}
