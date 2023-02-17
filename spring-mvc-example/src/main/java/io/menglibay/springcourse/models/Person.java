package io.menglibay.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2,max = 100,message = "Name should be 2 and 100 character")
    private String fullName;


    @Min(value = 1900, message = "Age should be greater than 0")
    private int yearOfBirth;

    public Person(){

    }

    public Person(int people_id, String fullName, int yearOfBirth) {
        this.id = people_id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int people_id) {
        this.id = people_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
