package com.kharkiv.warehouse.dao;

import static com.kharkiv.warehouse.util.QueryNamesConstants.SupplyQueries.GET_ALL;
import static com.kharkiv.warehouse.util.QueryNamesConstants.SupplyQueries.GET_BY_ID;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.kharkiv.warehouse.dto.Supply;

@Repository
public class SupplyDaoImpl implements SupplyDao {

    private static final String DELETE_PRODUCT_QUERY = "DELETE FROM Supply s where s.id = :id";

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Supply> getAll() {
        TypedQuery<Supply> query = em.createNamedQuery(GET_ALL, Supply.class);
        return query.getResultList();
    }
    
    @Override
    public Supply get(Integer id) {
        TypedQuery<Supply> query = em.createNamedQuery(GET_BY_ID, Supply.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public Supply create(Supply c) {
        em.persist(c);
        em.flush();
        return c;
    }

    @Override
    public Supply update(Supply c) {
        return em.merge(c);
    }
    
    @Override
    public void delete(Integer id) {
        Query query = em.createQuery(DELETE_PRODUCT_QUERY);
        query.setParameter("id", id).executeUpdate();
    }

}
