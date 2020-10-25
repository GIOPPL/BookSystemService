package com.ahut.controller;

import com.ahut.model.BookBean;
import com.ahut.model.BaseResponseBean;
import com.ahut.model.User;
import com.ahut.sql.DbHelper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GIOPPL
 * on 2020/10/24 20:49
 * TODO:
 */
@Controller
@RequestMapping(value = "/book")
public class BookController {
    /**
     * 测试
     */
    @RequestMapping(value = "/sqlDemo", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    String sqlDemo(@RequestBody String json) throws IOException {
        DbHelper.connectDB();
        ObjectMapper jsonMapper = new ObjectMapper();
        User data = jsonMapper.readValue(json, User.class);
        Map<String, Object> map = new HashMap<>();
        map.put("name", data.getUsername());
        map.put("age", data.getAge()+1);
        map.put("pwd", data.getPassword());
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }

    /**
     * 插入图书，其中书名，图书所有者不能为空
     * @param json 客户端上传的图书信息json
     * @return 插入是否成功
     */
    @RequestMapping(value = "/addBook", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    String addBook(@RequestBody String json) throws IOException {
        DbHelper.connectDB();
        ObjectMapper jsonMapper = new ObjectMapper();
        BookBean data = jsonMapper.readValue(json, BookBean.class);
        String msg=DbHelper.insertBookAllMessage(data);
        BaseResponseBean<String> myResponseBean=new BaseResponseBean<>();
        if (msg==null){
            myResponseBean.setCode(200);
            myResponseBean.setData("插入成功");
            myResponseBean.setMsg("success");
        }else {
            myResponseBean.setCode(300);
            myResponseBean.setData(msg);
            myResponseBean.setMsg("failure");
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(myResponseBean);
    }

    /**
     * 查询图书通过ISBN
     * @param isbn
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/searchBookByIsbn", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    String searchBookByIsbn(@RequestBody String isbn) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        if (isbn==null||isbn.isEmpty()){
            BaseResponseBean<String> myResponseBean=new BaseResponseBean<>();
            myResponseBean.setCode(300);
            myResponseBean.setData("ISBN不能为空");
            myResponseBean.setMsg("failure");
            return mapper.writeValueAsString(myResponseBean);
        }
        DbHelper.connectDB();
        List<BookBean> mList=DbHelper.queryBookByIsbn(isbn);
        if (mList==null){
            BaseResponseBean<String> myResponseBean=new BaseResponseBean<>();
            myResponseBean.setCode(300);
            myResponseBean.setData("查询失败");
            myResponseBean.setMsg("failure");
            return mapper.writeValueAsString(myResponseBean);
        }else {
            BaseResponseBean<List<BookBean>> myResponseBean=new BaseResponseBean<>();
            myResponseBean.setCode(200);
            myResponseBean.setMsg("success");
            myResponseBean.setData(mList);
            return JSON.toJSONString(myResponseBean);
        }
    }

}
