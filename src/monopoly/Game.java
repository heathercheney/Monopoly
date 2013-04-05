package monopoly;
import java.util.*;

public class Game {
	ArrayList<Player> players; 
	Board board; 
	
	public Game(){
		players = new ArrayList<Player>();
		board = new Board();
	}
	
	public void takeTurn(){
		for(Player player : players){
			SpaceInterface space;
			player.roll();
			for(int index : player.move()){
				space = board.getSpace(index);
				space.passOverAction(player);
			}
			space = board.getSpace(player.getPosition());
			space.landOnAction(player);
			player.playerChanged();
		}
	}
	
	public void addPlayer(Player p){
		players.add(p);
	}
	

	public static void main(String[] args) {
		Game game = new Game();
		PlayerDisplay display = new PlayerDisplay();
		
		
		game.addPlayer(new Player("Tom", display));
		game.addPlayer(new Player("Ally", display));
		game.addPlayer(new Player("Paul", display));
		game.addPlayer(new Player("Amy", display));
		
		for(int i = 0; i < 10; i++){
			game.takeTurn();
			System.out.println();
		}
	}

}
