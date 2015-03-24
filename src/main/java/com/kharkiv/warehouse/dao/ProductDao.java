package com.kharkiv.warehouse.dao;

import java.util.List;

import com.kharkiv.warehouse.dto.Product;

public interface ProductDao {

    List<Product> getAll();

    Product get(Integer id);

    Product create(Product p);

    Product update(Product p);

    void delete(Integer id);

}
