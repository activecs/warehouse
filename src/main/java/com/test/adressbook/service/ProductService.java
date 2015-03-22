package com.test.adressbook.service;

import java.util.List;

import com.test.adressbook.contact.Product;

public interface ProductService {

    List<Product> getAll();

    Product get(Integer id);

    Product create(Product c);

    Product update(Product c);

    void delete(Integer id);
}
