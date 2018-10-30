package com.esun.pandora.auth.server.repository;

import com.esun.pandora.auth.server.model.User;
import com.esun.pandora.foundation.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by esun on 2018/10/25.
 */
@Repository
public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
