package com.ahut.model;

/**
 * Created by GIOPPL
 * on 2020/10/24 21:15
 * TODO:
 */
public class BookBean {


    /**
     * book_name : 雅思词汇
     * author : PPL
     * publisher : 人民出版社
     * publish_year : 2015
     * photo_url_1 : aaa
     * photo_url_2 : bbb
     * photo_url_3 : ccc
     * original_price : 12.3
     * classification : 1
     * price : 12.3
     * college : 1
     * isbn : 12345667
     */

    private String book_name;
    private String author;
    private String publisher;
    private String publish_year;
    private String photo_url_1;
    private String photo_url_2;
    private String photo_url_3;
    private float price;
    private float original_price;
    private int classification;
    private int college;
    private String isbn;
    private String user;
    private int status;
    private int quantity;

    public BookBean(String book_name, String author, String publisher, String publish_year, String photo_url_1, String photo_url_2, String photo_url_3, float price, float original_price, int classification, int college, String isbn, String user, int status, int quantity) {
        this.book_name = book_name;
        this.author = author;
        this.publisher = publisher;
        this.publish_year = publish_year;
        this.photo_url_1 = photo_url_1;
        this.photo_url_2 = photo_url_2;
        this.photo_url_3 = photo_url_3;
        this.price = price;
        this.original_price = original_price;
        this.classification = classification;
        this.college = college;
        this.isbn = isbn;
        this.user = user;
        this.status = status;
        this.quantity = quantity;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BookBean(){}

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublish_year() {
        return publish_year;
    }

    public void setPublish_year(String publish_year) {
        this.publish_year = publish_year;
    }

    public String getPhoto_url_1() {
        return photo_url_1;
    }

    public void setPhoto_url_1(String photo_url_1) {
        this.photo_url_1 = photo_url_1;
    }

    public String getPhoto_url_2() {
        return photo_url_2;
    }

    public void setPhoto_url_2(String photo_url_2) {
        this.photo_url_2 = photo_url_2;
    }

    public String getPhoto_url_3() {
        return photo_url_3;
    }

    public void setPhoto_url_3(String photo_url_3) {
        this.photo_url_3 = photo_url_3;
    }

    public float getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(float original_price) {
        this.original_price = original_price;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCollege() {
        return college;
    }

    public void setCollege(int college) {
        this.college = college;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
