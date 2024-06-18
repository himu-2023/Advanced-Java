package movie_api.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import movie_api.entity.Movie;
//@Repository //-->no need to this annotation bcz JpaRepository is a managed component
public interface MovieRepo  extends JpaRepository<Movie, Integer>{
//		no further code for persistancy.It is managed internally. however,if any further
//	    customization is required,that can be done

}
