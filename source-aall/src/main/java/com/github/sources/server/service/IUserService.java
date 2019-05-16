package com.github.sources.server.service;

import com.github.sources.server.domain.UserDO;

import java.util.List;

/**
 * @author hairen.long
 * @date 2019-05-08
 */
public interface IUserService {

    void save(UserDO userDO);

    void update(UserDO userDO);

    void getById(Integer id);

    List<UserDO> getAll();

}
