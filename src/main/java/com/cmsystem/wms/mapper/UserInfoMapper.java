package com.cmsystem.wms.mapper;

import com.cmsystem.wms.entity.Sort;
import com.cmsystem.wms.model.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select top 1 * from [user] where id = #{id} ")
    UserInfo findById(@Param("id") Integer id);

    @Select("select top 1 * from [user] where user_name = #{userName} and is_del is null ")
    UserInfo findByUserName(@Param("userName") String userName);

    // 更新用户Token
    Integer refreshToken(@Param("user") UserInfo user);

    // 查询用户信息
    List<UserInfo> selectUserWhere(@Param("form") UserInfo user, @Param("sort") Sort sort);

    // 添加用户
    Integer insert(@Param("user") UserInfo user);

    // 编辑用户
    Integer update(@Param("user") UserInfo user);

    // 修改密码
    @Update("update [user] password = #{user.password} where id = #{user.id}")
    Integer changePassword(@Param("user") UserInfo user);

    // 批量删除
    @Update("update [user] set is_del = now() where id in (${ids})")
    Integer deleteByIds(@Param("ids") String ids);

    Integer logout(@Param("user") UserInfo user);

    Integer updatePassword(@Param("user") UserInfo user);

}
