package com.mycompany.movieticketbooking;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Movieticketbooking {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Movie[] movies = {
            new Movie("Spongebob", "Horror", "67.00", "6h 7m"),
            new Movie("Dead Poet Society", "Drama", "10.67", "7h 6m"),
            new Movie("Little Women", "Period Drama", "15.76", "67m")
        };

        while (true) {

            System.out.println("\n  MOVIE TICKETING SYSTEM  ");

            for (int i = 0; i < movies.length; i++) {
                movies[i].show(i + 1);
            }

            System.out.println("0. Exit");
            System.out.print("Select a Movie (or 0 to exit): ");

            int movieChoice;

            try {
                movieChoice = input.nextInt();

            } catch (InputMismatchException e) {

                System.out.println("ERROR: Please enter a number.");
                input.nextLine();
                continue;
            }

            if (movieChoice == 0) {
                break;
            }

            if (movieChoice >= 1 && movieChoice <= movies.length) {

                Movie selected = movies[movieChoice - 1];

                System.out.println(
                    "\nAction for " + selected.title + ":"
                );

                System.out.println("1. Book Tickets");
                System.out.println("2. Cancel Tickets");
                System.out.print("Choice: ");

                int action;

                try {
                    action = input.nextInt();

                } catch (InputMismatchException e) {

                    System.out.println(
                        "ERROR: Please enter a valid action number."
                    );

                    input.nextLine();
                    continue;
                }

                System.out.print("How many tickets? ");

                int qty;

                try {
                    qty = input.nextInt();

                } catch (InputMismatchException e) {

                    System.out.println(
                        "ERROR: Ticket count must be a number."
                    );

                    input.nextLine();
                    continue;
                }

                if (action == 1) {

                    selected.book(qty);

                } else if (action == 2) {

                    selected.cancel(qty);

                } else {

                    System.out.println("Invalid Action.");
                }

            } else {

                System.out.println("Invalid Movie Selection.");
            }
        }

        System.out.println("Program closed.");

        input.close();
    }
}