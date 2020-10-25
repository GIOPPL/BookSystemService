package com.ahut.sql;

import com.ahut.Constants;
import com.ahut.model.BookBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GIOPPL
 * on 2020/10/24 20:54
 * TODO:
 */
public class DbHelper {
    //数据库连接
    private static Connection connection = null;
    //
    private static Statement st = null;
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
            st = connection.createStatement();
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
        System.out.println("插入图书的所有信息:"+sql);

        try {

            st.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return throwables.getMessage();
        }
        return null;
    }

    /**
     * 查询图书通过ISBN
     * @param isbn 图书的ISBN
     * @return 所有的这个ISBN码的图书
     */
    public static List<BookBean> queryBookByIsbn(String isbn){
        if (isbn==null||isbn.isEmpty()) return null;
        String sql="select * from "+Constants.Table_NAME_BOOK+" where isbn='"+isbn+"'";
        System.out.println(sql);
        ResultSet rs=null;
        List<BookBean> mList=new ArrayList<>();
        try {
            rs= st.executeQuery(sql);
            while(rs.next()){
                String book_name=rs.getString("book_name");
                String author=rs.getString("author");
                String publisher=rs.getString("publisher");
                String publish_year=rs.getString("publish_year");
                String photo_url_1=rs.getString("photo_url_1");
                String photo_url_2=rs.getString("photo_url_2");
                String photo_url_3=rs.getString("photo_url_3");
                float price=rs.getFloat("price");
                float original_price=rs.getFloat("original_price");
                int classification=rs.getInt("classification");
                int college=rs.getInt("college");
                String u_id=rs.getString("u_id");
                BookBean bean=new BookBean(book_name,author,publisher,publish_year,photo_url_1,photo_url_2,photo_url_3,
                        price,original_price,classification,college,isbn,u_id);
                mList.add(bean);
            }
            return mList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
