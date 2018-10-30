package com.esun.pandora.auth.server.service;

import com.esun.pandora.auth.server.model.User;
import com.esun.pandora.foundation.security.IUserService;
import com.esun.pandora.foundation.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * Created by esun on 2018/10/25.
 */
@Service
public interface UserService extends BaseService<User>,IUserService {


    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
