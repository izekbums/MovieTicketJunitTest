package com.mycompany.movieticketbooking;

import java.math.BigDecimal;

class Movie {

    String title;
    String genre;
    BigDecimal price;
    int seats = 67;
    String duration;

    public Movie(String title, String genre, String price, String duration) {

        try {
            this.price = new BigDecimal(price);
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Invalid price format. Setting price to 0.");
            this.price = BigDecimal.ZERO;
        }

        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public void show(int id) {
        System.out.println(
            id + ". " +
            title + " | " +
            genre + " | $" +
            price + " | Seats: " +
            seats + " | " +
            duration
        );
    }

    public void book(int count) {

        if (count > 0 && count <= seats) {

            seats -= count;

            BigDecimal total =
                price.multiply(BigDecimal.valueOf(count));

            System.out.println(
                "\nSUCCESS: Booked " +
                count +
                " tickets. Total: $" +
                total
            );

        } else {
            System.out.println(
                "ERROR: Invalid amount or not enough seats."
            );
        }
    }

    public void cancel(int count) {

        if (count > 0) {

            seats += count;

            System.out.println(
                "SUCCESS: Cancelled " +
                count +
                " tickets for " +
                title
            );

        } else {
            System.out.println("ERROR: Invalid amount.");
        }
    }
}