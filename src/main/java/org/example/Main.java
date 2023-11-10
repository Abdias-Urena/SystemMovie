package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        MovieManager movieManager = new MovieManager();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Print top rated movies");
            System.out.println("2. Print top reviews");
            System.out.println("3. Print popular movies");
            System.out.println("4. Print preferred movies 1by year");
            System.out.println("5. Exit");

            String option = reader.readLine();
            switch (option) {
                case "1":
                    movieManager.printTopRatedMovies();
                    break;
                case "2":
                    movieManager.printTopReviews();
                    break;
                case "3":
                    movieManager.printPopularMovies();
                    break;
                case "4":
                    System.out.println("Please enter your prefer sort popularity:");
                    System.out.println("1. Descending");
                    System.out.println("2. Ascending");
                    String sortOption = reader.readLine();
                    System.out.println("Please enter your prefer year:");
                    String year = reader.readLine();
                    movieManager.printPreferredMovies(sortOption,Integer.parseInt(year));
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}