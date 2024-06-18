package movie_api.restcontroller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import movie_api.entity.Movie;
import movie_api.exception.MovieNotFoundException;
import movie_api.service.MovieService;

@RestController
public class MovieRestController {
	@Autowired
	private MovieService movieServiceRef;

	// GET-->/movie-api
	@GetMapping("/movie-api")
	public Collection<Movie> retrieveAll() {
		Collection<Movie> allMovies = movieServiceRef.retrieveAll();
		return allMovies;

	}
	
	@GetMapping("/movie-api/{movieId}")
	public Movie retrieveOne(@PathVariable Integer movieId) {
		Movie foundMovie = movieServiceRef.retrieveOne(movieId);
		//System.out.println(foundMovie);
		/*
		 * If movie is found return that movie
		 * if not found throw MovieNotFoundException(UserDefined Exp)
		 */
		if(foundMovie == null) {
			MovieNotFoundException ex = new MovieNotFoundException("Movie with given id not found",movieId);
		throw ex;
		}
		
		return foundMovie;
	}
	
	//POST-->movie-api
	@PostMapping("/movie-api")
	public void create(@RequestBody Movie movieRef) {
		movieServiceRef.create(movieRef);
		
	}
	//PUT-->movie-api
	@PutMapping("/movie-api")
	public void update(@RequestBody Movie movieRef) {
		movieServiceRef.update(movieRef);
		
	}
	//Delete-->movie-api/{id}
	@DeleteMapping("/movie-api/{movieId}")
	public void delete(@PathVariable Integer movieId) {
		movieServiceRef.deleteOne(movieId);
		
	}

}
