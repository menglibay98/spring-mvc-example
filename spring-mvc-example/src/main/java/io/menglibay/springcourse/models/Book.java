package io.menglibay.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {

    private int id;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2,max = 100,message = "Title will be more than 2 ")
    private String title;

    @NotEmpty(message = "Author should not be empty")
    @Size(min = 2,max = 100,message = "Author will be more than 2 ")
    private String author;

    @Min(value = 1500,message = "Year should more than 1500")
    private int year;

    public Book(){

    }

    public Book(String title,String author,int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
