package smash;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.*;


class Shutdown extends Thread {
	
}


public class Smash {
	
	
	public static void RandomPicker(int num) {
		int players = num;
		String[] fighters =
			{ "Mario", "DK", "Link", "Samus/Dark Samus", "Yoshi", "Kirby", "Fox", "Pikachu", "Luigi",
			  "Ness", "Captain Falcon", "Jigglypuff", "Peach/Daisy", "Bowser", "Zelda",
			  "Dr. Mario", "Falco", "Marth", "Lucina", "Young Link", "Ganondorf",
			  "Mewtwo", "Roy", "Chrom", "Mr. Game & Watch", "Meta Knight", "Pit/Dark Pit",
			  "Zero Suit Samus", "Wario", "Snake", "Ike", "Pokemon Trainer", "Diddy Kong",
			  "Lucas", "King Dedede", "Alph", "Lucario", "R.O.B.", "Toon Link", "Wolf", "Villager",
			  "Mega Man", "Wii Fit Trainer", "Little Mac", "Greninja", "Palutena", "Pac-Man",
			  "Robin", "Shulk", "Bowser Jr.", "Ryu", "Ken", "Cloud", "Corrin", "Bayonetta",
			  "Inkling", "Ridley", "Simon/Richter", "King K. Rool", "Isabelle", "Incineroar",
			  "Piranha Plant", "Joker", "Hero", "Banjo & Kazooie", "Terry", "Byleth", "Steve",
			  "Pyra/Mythra", "Mii Brawler (Chose Any)", "Mii Swordfighter (Chose Any)", "Mii Gunner (Chose Any)",
			};
		Random random = new Random();
		for(int i = 1; i <= players; i++) {
			int currentRand = random.nextInt(72);
			System.out.println("Player " + i + ": " + fighters[currentRand]);
		}
	}
	
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
	public static void main(String[] args) throws IOException{
//		BufferedReader inVictory = new BufferedReader(new FileReader("VictoryLog.txt"));
//		PrintWriter outVictory = new PrintWriter("VictoryLog.txt");
		
	    Scanner scan = new Scanner(System.in);
		boolean random;
		boolean database;
		boolean player;
		boolean fighter;
		boolean program = true;
		
		List<List<Object>> Players = new ArrayList<>();
		Scanner inPlayer = new Scanner(new File("PlayerLog.txt"));
		while(inPlayer.hasNext()) {
			String name;
			int wins, losses, played;
			name = inPlayer.next();
			wins = inPlayer.nextInt();
			losses = inPlayer.nextInt();
			played = inPlayer.nextInt();
			List<Object> p = new ArrayList<>(Arrays.asList(name, wins, losses, played));
			Players.add(p);
		}
		inPlayer.close();
		System.out.println(Players);

		
		List<List<Object>> Fighters = new ArrayList<>();
		Scanner inFighter = new Scanner(new File("VictoryLog.txt"));
		inFighter.useDelimiter("\n");
		while(inFighter.hasNextLine()) {
			String fighterStats = inFighter.next();
			String[] str = fighterStats.split("~~");
			String name = str[0];
			int wins = Integer.valueOf(str[1]);
			List<Object> f = new ArrayList<>(Arrays.asList(name, wins));
			Fighters.add(f);
		}
		inFighter.close();
		System.out.println(Fighters);

		while(program) {
			int main_decision = 0;
			System.out.println("========================================");
			System.out.println("	SMASH HOME MENU\n");
			System.out.println("1. For Random Fighter Program, Enter '1'");
			System.out.println("2. For Smokin' Oak Database, Enter '2'");
			System.out.println("3. For Program Termination, Enter '3'\n");
			System.out.println("========================================\n");

			System.out.println("What would you like to do?");
			try {
				main_decision = scan.nextInt();
			}
			catch(Exception e){
				scan.next();
			}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
	
			//RANDOM PICKER BELOW
			
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			
			if(main_decision == 1) {
				random = true;
				System.out.println("========================================");
				System.out.println("ENHANCED SMASH RANDOM CHARACTER PICKER\n");
				System.out.println("- - - - - - - - - - - - - - - - - - - -");
				System.out.println("Notable Changes: \n");
				System.out.println(" 1. Mii Brawler/Swordfighter/Gunner included\n 2. Duplicate charaters are possible\n 3. Echo fighters have been grouped together\n");
				System.out.println("- - - - - - - - - - - - - - - - - - - -\n");
				System.out.println("Characters not included for everyone's convenience: \n");
				System.out.println(" 1. Olimar\n 2. Min Min\n 3. Sonic\n 4. Sepheroth\n 5. Ice Climbers\n 6. Duck Hunt\n 7. Rosalina & Luma\n");
				System.out.println("========================================\n");
				
				while(random) {
					System.out.println("How many players?");
					while(!scan.hasNextInt()) {
						System.out.println("Not an integer.\nHow many Players?");
						scan.next();
					}
					int players = scan.nextInt();
					RandomPicker(players);
					System.out.println("Finished?(Type 'y' if so. Otherwise type anything)");
					while(scan.hasNext("y")) {
						random = false;
						break;
					}
					scan.next();
				}
			}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	

			//DATABASES BELOW
			
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			else if(main_decision == 2) {
				database = true;
				//##################################################################################################################
				while(database == true) {
					int database_decision = 0;
					System.out.println("================================================================================");
					System.out.println("Welcome to the Smokin' Oak Smash Database. Please choose an option below\n");
					System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
					System.out.println("1. To enter the Smokin' Oak Player Specific Database, Enter '1'");
					System.out.println("2. To enter to Fighter Specific Database, Enter '2'");
					System.out.println("3. To return to the Main Menu, Enter '3'");
					System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
					System.out.println("================================================================================");

					System.out.println("What would you like to do?");
					try {
						database_decision = scan.nextInt();
					}
					catch(Exception e){
						scan.next();
					}
				//##################################################################################################################

					//PLAYER DATABASE BELOW
					
					//---------------------------------------------------------------------------------------------------
					if(database_decision == 1) {
						player = true;
						while(true) {
							int player_decision = 0;
							System.out.println("==========================================================================================");
							System.out.println("Welcome to the Smokin' Oak Player Specific Database. Please choose an option below\n");
							System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
							System.out.println("1. To Create a New Player Account, Enter '1'");
							System.out.println("2. To View a Single Player Account, Enter '2'");
							System.out.println("3. To View Broad Data on All Existing Players, Enter '3'");
							System.out.println("4. To return to the Previous Menu, Enter '4'");
							System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
							System.out.println("==========================================================================================");
							
							System.out.println("What would you like to do?");
							try {
								player_decision = scan.nextInt();
							}
							catch(Exception e){
								scan.next();
							}
							
							if(player_decision == 1) {
								System.out.print("Enter a Name for this Profile\n-> ");
								String newPlayer = scan.next();
								List<Object> newAccount = new ArrayList<>(Arrays.asList(newPlayer, 0, 0, 0));
								Players.add(newAccount);
							}
							else if(player_decision == 2) {
								boolean found = false;
								System.out.println("Enter the Name of an Existing Player Profile\n->");
								String playerProfile = scan.next();
								for(int i = 0; i < Players.size(); i++) {
									List<Object> currentList = Players.get(i);
									if(currentList.get(0).equals(playerProfile)) {
										found = true;
										System.out.println("============================");
										System.out.println("Profile Name --> " + currentList.get(0));
										System.out.println("============================\n");
										System.out.println("------------------------------");
										System.out.println(currentList.get(1) + " <-- Total Wins");
										System.out.println(currentList.get(2) + " <-- Total Losses");
										System.out.println(currentList.get(3) + " <-- Total Games Played");
										System.out.println("------------------------------");
									}	
								}
								if(found == false) {
									System.out.println("PROFILE NAME DOES NOT EXIST; RESETTING TO PREVIOUS MENU");
								}
							}
							else if(player_decision == 3) {
								
							}
							else if(player_decision == 4) {
								System.out.println("Returning to Previous Menu");
								player = false;
								break;
							}
							else {
								System.out.println("INVALID INPUT; RESETING CURRENT MENU");
							}
						}
					}
					//---------------------------------------------------------------------------------------------------

					//FIGHTER DATABASE BELOW
					
					//---------------------------------------------------------------------------------------------------
					else if(database_decision == 2) {
						while(true) {
							System.out.println("==========================================================================================");
							System.out.println("Welcome to the Fighter Specific Database. Please choose an option below\n");
							System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
							System.out.println("1. To View Broad Data on All Current Fighters, Enter '1'");
							System.out.println("2. To return to the Previous Menu, Enter '2'");
							System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
							System.out.println("==========================================================================================");
						}
					}
					//---------------------------------------------------------------------------------------------------

					//---------------------------------------------------------------------------------------------------
					else if(database_decision == 3) {
						System.out.println("Returning to Previous Menu");
						database = false;
						break;
					}
					//---------------------------------------------------------------------------------------------------
					else {
						System.out.println("INVALID INPUT; RESETING CURRENT MENU");
					}
				}
			}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	

			//PROGRAM TERMINATION
			
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			else if(main_decision == 3) {
			    BufferedWriter outPlayer = new BufferedWriter(new FileWriter("PlayerLog.txt", false));
			    for(int i = 0; i < Players.size(); i++) {
			    	List<Object> currentList= Players.get(i);
			    	outPlayer.write(currentList.get(0) + " " + currentList.get(1) + " " + currentList.get(2) + " " + currentList.get(3) + "\n");
			    }
			    outPlayer.close();
				System.out.println("Program Terminated");
				scan.close();
				return;
			}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
			else {
				System.out.println("INVALID INPUT; RESETING CURRENT MENU");
			}
		}
		scan.close();
		Shutdown shutdown = new Shutdown();
	}
}
		
