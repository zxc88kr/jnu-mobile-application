package com.example.project03.model;

import java.util.ArrayList;

public class CartRepository {
    public ArrayList<Book> cartBooks = new ArrayList<Book>();

    public void addCart(Book book) {
        boolean flag = false;

        for (int i = 0; i < cartBooks.size(); i++) {
            if (cartBooks.get(i).id.equals(book.id)) {
                cartBooks.get(i).quantity++;
                flag = true;
                break;
            }
        }
        if (!flag) {
            book.quantity = 1;
            book.isChecked = true;
            cartBooks.add(book);
        }
    }

    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (int i = 0; i < cartBooks.size(); i++) {
            totalQuantity += cartBooks.get(i).quantity;
        }
        return totalQuantity;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < cartBooks.size(); i++) {
            if (cartBooks.get(i).isChecked) {
                totalPrice += cartBooks.get(i).price * cartBooks.get(i).quantity;
            }
        }
        return totalPrice;
    }
}