package com.github.sources.dubbo.api.service;

import com.github.sources.dubbo.api.domain.UserDTO;

/**
 *
 */
public interface IUserService {

    UserDTO findUserByName(String userName);
}
