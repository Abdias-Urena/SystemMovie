package org.example;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;


public class TMDbApiCliente {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    public List<TMDbData.Movie> fetchPopularMovies(int movieId) throws IOException {
        String url = BASE_URL + "movie/" + movieId + "/recommendations?language=es-ES&page=1";
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMmFhOTI3ODVjNGY3MGY2N2I0ZTE0NzgwYWFkNzJkYyIsInN1YiI6IjY1NGFhZWI3NmJlYWVhMDBjOWZlMTVlMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gNT8cJZD_TzdCVusBGaly9itlispa6df5Gnb-hWr8Pw")
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            TMDbData.MovieResponse movieResponse = gson.fromJson(response.body().string(), TMDbData.MovieResponse.class);
            return movieResponse.getResults();
        }
    }

    public List<TMDbData.Genre> fetchMovieGenres() throws IOException {
        String url = BASE_URL + "genre/movie/list?language=es";
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMmFhOTI3ODVjNGY3MGY2N2I0ZTE0NzgwYWFkNzJkYyIsInN1YiI6IjY1NGFhZWI3NmJlYWVhMDBjOWZlMTVlMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gNT8cJZD_TzdCVusBGaly9itlispa6df5Gnb-hWr8Pw")
                .build();

        try (Response response = client.newCall(request).execute()) {
                assert response.body() != null;
                TMDbData.GenreResponse genreResponse = gson.fromJson(response.body().string(), TMDbData.GenreResponse.class);
                return genreResponse.getGenres();
        }
    }

    public List<TMDbData.Review> fetchMovieReviews(int movieId) throws IOException {
        String url = BASE_URL + "movie/" + movieId + "/reviews?language=en-US&page=1";
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMmFhOTI3ODVjNGY3MGY2N2I0ZTE0NzgwYWFkNzJkYyIsInN1YiI6IjY1NGFhZWI3NmJlYWVhMDBjOWZlMTVlMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gNT8cJZD_TzdCVusBGaly9itlispa6df5Gnb-hWr8Pw")
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            TMDbData.ReviewResponse reviewResponse = gson.fromJson(response.body().string(), TMDbData.ReviewResponse.class);
            return reviewResponse.getResults();
        }
    }

    public List<TMDbData.PopularMovie> fetchPopularMovies() throws IOException {
        String url = BASE_URL + "movie/popular?language=es-ES&page=1";
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMmFhOTI3ODVjNGY3MGY2N2I0ZTE0NzgwYWFkNzJkYyIsInN1YiI6IjY1NGFhZWI3NmJlYWVhMDBjOWZlMTVlMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gNT8cJZD_TzdCVusBGaly9itlispa6df5Gnb-hWr8Pw")
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            TMDbData.PopularMovieResponse popularMovieResponse = gson.fromJson(response.body().string(), TMDbData.PopularMovieResponse.class);
            return popularMovieResponse.getResults();
        }
    }

    public List<TMDbData.Movie> fetchMoviePrefer(String sort_by,int year) throws IOException{
        String url = BASE_URL + "discover/movie?include_adult=false&include_video=false&language=es-ES&page=1&sort_by="+sort_by+"&year="+year;
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzMmFhOTI3ODVjNGY3MGY2N2I0ZTE0NzgwYWFkNzJkYyIsInN1YiI6IjY1NGFhZWI3NmJlYWVhMDBjOWZlMTVlMiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gNT8cJZD_TzdCVusBGaly9itlispa6df5Gnb-hWr8Pw")
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            TMDbData.MovieResponse movieResponse = gson.fromJson(response.body().string(), TMDbData.MovieResponse.class);
            return movieResponse.getResults();
        }
    }



}
