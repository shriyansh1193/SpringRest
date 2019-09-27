package com.shrey.training.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shrey.training.rest.product.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

	private static List<Product> listOfProduct = new ArrayList<Product>();

	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public String sayHello(@PathVariable("name") String username,
			@RequestParam(value = "comp", required = false) String company) {
		return "Hello " + username + " Company " + company;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Product addPrduct(@RequestBody Product p) {
		listOfProduct.add(p);
		return p;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") String id) {
		for (Product product : listOfProduct) {
			if (product.getId().equals(id)) {
				return product;
			}

		}
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Product deleteProduct(@PathVariable("id") String id) {
		Product del = null;
		for (Product product : listOfProduct) {
			if (product.getId().equals(id)) {
				del = product;
			}

		}
		if (del != null) {
			listOfProduct.remove(del);
		}
		return null;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Product updateProduct(Product pro) {
		for (Product product : listOfProduct) {
			if (product.getId().equals(pro.getId())) {
				product.setName(pro.getName());
				return product;
			}

		}
		return null;
	}
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public List<Product> getAll(){
		return listOfProduct;
	}
}
