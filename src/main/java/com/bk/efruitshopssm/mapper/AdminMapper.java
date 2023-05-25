package com.bk.efruitshopssm.mapper;

import com.bk.efruitshopssm.entity.Admin;
import com.bk.efruitshopssm.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper
{
    int AdminLoginCheck(Admin admin);
}
