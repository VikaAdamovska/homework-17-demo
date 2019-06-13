package org.hillel.homework.serialization;

import java.io.Serializable;

public class Student implements Serializable {

    protected String rating = "high";

    public Student() {
        System.out.println("This is default Student constructor");
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rating='" + rating + '\'' +
                '}';
    }
}
