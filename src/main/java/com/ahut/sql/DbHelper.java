package com.ahut.sql;

import com.ahut.Constants;
import com.ahut.model.BookBean;

import java.sql.*;

/**
 * Created by GIOPPL
 * on 2020/10/24 20:54
 * TODO:
 */
public class DbHelper {
    //数据库连接
    private static Connection connection = null;
    //mysql驱动包名
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://localhost:3306/book_manage?serverTimezone=UTC";

    /**
     * 连接数据库
     */
    public static void connectDB(){
        if (Constants.IS_CONNECT_SQL)
            return;

        try {
            //加载mysql的驱动类
            Class.forName(DRIVER_NAME);
            //获取数据库连接
            connection = DriverManager.getConnection(URL, Constants.SQL_ACCOUNT, Constants.SQL_PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            Constants.IS_CONNECT_SQL=false;
        }
        Constants.IS_CONNECT_SQL=true;
    }

    /**
     * 插入图书的所有信息
     * @param bean 图书的信息类
     */
    public static String insertBookAllMessage(BookBean bean)  {
        if (bean.getBook_name()==null||bean.getU_id()==null)
            return "书名和所有者不能为空";
        String sql="insert into "+Constants.Table_NAME_BOOK+" (book_name,author,publisher,publish_year,photo_url_1," +
                "photo_url_2,photo_url_3,price,original_price,classification,college,sibn,u_id) values ('" +
                bean.getBook_name()+"','"+
                bean.getAuthor()+"','"+
                bean.getPublisher()+"','"+
                bean.getPublish_year()+"','"+
                bean.getPhoto_url_1()+"','"+
                bean.getPhoto_url_2()+"','"+
                bean.getPhoto_url_3()+"',"+
                bean.getPrice()+","+
                bean.getOriginal_price()+","+
                bean.getClassification()+","+
                bean.getCollege()+",'"+
                bean.getSibn()+"','"+
                bean.getU_id()+
                "')";
        System.out.println(sql);
        Statement st = null;
        try {
            st = connection.createStatement();
            st.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return throwables.getMessage();
        }
        return null;
    }
}
