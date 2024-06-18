package entertainment.bean;

public class MovieData {
	private String moviTitle;
	private int movieYear;
	
	public MovieData() {
		
	}

	public MovieData(String moviTitle, int movieYear) {
		super();
		this.moviTitle = moviTitle;
		this.movieYear = movieYear;
	}

	public String getMoviTitle() {
		return moviTitle;
	}

	public void setMoviTitle(String moviTitle) {
		this.moviTitle = moviTitle;
	}

	public int getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}

	@Override
	public String toString() {
		return "MovieData [moviTitle=" + moviTitle + ", movieYear=" + movieYear + "]";
	}

}
