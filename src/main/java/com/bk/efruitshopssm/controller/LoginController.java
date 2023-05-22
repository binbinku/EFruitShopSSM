package com.bk.efruitshopssm.controller;

import com.bk.efruitshopssm.entity.Unit.LoginUnit;
import com.bk.efruitshopssm.entity.User;
import com.bk.efruitshopssm.mapper.UserMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController
{
    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    @ResponseBody
    public LoginBackUnit LoginHandler(@RequestBody LoginUnit data)
    {
        LoginBackUnit lbu = new LoginBackUnit();

        User user = new User();
        user.setAccount(data.getAccount());
        user.setPassword(data.getPassword());

        int nums = userMapper.UserLoginCheck(user);

        lbu.setLoginSucceeded(nums==1);
        lbu.setRedirectUrl("shop.html");

        return lbu;
    }

}


@Data
class LoginBackUnit
{
    private boolean loginSucceeded;
    private String redirectUrl;
}

