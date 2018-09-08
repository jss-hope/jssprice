package com.example.lowercase.contorller;

import com.example.lowercase.mapper.UserMapper;
import com.example.lowercase.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/info")
    public String getInfo(Long userid){
        User user = userMapper.selectByPrimaryKey(userid);
        return user.getUserName();
    }
}
