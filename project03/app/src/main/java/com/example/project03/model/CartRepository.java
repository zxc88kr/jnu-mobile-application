package com.example.project03.model;

import java.util.ArrayList;

public class CartRepository {
    public ArrayList<Book> cartBooks = new ArrayList<Book>();

    public void addItem(Book item) {
        boolean isChanged = false;

        for (int i = 0; i < cartBooks.size(); i++) {
            if (cartBooks.get(i).id.equals(item.id)) {
                cartBooks.get(i).quantity++;
                isChanged = true;
                break;
            }
        }
        if (!isChanged) {
            item.quantity = 1;
            item.isChecked = true;
            cartBooks.add(item);
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