package it.uniroma3.siw.repository;

import it.uniroma3.siw.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {

    //Uso una certa sintassi per fare in modo che le query vengano automaticamente costruite. Nessuno mi vieta di costruirne altre con jpql

    List<Movie> findByYear(Integer year);

    boolean existsByTitleAndYear(String title, Integer year);


    //Oltre a questi metodi che sono stati creati, ho tutti i metodi offerti da CRUD Repository, banalmente sono le operazioni CRUD
}
