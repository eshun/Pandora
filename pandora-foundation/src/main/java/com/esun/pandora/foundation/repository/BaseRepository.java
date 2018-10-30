package com.esun.pandora.foundation.repository;

import com.esun.pandora.foundation.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by esun on 2018/10/26.
 */
@Repository
public interface BaseRepository<T extends BaseModel>  extends JpaRepository<T, Long> {
}
