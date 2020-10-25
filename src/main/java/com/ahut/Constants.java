package com.ahut;

/**
 * Created by GIOPPL
 * on 2020/10/24 20:51
 * TODO:静态的一些数据
 */
public class Constants {

    public static String SQL_ACCOUNT = "root";

    //    public static String SQL_PWD="wh203110";
//    public static String MY_SQL_URL="140.143.226.166";
    public static String SQL_PWD = "123456";
    public static String MY_SQL_URL = "localhost";
    public static boolean IS_CONNECT_SQL = false;
    public static String Table_NAME_BOOK = "book";
    public static String Table_NAME_USER = "user";

    /**
     * 分页查询时每页数目
     */
    public static int PAGE_SIZE = 5;


    public static class TableBook {
        public static String TABLE_NAME = "book";
        public static String BOOK_NAME = "book_name";
        public static String AUTHOR = "author";
        public static String PUBLISHER = "publisher";
        public static String PUBLISH_YEAR = "publish_year";
        public static String PHOTO_URL_1 = "photo_url_1";
        public static String PHOTO_URL_2 = "photo_url_2";
        public static String PHOTO_URL_3 = "photo_url_3";
        public static String PRICE = "price";
        public static String ORIGINAL_PRICE = "original_price";
        public static String CLASSIFICATION = "classification";
        public static String COLLEGE = "college";
        public static String ISBN = "isbn";
        public static String USER = "user";
        public static String STATUS = "status";
        public static String QUANTITY = "quantity";
    }

}
