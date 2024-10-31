package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovieServiceShould {

    private MovieService movieService;

    @BeforeEach
    void setUp() {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION,"Arnie"),
                        new Movie(2, "Memento", 113, Genre.THRILLER,"Jesus"),
                        new Movie(3, "There's Something About Marty", 119, Genre.COMEDY,"Gino"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER,"Jose"),
                        new Movie(5, "Scream", 111, Genre.HORROR,"Armando"),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY,"Nose"),
                        new Movie(7, "Matrix", 136, Genre.ACTION,"Watafak"),
                        new Movie(8,"Superman",120,Genre.ACTION,"QueHay")
                )
        );
        movieService = new MovieService(movieRepository);
    }

    @Test
    void return_movies_by_genre() {


        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        List<Integer> moviesIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());

        assertThat(moviesIds, CoreMatchers.is(Arrays.asList(3,6)));
    }

    @Test
    void return_movies_by_length() {

        Collection<Movie> movies = movieService.findMovieByLength(119);

        List<Integer> moviesIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());

        assertThat(moviesIds, CoreMatchers.is(Arrays.asList(2,3,4,5,6)));

    }

    @Test
    void return_movies_by_name() {
        Collection<Movie> movies = movieService.findByName("super");

        List<String> moviesNames = movies.stream().map(movie -> movie.getName()).collect(Collectors.toList());

        assertThat(moviesNames,CoreMatchers.is(Arrays.asList("Super 8","Superman")));


    }

    @Test
    void return_movies_by_directorName() {
        Collection<Movie>movies = movieService.findByDirector("arnie");

        List<String> directorNames = movies.stream().map(movie -> movie.getDirector()).collect(Collectors.toList());

        assertThat(directorNames,CoreMatchers.is(Arrays.asList("Arnie")));

    }

    @Test
    void return_movies_by_template_if_is_empty() {
        Movie emptyTemplate = new Movie(null, null, null, null, null); // O un constructor que acepte nulls
        
        Collection<Movie> movies = movieService.findMoviesByTemplate(emptyTemplate);

        assertThat(movies,CoreMatchers.is(new ArrayList<>()));

    }

    /*
    Error

    @Test
    void return_movies_by_name_and_duration() {
        Movie template = new Movie("Memento",113,null);

        Collection<Movie> movies = movieService.findMoviesByTemplate(template);

        assertThat(movies,CoreMatchers.is(new Movie(2,"Memento",113,null)));

     */

}