package com.kharkiv.warehouse.service;

import java.util.List;

import com.kharkiv.warehouse.dto.Supply;

public interface SupplyService {

    List<Supply> getAll();

    Supply get(Integer id);

    Supply create(Supply s);

    Supply update(Supply s);

    void delete(Integer id);
}
