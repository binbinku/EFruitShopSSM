package com.bk.efruitshopssm.controller.backstage;

import com.bk.efruitshopssm.entity.Admin;
import com.bk.efruitshopssm.entity.Unit.LoginBackUnit;
import com.bk.efruitshopssm.entity.Unit.LoginUnit;
import com.bk.efruitshopssm.entity.User;
import com.bk.efruitshopssm.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminLoginController
{
    @Autowired
    AdminMapper adminMapper;
    @PostMapping("/adminlogin")
    @ResponseBody
    public LoginBackUnit LoginHandler(@RequestBody LoginUnit data)
    {
        LoginBackUnit lbu = new LoginBackUnit();

        Admin admin  = new Admin();
        admin.setAdminaccount(data.getAccount());
        admin.setAdminpassword(data.getPassword());
        int nums = adminMapper.AdminLoginCheck(admin);
        lbu.setLoginSucceeded(nums==1);
        lbu.setRedirectUrl("backstage.html");

        return lbu;
    }
}
