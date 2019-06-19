package com.github.sources.distributed.idempotent.mapper;

import com.github.sources.distributed.idempotent.domain.UserPO;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface UserMapper {

//    @Insert("insert into t_user(user_name,password) values(#{userName},#{password})")
    int insert(UserPO userPO);

    UserPO findByID(Integer id);

    int removeUser(Integer id);


}
