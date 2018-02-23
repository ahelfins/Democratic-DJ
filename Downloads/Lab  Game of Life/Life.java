/*

	Represents a Game Of Life grid.

	Coded by:
	Modified on:

*/

public class Life {

	private static final int rows = 20;
	private static final int cols = 20;


	// Constructs an empty grid
	public Life() {
	}

	// Constructs the grid defined in the file specified
	public Life(String filename) {
	}

	// Runs a single turn of the Game Of Life
	public void step() {
	}

	// Runs n turns of the Game Of Life
	public void step(int n) {
	}

	// Formats this Life grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
	}

	public boolean[][] readData (String filename) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			boolean[][] gameData = new boolean[cols][rows];

			int count = 0;

			FileReader reader = null;
			try {
					reader = new FileReader(dataFile);
					Scanner in = new Scanner(reader);


					while (in.hasNext() && count < rows) {
						String line = in.nextLine();
						for(int i = 0; i < line.length(); i++)
							if (line.charAt(i)=='*')
								gameData[i][count] = true;

						count++;
					}

			} catch (IOException ex) {
				System.out.println("File cannot be read.");
				return null;
			} catch (NumberFormatException ex) {
				System.out.println("File is in the wrong format.");
				return null;
			} finally {
				try {
					reader.close();
				} catch (IOException ex) {
					System.out.println("File cannot be closed.");
					return null;
				}
			}
			return gameData;
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
    }

}