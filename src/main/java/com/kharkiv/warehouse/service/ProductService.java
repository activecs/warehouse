package com.kharkiv.warehouse.service;

import java.util.List;

import com.kharkiv.warehouse.dto.Product;

public interface ProductService {

    List<Product> getAll();

    Product get(Integer id);

    Product create(Product c);

    Product update(Product c);

    void delete(Integer id);
}
