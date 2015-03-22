package com.test.adressbook.dao;

import java.util.List;

import com.test.adressbook.contact.Product;

public interface ProductDao {

    List<Product> getAll();

    Product get(Integer id);

    Product create(Product p);

    Product update(Product p);

    void delete(Integer id);

}
