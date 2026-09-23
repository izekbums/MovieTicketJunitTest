package com.mycompany.movieticketbooking;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {

    @Test
    public void testMovieConstructor() {

        Movie movie = new Movie(
            "Spongebob",
            "Horror",
            "67.00",
            "6h 7m"
        );

        assertEquals("Spongebob", movie.title);
        assertEquals("Horror", movie.genre);
        assertEquals(new BigDecimal("67.00"), movie.price);
        assertEquals(67, movie.seats);
        assertEquals("6h 7m", movie.duration);
    }

    @Test
    public void testBookTickets() {

        Movie movie = new Movie(
            "Spongebob",
            "Horror",
            "67.00",
            "6h 7m"
        );

        movie.book(5);

        assertEquals(62, movie.seats);
    }

    @Test
    public void testBookAllTickets() {

        Movie movie = new Movie(
            "Spongebob",
            "Horror",
            "67.00",
            "6h 7m"
        );

        movie.book(67);

        assertEquals(0, movie.seats);
    }

    @Test
    public void testInvalidBooking() {

        Movie movie = new Movie(
            "Spongebob",
            "Horror",
            "67.00",
            "6h 7m"
        );

        movie.book(68);

        assertEquals(67, movie.seats);
    }

    @Test
    public void testZeroBooking() {

        Movie movie = new Movie(
            "Spongebob",
            "Horror",
            "67.00",
            "6h 7m"
        );

        movie.book(0);

        assertEquals(67, movie.seats);
    }

    @Test
    public void testCancelTickets() {

        Movie movie = new Movie(
            "Spongebob",
            "Horror",
            "67.00",
            "6h 7m"
        );

        movie.book(10);
        movie.cancel(5);

        assertEquals(62, movie.seats);
    }

    @Test
    public void testInvalidCancellation() {

        Movie movie = new Movie(
            "Spongebob",
            "Horror",
            "67.00",
            "6h 7m"
        );

        movie.cancel(0);

        assertEquals(67, movie.seats);
    }

    @Test
    public void testInvalidPrice() {

        Movie movie = new Movie(
            "Test Movie",
            "Drama",
            "invalid",
            "2h"
        );

        assertEquals(BigDecimal.ZERO, movie.price);
    }
}