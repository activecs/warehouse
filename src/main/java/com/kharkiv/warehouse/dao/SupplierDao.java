package com.kharkiv.warehouse.dao;

import java.util.List;

import com.kharkiv.warehouse.dto.Supplier;

public interface SupplierDao {

    List<Supplier> getAll();

    Supplier get(Integer id);

    Supplier create(Supplier p);

    Supplier update(Supplier p);

    void delete(Integer id);

}
