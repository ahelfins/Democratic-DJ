
public class Main {
	public static void main(String[] args){
		Life game = new Life("life100.txt");
		//System.out.println(game);
		game.step(5);
		System.out.println(game);
	}
}
