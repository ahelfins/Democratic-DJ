import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		FileIO reader = new FileIO();
		String fileSep = System.getProperty("file.separator");
		ArrayList<String> fileData1 = reader.readFile("data" + fileSep + "u.user");
		ArrayList<String> fileData2 = reader.readFile("data" + fileSep + "u.item");
		ArrayList<String> fileData3 = reader.readFile("data" + fileSep + "u.data");
		
		
		ArrayList<User> userDatabase = new ArrayList<User>();
		ArrayList<Movie> movieDatabase = new ArrayList<Movie>();
		ArrayList<Rating> ratingDatabase = new ArrayList<Rating>();
		
		
		for (String s : fileData1) {
			User newUser = MovieLens100kTranslator.lineToUser(s);
			userDatabase.add(newUser);
		}
		for (String s : fileData2) {
			Movie newMovie = MovieLens100kTranslator.lineToMovie(s);
			movieDatabase.add(newMovie);
		}
		for (String s : fileData3) {
			Rating newRating = MovieLens100kTranslator.lineToRating(s);
			ratingDatabase.add(newRating);
		}
		
		
		for (User u : userDatabase) {
			System.out.println(u);
		}
		for (Movie u : movieDatabase) {
			System.out.println(u);
		}
		for (Rating u : ratingDatabase) {
			System.out.println(u);
		}

	}

}
