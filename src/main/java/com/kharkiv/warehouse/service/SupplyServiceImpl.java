package com.kharkiv.warehouse.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kharkiv.warehouse.dao.SupplyDao;
import com.kharkiv.warehouse.dto.Supply;

@Service
@Transactional
public class SupplyServiceImpl implements SupplyService {

    @Inject
    private SupplyDao supplierDao;

    @Override
    public List<Supply> getAll() {
        return supplierDao.getAll();
    }
    
    @Override
    public Supply get(Integer id) {
        return supplierDao.get(id);
    }

    @Override
    public Supply create(Supply c) {
        return supplierDao.create(c);
    }

    @Override
    public Supply update(Supply c) {
        return supplierDao.update(c);
    }

    @Override
    public void delete(Integer id) {
        supplierDao.delete(id);
    }

}
