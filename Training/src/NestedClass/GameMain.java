package NestedClass;

import java.util.HashMap;
import java.util.Scanner;

class Game{
	int id=1;
	String  gameName;
	public Game(String name) {
		gameName = name;
	}
	class Player{
		int id,score;
		String name;
		
		public Player(int id,String name, int score) {
			this.id = id;
			this.name = name;
			this.score = score;
		}
		
		public int getScore() {
			return score;
		}
	}
	HashMap<Integer,Player> players = new HashMap<>();
	
	public void createplayer(String name, int score) throws Exception {
		players.put(id,new Player(id,name,score));
		id++;
		displayPlayer(id-1);
	}
	
	public void displayPlayer(int id) throws Exception {
		if(players.containsKey(id)){
			Player player = players.get(id);
			System.out.println("Player id : "+player.id);
			System.out.println("Player name : "+player.name);
			System.out.println("Player Score : "+player.score);
		}else {
			throw new Exception("Player not found!");
		}
		
	}
	
	public void displayAllPlayers() throws Exception {
		if(players.isEmpty()) {
			throw new Exception("No Users Found!");
		}else {
			for(int id : players.keySet()) {
				displayPlayer(id);
			}
		}
		
		
	}
	
	public void highScore() throws Exception {
		int highScore = 0;
		Player player = null;
		for(int i : players.keySet()) {
			player = players.get(i);
			if(player.getScore() > highScore) {
				highScore = player.getScore();
			}
		}
		displayPlayer(player.id);
	}
}
public class GameMain {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Game name : ");
		String gameName = in.nextLine();
		Game game = new Game(gameName);
		while(true) {
			System.out.println("1.Create Player\n2.Display Player by Id"
					+ "\n3.Display All players\n4.Check High Score\n5.Exit");
			System.out.println("Enter the opertaion : ");
			int choice = in.nextInt();
			in.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter Player name : ");
				String name = in.nextLine();
				System.out.println("Enter Player Score : ");
				int score = in.nextInt();
				try {
					game.createplayer(name, score);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println("Player created Successfully!");
				break;
			case 2:
				System.out.println("Enter the PLayer id : ");
				int id = in.nextInt();
				try {
					game.displayPlayer(id);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					game.displayAllPlayers();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					game.highScore();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println("Exiting!");
				return;
			default:
				System.out.println("Enter a valid operation!");
				
				
			}
		}

	}

}
