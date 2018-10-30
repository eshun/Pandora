package com.esun.pandora.foundation.service.impl;

import com.esun.pandora.foundation.model.BaseModel;
import com.esun.pandora.foundation.repository.BaseRepository;
import com.esun.pandora.foundation.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by esun on 2018/10/26.
 */
@Service
public class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {

    private static final Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    private BaseRepository<T> baseRepository;

    public Optional<T> findById(Long id) {
        return baseRepository.findById(id);
    }
    public boolean existsById(Long id) {
        return baseRepository.existsById(id);
    }
    public void deleteById(Long id){
        baseRepository.deleteById(id);
    }
    public void delete(T entity){
        baseRepository.delete(entity);
    }
    public void deleteAll(Iterable<? extends T> entities){
        baseRepository.deleteAll(entities);
    }
    public T save(T entity) {
        return baseRepository.save(entity);
    }
    public Iterable<T> saveAll(Iterable<T> entities){
        return baseRepository.saveAll(entities);
    }
    public void flush() {
        baseRepository.flush();
    }
}
