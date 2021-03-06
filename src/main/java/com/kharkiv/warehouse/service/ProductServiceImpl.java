package com.kharkiv.warehouse.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kharkiv.warehouse.dao.ProductDao;
import com.kharkiv.warehouse.dto.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Inject
    private ProductDao productDao;

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }
    
    @Override
    public Product get(Integer id) {
        return productDao.get(id);
    }

    @Override
    public Product create(Product c) {
        return productDao.create(c);
    }

    @Override
    public Product update(Product c) {
        return productDao.update(c);
    }

    @Override
    public void delete(Integer id) {
        productDao.delete(id);
    }

}
