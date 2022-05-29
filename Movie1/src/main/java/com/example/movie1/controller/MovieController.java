package com.example.movie1.controller;

import com.example.movie1.model.Movie;
import com.example.movie1.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/movie")
public class MovieController {

    private final MovieService movieService;
    @GetMapping
    public ResponseEntity getmovie(){

        return ResponseEntity.ok().body(movieService.getmovie());
    }
    @PostMapping
    public ResponseEntity addMovie(@RequestBody@Valid Movie movie){

        movieService.addMoive(movie);
        return ResponseEntity.status(200).body(" movie add");
    }

    @PutMapping("{id}")
    public ResponseEntity editeMovie(@RequestBody Movie movie,@PathVariable Integer id){

        movieService.updateMovie(movie,id);
        return ResponseEntity.status(200).body(" movie Update");
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){

        movieService.delateMovie(id);
        return ResponseEntity.status(200).body(" movie add");
    }


}
