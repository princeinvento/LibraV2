package com.powerpuff.librav2;

import android.widget.Button;

public class Books {
    String author,content,book_name,imgurl,path;



    public Books(String author, String content, String book_name, String imgurl, String path) {
        this.author = author;
        this.content = content;
        this.book_name = book_name;
        this.imgurl = imgurl;
        this.path = path;
    }

    public Books(String author, String content, String book_name, String imgurl) {
        this.author = author;
        this.content = content;
        this.book_name = book_name;
        this.imgurl = imgurl;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getPath() {return path;}

    public void setPath(String path) {this.path = path;}
}
