package es.scandel.christmas.service;

import es.scandel.christmas.model.Gift;

import java.util.List;

public interface GiftService {
    Gift findById(String id);

    List<Gift> findAll();

    Gift create(Gift gift);

    Gift update(Gift gift);

    void delete(String id);
}
