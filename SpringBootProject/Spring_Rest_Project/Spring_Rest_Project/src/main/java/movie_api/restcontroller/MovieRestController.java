package movie_api.restcontroller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import movie_api.entity.Movie;
import movie_api.service.MovieService;
import movie_api.store.MovieStore;

@RestController
public class MovieRestController {
	@Autowired
	private MovieService movieServiceRef;
	
	//it will make a GET request---movie-api-->Get all movies
	//@RequestMapping("/movie-api")
	@GetMapping("/movie-api")
	public Collection<Movie> getAllMovies(){
		Collection<Movie> allMovies = movieServiceRef.getAllMovies();
		return allMovies;
	}
	
	
	//GET-->One Movie By Id-->/movie-api/101//movieId
	//@RequestMapping("/movie-api/{movieId}") //OR-->@RequestMapping("/movie-api/{id}")
	@GetMapping("/movie-api/{movieId}")
      public Movie getOneMovie(@PathVariable("movieId") Integer id) {
		//OR
	//public Movie getOneMovie(@PathVariable Integer id) {
		Movie foundMovie = movieServiceRef.getOneMovie(id);
		return foundMovie;
	}
	
	
	//POST-->/movie-api
	//@RequestMapping(value = "/movie-api",method = RequestMethod.POST) Or
	@PostMapping("/movie-api")
	public void addNewMovie(@RequestBody Movie movieRef) {
		System.out.println("Accepted movie: " + movieRef);
		movieServiceRef.addNewMovie(movieRef);
	}
}
