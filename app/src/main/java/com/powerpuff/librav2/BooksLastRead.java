package com.powerpuff.librav2;

public class BooksLastRead {
    String bookname;
    String type;
    String imgurl;
    String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BooksLastRead(String bookname, String type, String imgurl, String path) {
        this.path = path;
        this.bookname = bookname;
        this.type = type;
        this.imgurl = imgurl;
    }
    public BooksLastRead(String bookname, String type, String imgurl) {
        this.bookname = bookname;
        this.type = type;
        this.imgurl = imgurl;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
