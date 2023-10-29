package com.example.app_food;

import java.util.ArrayList;
import java.util.List;

public class category1 {
    private String nameCategory;
    private ArrayList<book1> books;

    public category1(String nameCategory, ArrayList<book1> books) {
        this.nameCategory = nameCategory;
        this.books = books;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public ArrayList<book1> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<book1> books) {
        this.books = books;
    }
}
