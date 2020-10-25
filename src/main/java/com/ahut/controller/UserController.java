package com.ahut.controller;

import com.ahut.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by GIOPPL
 * on 2020/10/23 16:14
 * TODO:用户的控制器
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/PoseDemo", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    String checkNameValidMethod2(@RequestBody String json) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        User data = jsonMapper.readValue(json, User.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name", data.getUsername());
        map.put("age", data.getAge()+1);
        map.put("pwd", data.getPassword());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }


}
