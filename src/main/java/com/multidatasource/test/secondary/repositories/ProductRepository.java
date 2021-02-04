package com.multidatasource.test.secondary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multidatasource.test.secondary.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
