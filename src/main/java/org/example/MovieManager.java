package org.example;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieManager {
    private TMDbApiCliente apiClient;
    private Map<Integer, TMDbData.Genre> genreMap;

    public MovieManager() throws IOException {
        apiClient = new TMDbApiCliente();
        genreMap = apiClient.fetchMovieGenres().stream()
                .collect(Collectors.toMap(TMDbData.Genre::getId, genre -> genre));
    }

    public void printTopRatedMovies() throws IOException {
        List<TMDbData.Movie> recommendations = apiClient.fetchPopularMovies(18);
        List<TMDbData.Movie> topRated = recommendations.stream()
                .filter(movie -> movie.getVote_average() < 7.0)
                .sorted(Comparator.comparing(TMDbData.Movie::getVote_average).reversed())
                .collect(Collectors.toList());

        topRated.forEach(movie -> {
            List<TMDbData.Genre> genres = movie.getGenre_ids().stream()
                    .map(genreMap::get)
                    .collect(Collectors.toList());
            List<String> genreNames = genres.stream()
                    .map(TMDbData.Genre::getName)
                    .collect(Collectors.toList());
            System.out.println("Título: " + movie.getTitle());
            System.out.println("Géneros: " + genreNames);
            System.out.println("Calificación: " + movie.getVote_average());
            System.out.println("Resumen: " + movie.getOverview());
            System.out.println("------------------------");
        });
    }

    public void printTopReviews() throws IOException {
        List<TMDbData.Review> reviews = apiClient.fetchMovieReviews(18);
        List<TMDbData.Review> topReviews = reviews.stream()
                .filter(review -> review.getAuthor() != null)
                .sorted(Comparator.comparing(TMDbData.Review::getAuthor).reversed())
                .collect(Collectors.toList());
        for (TMDbData.Review review : topReviews) {
            System.out.println("Autor: " + review.getAuthor());
            System.out.println("Contenido: " + review.getContent());
            System.out.println("------------------------");
        }
    }

    public void printPopularMovies() throws IOException {
        List<TMDbData.PopularMovie> popularMovies = apiClient.fetchPopularMovies();
        for (TMDbData.PopularMovie popularMovie : popularMovies) {
            System.out.println("Título: " + popularMovie.getTitle());
            System.out.println("Calificación: " + popularMovie.getVote_average()*10 + "%");
            System.out.println("Resumen: " + popularMovie.getOverview());
            System.out.println("------------------------");
        }
    }

    public void printPreferredMovies(String sort_by,int year) throws IOException {
        List<TMDbData.Movie> preferMovie = apiClient.fetchMoviePrefer(returnSortByType(sort_by),year);
        for (TMDbData.Movie movie : preferMovie) {
            System.out.println("Título: " + movie.getTitle());
            System.out.println("Calificación: " + movie.getVote_average()*10 + "%");
            System.out.println("Resumen: " + movie.getOverview());
            System.out.println("------------------------");
        }
    }
    public String returnSortByType(String sort){
        if (sort.equals("1"))
            return "popularity.desc";
        return "popularity.asc";
    }
}
