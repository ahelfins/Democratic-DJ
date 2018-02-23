import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;

/*

	Represents a Game Of Life grid.

	Coded by: Ashley Helfinstein
	Modified on: 1/26/16

*/

public class Life {

	private static final int rows = 20;
	private static final int cols = 20;
	
	private boolean[][] grid;

	// Constructs an empty grid
	public Life() {
		grid=new boolean[rows][cols];
	}

	// Constructs the grid defined in the file specified
	public Life(String filename) {
		grid=readData(filename);
	}

	// Runs a single turn of the Game Of Life
	public void step() {
		int[][] counts=new int[grid.length][grid[0].length];
		for(int i=0; i<counts.length; i++)
			for(int j=0; j<counts[0].length; j++)
				counts[i][j]=countNeighbors(i,j);
		
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(counts[i][j]<=1||counts[i][j]>=4)
					grid[i][j]=false;
				else if(counts[i][j]==3)
						grid[i][j]=true;
			}
		}
	}

	private int countNeighbors(int i, int j){
		int count=0;
		int startX=-1;
		int startY=-1;
		int endX=1;
		int endY=1;
		if(j==0)
			startY++;
		if(i==0)
			startX++;
		if(j==grid.length-1)
			endY--;
		if(i==grid[0].length-1)
			endX--;
		for(int y=startY; y<=endY; y++){
			for(int x=startX; x<=endX; x++){
				if(grid[i+x][j+y])
					count++;
			}
		}
		if(grid[i][j])
			count--;
		return count;
	}
	
	// Runs n turns of the Game Of Life
	public void step(int n) {
		for(int i=0; i<n; i++)
			step();
	}
	
	public void draw(PApplet marker, int x, int y, int width){
		
	}

	// Formats this Life grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String result="";
		for(int j=0; j<grid.length; j++){
			for(int i=0; i<grid[0].length; i++){
				if(grid[i][j])
					result+="*";
				else
					result+=" ";
			}
			result+="\n";
		}
		return result;
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