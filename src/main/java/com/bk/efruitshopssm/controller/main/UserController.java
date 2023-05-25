package com.bk.efruitshopssm.controller.main;

import com.bk.efruitshopssm.entity.User;
import com.bk.efruitshopssm.mapper.UserMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    UserMapper userMapper;
    @GetMapping("/searchuser")
    public List<User> SearchUserHandler(String searchAccount)
    {
        List<User> uls = userMapper.UserFuzzyQuery(searchAccount);

        return  uls;
    }

    @PostMapping("/moduser")
    public boolean ModUser(@RequestBody ModInfoRec rec)
    {
        int row = userMapper.UpdateUser(rec.getUser());
        return row!=0;
    }

    @PostMapping("/deluser")
    public boolean ModUser(@RequestBody DelIndoRec data)
    {
        System.out.println(data.getUid());
        int row = userMapper.DeleteUserByUid(data.getUid());
        return row!=0;
    }
}
@Data
class ModInfoRec
{
    private User user;
}
@Data
class DelIndoRec
{
    private int uid;
}