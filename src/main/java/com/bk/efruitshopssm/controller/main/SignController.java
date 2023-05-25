package com.bk.efruitshopssm.controller.main;

import com.bk.efruitshopssm.entity.Unit.LoginUnit;
import com.bk.efruitshopssm.entity.User;
import com.bk.efruitshopssm.mapper.UserMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignController
{
    @Autowired
    UserMapper userMapper;

    @PostMapping("/sign")
    public boolean LoginHandler(@RequestBody LoginUnit data)
    {
        User user = new User();
        user.setAccount(data.getAccount());
        user.setPassword(data.getPassword());
        if(userMapper.FindUserByAccout(user)>0)return false;
        userMapper.AddUser(user);
        if(userMapper.FindUserByAccout(user)<=0)
            return false;
        else
            return true;
    }

}
