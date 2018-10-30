package com.esun.pandora.foundation.service;

import com.esun.pandora.foundation.model.BaseModel;

import java.util.Optional;

/**
 * Created by esun on 2018/10/26.
 */
public interface BaseService<T extends BaseModel> {
    Optional<T> findById(Long id);
    boolean existsById(Long id);
    void deleteById(Long id);
    void delete(T entity);
    void deleteAll(Iterable<? extends T> entities);
    T save(T entity);
    Iterable<T> saveAll(Iterable<T> entities);
    void flush();

}
