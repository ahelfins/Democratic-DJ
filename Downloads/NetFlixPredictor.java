import java.util.ArrayList;


public class NetFlixPredictor {


	// Add fields to represent your database.


	
	/**
	 * 
	 * Use the file names to read all data into some local structures. If any other database files are used,
	 * make sure they are stored in your Eclipse project and hardcode their location.
	 * 
	 * @param ratingsFilename The filename of the ratings database.
	 * @param usersFilename The filename of the users database.
	 * @param moviesFilename The filename of the movies database.
	 */
	public NetFlixPredictor(String ratingsFilename, String usersFilename, String moviesFilename) {
		
	}
	

	/**
	 * Returns an array of objects representing movie data.
	 * 
	 * @return An array of objects representing individual movies.
	 */
	public Object[] getMovieData() {
		return null;
	}
	

	/**
	 * Returns an array of objects representing user data.
	 * 
	 * @return An array of objects representing individual users.
	 */
	public Object[] getUserData() {
		return null;
	}

	
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, return -1.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or -1 if the user does not exist in the database, the movie does not exist, or the movie has not been rated by this user.
	 */
	public double getRating(long userID, long movieID) {

		return -1;
	}
	
	/**
	 * If userNumber has rated movieNumber, return the rating. Otherwise, use other available data to guess what this user would rate the movie.
	 * 
	 * @param userNumber The ID of the user.
	 * @param movieNumber The ID of the movie.
	 * @return The rating that userNumber gave movieNumber, or the best guess if the movie has not been rated by this user.
	 * @pre A user with id userID and a movie with id movieID exist in the database.
	 */
	public double guessRating(long userID, long movieID) {

		return 0;
	}
	
}
