package com.kharkiv.warehouse.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kharkiv.warehouse.dto.Product;
import com.kharkiv.warehouse.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Inject
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAll() {
        return productService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getById(@PathVariable Integer id) {
        return productService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@Valid Product p) {
        return productService.create(p);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Product update(@Valid Product p) {
        return productService.update(p);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }
}
