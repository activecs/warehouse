package com.test.adressbook.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.test.adressbook.contact.Product;
import com.test.adressbook.util.Constants;

@Repository
public class ProductDaoImpl implements ProductDao {

    private static final String DELETE_PRODUCT_QUERY = "DELETE FROM Product p where p.id = :id";

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = em.createNamedQuery(Constants.GET_ALL_CONTANCTS, Product.class);
        return query.getResultList();
    }
    
    @Override
    public Product get(Integer id) {
        TypedQuery<Product> query = em.createNamedQuery(Constants.GET_CONTANCT_BY_ID, Product.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public Product create(Product c) {
        em.persist(c);
        em.flush();
        return c;
    }

    @Override
    public Product update(Product c) {
        return em.merge(c);
    }
    
    @Override
    public void delete(Integer id) {
        Query query = em.createQuery(DELETE_PRODUCT_QUERY);
        query.setParameter("id", id).executeUpdate();
    }

}
