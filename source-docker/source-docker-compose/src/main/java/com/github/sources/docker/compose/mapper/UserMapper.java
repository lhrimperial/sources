package com.github.sources.docker.compose.mapper;

import com.github.sources.docker.compose.domain.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hairen.long
 * @date 2019-04-25
 */
public interface UserMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into t_user(user_name,password,age) values(#{userName},#{password},#{age})")
    void save(UserDO userDO);

    @Select("select * from t_user where id = #{id}")
    UserDO queryById(Integer id);

    @Select("select * from t_user")
    List<UserDO> queryAll();
}

