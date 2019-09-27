package com.shrey.training.rest.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

	@Id
	private String id;
	@NotBlank
	private String name;
	@Max(1000)
	private double price;
	private String category;

}
