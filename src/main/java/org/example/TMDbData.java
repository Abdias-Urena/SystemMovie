package org.example;

import java.util.List;

public class TMDbData {
    public static class Movie {
        String title;
        List<Integer> genre_ids;
        double vote_average;
        String overview;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }


        public double getVote_average() {
            return vote_average;
        }

        public void setVote_average(double vote_average) {
            this.vote_average = vote_average;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }
    }

    public static class Genre {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Review {

        private String author;
        private String content;


        public String getAuthor() {
            return author;
        }

        public String getContent() {
            return content;
        }

        @Override
        public String toString() {
            return "Review{" +
                    "author='" + author + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }

    public static class PopularMovie{
        private String title;
        private String overview;

        private double vote_average;

        public String getTitle() {
            return title;
        }

        public String getOverview() {
            return overview;
        }

        public double getVote_average() {
            return vote_average;
        }
    }



    public static class PopularMovieResponse{
        private List<PopularMovie> results;

        public List<PopularMovie> getResults() {
            return results;
        }
    }


    public static class MovieResponse {
        private List<Movie> results;

        public List<Movie> getResults() {
            return results;
        }
    }

    public static class GenreResponse {
        private List<Genre> genres;

        public List<Genre> getGenres() {
            return genres;
        }
    }

    public static class ReviewResponse {
        private List<Review> results;

        public List<Review> getResults() {
            return results;
        }
    }
}
