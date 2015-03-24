package com.kharkiv.warehouse.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kharkiv.warehouse.dao.SupplierDao;
import com.kharkiv.warehouse.dto.Supplier;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Inject
    private SupplierDao supplierDao;

    @Override
    public List<Supplier> getAll() {
        return supplierDao.getAll();
    }
    
    @Override
    public Supplier get(Integer id) {
        return supplierDao.get(id);
    }

    @Override
    public Supplier create(Supplier c) {
        return supplierDao.create(c);
    }

    @Override
    public Supplier update(Supplier c) {
        return supplierDao.update(c);
    }

    @Override
    public void delete(Integer id) {
        supplierDao.delete(id);
    }

}
