package com.github.sources.distributed.idempotent.service;

import com.github.sources.distributed.idempotent.domain.UserPO;

/**
 *
 */
public interface IUserService {

    int insertUser(UserPO userPO);
}
