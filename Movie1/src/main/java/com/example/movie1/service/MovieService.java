package com.example.movie1.service;

import com.example.movie1.model.Movie;
import com.example.movie1.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    protected final MovieRepository movieRepository;


    public List<Movie> getmovie() {
        return movieRepository.findAll();
    }

    public void addMoive(Movie movie) {
        movieRepository.save(movie);
    }

    public void updateMovie(Movie movie, Integer id) {
        Movie oldMovie=movieRepository.findById(id).get();
        oldMovie.setName(movie.getName());
        oldMovie.setGenre(movie.getGenre());
        oldMovie.setDuration(movie.getDuration());
        movieRepository.save(movie);

    }

    public void delateMovie(Integer id) {
        movieRepository.deleteById(id);

    }
}
