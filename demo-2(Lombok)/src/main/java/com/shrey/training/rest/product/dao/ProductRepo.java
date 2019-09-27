package com.shrey.training.rest.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shrey.training.rest.product.Product;

public interface ProductRepo extends JpaRepository<Product, String> {

	public List<Product> findAll();

	public List<Product> findByName(String name);

	public List<Product> findByNameAndPriceBetween(String name, double min, double max);

}
