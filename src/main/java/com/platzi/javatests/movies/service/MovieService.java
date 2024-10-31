package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        Collection<Movie> allMovies = movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());

        return allMovies;
    }

    public Collection<Movie> findMovieByLength(int length) {
        Collection<Movie> allMovies = movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());

        return allMovies;
    }
    public Collection<Movie> findByName(String name){
        Collection<Movie> allMovies = (Collection<Movie>) movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase())).toList();

        return allMovies;
    }
    public Collection<Movie> findByDirector(String name){
        Collection<Movie> allMovies = movieRepository.findAll().stream()
                .filter(movie -> movie.getDirector().toLowerCase().contains(name.toLowerCase())).toList();
        return allMovies;
    }

    public Collection<Movie> findMoviesByTemplate(Movie template) {
        if (template == null ||
                (template.getMinutes() == null && template.getName() == null && template.getGenre() == null)) {
            return new ArrayList<>();
        }
           /*
        if(template.getName() != null && template.getMinutes() != null){
            List<Movie> collect = movieRepository.findAll().stream().filter(movie -> template.getName().equals(movie.getName())
                    && template.getMinutes().equals(movie.getMinutes())).collect(Collectors.toList());
            return collect;

            */

        // Lógica de búsqueda
        return new ArrayList<>();

    }


}
