package com.bk.efruitshopssm.mapper;

import com.bk.efruitshopssm.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper
{
    List<User> GetAllUser();
    int UserLoginCheck(User user);
    int FindUserByAccout(User user);
    void AddUser(User user);
    List<User> UserFuzzyQuery(String account);
    int UpdateUser(User user);
    int DeleteUserByUid(int uid);
}
