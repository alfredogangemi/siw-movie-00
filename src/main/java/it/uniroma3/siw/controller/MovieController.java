package it.uniroma3.siw.controller;

import it.uniroma3.siw.model.Movie;
import it.uniroma3.siw.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController { //Nella classe controller, creo un metodo per ogni richiesta che devo creare

    @Autowired MovieRepository movieRepository; //Annotazione autowired aggiunge una "dipendenza" alla lasse di reposutory

    @GetMapping("/formNewMovie")
    public String formNewMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "formNewMovie.html";
    }

    @PostMapping("/movies")
    public String newMovie(@ModelAttribute("movie") Movie movie, Model model) {
        if (!movieRepository.existsByTitleAndYear(movie.getTitle(), movie.getYear())) {
            this.movieRepository.save(movie);
            model.addAttribute("movie", movie);
            return "movie.html";
        } else {
            model.addAttribute("messaggioErrore", "Questo film esiste già");
            return "formNewMovie.html";
        }
    }


    @GetMapping("/movies/{id}")
    public String getMovie(@PathVariable("id") Long id, Model model) {
        model.addAttribute("movie", this.movieRepository.findById(id).get());
        return "movie.html";
    }

    @GetMapping("/movies")
    public String showMovies(Model model) {
        model.addAttribute("movies", this.movieRepository.findAll());
        return "movies.html";
    }

    @GetMapping("/formSearchMovies")
    public String formSearchMovies() {
        return "formSearchMovies.html";
    }

    @PostMapping("/searchMovies")
    public String searchMovies(Model model, @RequestParam Integer year) {
        model.addAttribute("movies", this.movieRepository.findByYear(year));
        return "foundMovies.html";
    }
}


