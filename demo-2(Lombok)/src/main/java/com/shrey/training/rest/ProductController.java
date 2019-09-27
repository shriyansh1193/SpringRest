package com.shrey.training.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shrey.training.rest.product.Product;
import com.shrey.training.rest.product.dao.ProductRepo;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductRepo repo;

	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public String sayHello(@PathVariable("name") String username, @RequestParam("comp") String company) {
		return "Hello " + username + " Company " + company;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Product addPrduct(@RequestBody Product p) {
		repo.save(p);
		return p;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") String id) {
		Optional<Product> findById = repo.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Product deleteProduct(@PathVariable("id") String id) {
		repo.deleteById(id);
		return null;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Product updateProduct(@PathVariable("id") String id, @RequestParam Product pro) {
		Optional<Product> findById = repo.findById(id);
		if (findById.isPresent()) {
			Product product = findById.get();
			product.setName(pro.getName());
		}
		return null;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Product> getAll(@RequestParam("page") int page,@RequestParam("pageSize") int size) {
		Page<Product> findAll = repo.findAll(PageRequest.of(page, size));
		return findAll.getContent();
	}
}
