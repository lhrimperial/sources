package com.github.sources.server.mapper;

import com.github.sources.server.domain.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hairen.long
 * @date 2019-05-08
 */
public interface UserMapper {

    @Insert("insert into t_user(user_name,password) values(#{userName},#{password})")
    void save(UserDO userDO);

    void update(UserDO userDO);

    @Select("select * from t_user where id = #{id}")
    void getById(Integer id);

    @Select("select * from t_user")
    List<UserDO> getAll();

    @Select("select * from t_user limit #{offset},#{limit}")
    List<UserDO> getByPage(@Param("offset") int offset, @Param("limit") int limit);
}
