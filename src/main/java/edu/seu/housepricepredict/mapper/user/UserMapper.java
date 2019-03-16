package edu.seu.housepricepredict.mapper.user;

import edu.seu.housepricepredict.domain.user.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author guodonwu@163.com
 * @date 9:41 2019/3/13
 * 用户mapper
 */

public interface UserMapper {

    /**
     * 根据用户名模糊查询，分页查询
     */
    @Select("SELECT * FROM user LIMIT #{startIndex}, #{pageSize} " +
            "WHERE user_name LIKE CONCAT('%', #{userName}, '%')")
    List<User> getUserListByPage(@Param("startIndex") int startIndex,
                                 @Param("pageSize") int pageSize,
                                 @Param("userName") String userName);


    /**
     * 根据用户名和密码，获取用户
     */
    @Select("SELECT * FROM user WHERE user_name = #{userName} AND user_password = #{userPassword}")
    User getUserByNameAndPassword(User user);

    /**
     * 根据用户名获取用户
     */
    @Select("SELECT * FROM user WHERE user_name = #{userName}")
    User getUserByName(String userName);

    /**
     * 根据用户id获取用户信息
     */
    @Select("SELECT * FROM user WHERE user_id = #{uId}")
    User getUserById(int uId);

    /**
     * 插入用户信息
     */
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
    @Insert("INSERT INTO user VALUES(null, #{userName}, #{userPassword}, #{userEmail}, 0)")
    int insertUser(User user);

    /**
     * 更新用户信息
     */
    @Update("UPDATE user " +
            "SET user_name = #{userName}, user_passWord = #{userPassword}, user_email = #{userEmail} " +
            "WHERE user_id = #{userId}")
    int updateUser(User user);

    /**
     * 根据用户id删除用户信息
     */
    @Delete("DELETE FROM user WHERE user_id = #{uId}")
    int deleteUserById(int uId);

}
