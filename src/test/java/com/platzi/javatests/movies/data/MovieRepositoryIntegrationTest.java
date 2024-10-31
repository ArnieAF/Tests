package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepository;
    private DataSource dataSource;

    @BeforeEach
    void setUp() throws SQLException {

        dataSource = new DriverManagerDataSource("jdbc:h2:mem:testdb;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(),new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

         movieRepository = new MovieRepositoryJdbc(jdbcTemplate);

    }

    @Test
    void load_all_movies() throws SQLException {



        Collection<Movie> movies = movieRepository.findAll();

        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION,"Jesus"),
                new Movie(2, "Memento", 113, Genre.THRILLER,"Gino"),
                new Movie(3, "Matrix", 136, Genre.ACTION,"Jose")

        )));
    }

    @Test
    void load_movie_by_id() {

        Movie movie = movieRepository.findById(2);

        assertThat(movie,is(new Movie(2, "Memento", 113, Genre.THRILLER,"Arnie")));

    }

    @Test
    void insert_a_movie() {

        Movie movie = new Movie("Super 8", 112, Genre.THRILLER,"Arnie");

        movieRepository.saveOrUpdate(movie);

        Movie movieFromDB = movieRepository.findById(4);

        assertThat(movieFromDB, is(new Movie(4,"Super 8", 112, Genre.THRILLER ,"Arnie")));

    }

    @AfterEach
    void tearDown() throws SQLException {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}