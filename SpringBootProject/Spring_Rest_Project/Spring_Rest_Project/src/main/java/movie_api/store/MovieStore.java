package movie_api.store;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

import example.spring.rest.Person;
import movie_api.entity.Movie;

public class MovieStore {
//this class maintains data about movies
	private static Map<Integer, Movie> allMovies;
	
	static {
		//initializing this map
		
		allMovies = new HashMap<>();
		Movie m1 = new Movie(101, "Mr India","Fantasy", 1988);
		Movie m2 = new Movie(102, "Titanic","Thriller", 1992);
		Movie m3 = new Movie(103, "Commando","Action", 1997);
		Movie m4 = new Movie(104, "Vivah","Romantic", 2006);
		Movie m5 = new Movie(105, "Dhamal","Comedy", 2015);
		
		allMovies.put(m1.getMovieId(), m1);
		allMovies.put(m2.getMovieId(), m2);
		allMovies.put(m3.getMovieId(), m3);
		allMovies.put(m4.getMovieId(), m4);
		allMovies.put(m5.getMovieId(), m5);
		
	}
	
	//@RequestMapping("/all-movies")
	public static Collection<Movie> getAllMovies() {
		Collection<Movie> allAvailableMovies = allMovies.values();
		return allAvailableMovies;
		
	}
	
	public static Movie getOneMovies(Integer id) {
		Movie foundMovie = allMovies.get(id);
		return foundMovie ;
		
	}
	public static void addNewMovie(Movie movieRef) {
		allMovies.put(movieRef.getMovieId(), movieRef);
    }
}
