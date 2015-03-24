package com.kharkiv.warehouse.dao;

import static com.kharkiv.warehouse.util.QueryNamesConstants.SupplierQueries.GET_ALL;
import static com.kharkiv.warehouse.util.QueryNamesConstants.SupplierQueries.GET_BY_ID;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.kharkiv.warehouse.dto.Supplier;

@Repository
public class SupplierDaoImpl implements SupplierDao {

    private static final String DELETE_PRODUCT_QUERY = "DELETE FROM Supplier s where s.id = :id";

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Supplier> getAll() {
        TypedQuery<Supplier> query = em.createNamedQuery(GET_ALL, Supplier.class);
        return query.getResultList();
    }
    
    @Override
    public Supplier get(Integer id) {
        TypedQuery<Supplier> query = em.createNamedQuery(GET_BY_ID, Supplier.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public Supplier create(Supplier c) {
        em.persist(c);
        em.flush();
        return c;
    }

    @Override
    public Supplier update(Supplier c) {
        return em.merge(c);
    }
    
    @Override
    public void delete(Integer id) {
        Query query = em.createQuery(DELETE_PRODUCT_QUERY);
        query.setParameter("id", id).executeUpdate();
    }

}
