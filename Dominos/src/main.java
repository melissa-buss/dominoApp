import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class main {

	
	
	public main(String[] args) {
		
		/** Creates and prints set.
		 **/
		int size = setSize();
		ArrayList<Domino> dominoSet = createSet(size);
		System.out.println("\nEntire Set: ");
        for (int i = 0; i < dominoSet.size(); i++){
            System.out.println(dominoSet.get(i).displayDomino());
        }
        
        /** Creates and prints player hands. 
         **/               
        int players = numOfPlayers();
        System.out.println(players);
        
        ArrayList<Domino> playerOne = playerHand(5, dominoSet);
        System.out.println("\nPlayer One: ");
        printHand(playerOne);
        
        ArrayList<Domino> playerTwo = playerHand(5, dominoSet);
        System.out.println("\nPlayer Two: ");
        printHand(playerTwo);
        
        if (players > 2) {
        	ArrayList<Domino> playerThree = playerHand(5, dominoSet);
        	System.out.println("\nPlayer Three: ");
        	printHand(playerThree);
        }
        
        if (players > 3) {
        	ArrayList<Domino> playerFour = playerHand(5, dominoSet);
        	System.out.println("\nPlayer Four: ");
        	printHand(playerFour);
        }
    }
	
	/** 
	 * User determines the size of the set of dominos
	 * 
	 * @return The size of the set of dominos
	 */
	public static int setSize() {
		Scanner getSize = new Scanner(System.in);
		int size = 0;
		int temp = 0;
		
		while ((temp != 6) && (temp != 9) && (temp != 12) && (temp != 15)) {
			System.out.println("What size set do you want? \nOptions: 6, 9, 12, or 15: ");
			temp = getSize.nextInt();
		}
		
		size = temp;
        return size;
	}
	
	/**
	 * Creates the complete set of dominos using the user-determined size
	 * 
	 * @param n the size of the set
	 * @return The ArrayList of dominos
	 */
	public static ArrayList<Domino> createSet(int n){
		ArrayList<Domino> completeSet = new ArrayList<>();
        
        for (int i = 0; i <= n; i++){
            for (int j= i; j <= n; j++){
                completeSet.add(new Domino(i, j));
            }
        }
        
        return completeSet;
	}
	
	/** 
	 * User determines the number of players in the game
	 * 	
	 * @return The number of players in the game
	 */
	public static int numOfPlayers() {
		Scanner getPlayers = new Scanner(System.in);
		int players = 0;
		int temp = 0;
		
		while ((temp < 2) || (temp > 4)) {
			System.out.println("How many players? \nBetween 2-4: ");
			temp = getPlayers.nextInt();
		}
		
		players = temp;
        return players;
	}
	
	/** 
	 * Creates a player hand.
	 * 	
	 * @param numInHand The number of dominos the player should draw
	 * @param s The set of dominos that are not yet drawn
	 * @return The player's hand
	 */
	public static ArrayList<Domino> playerHand(int numInHand, ArrayList<Domino> s) {
		ArrayList<Domino> p = new ArrayList<>();
		
        Random rand = new Random();
        int i = 0;
        int randomIndex;
        while (i < numInHand){
            randomIndex = rand.nextInt(s.size());
            p.add(s.get(randomIndex));
            s.remove(randomIndex);
            
            i++;
        }
        
        return p;
	}
	
	/**
	 * Prints the player hand.
	 * 
	 * @param p The players hand
	 */
	public static void printHand(ArrayList<Domino> p) {
        for (int i = 0; i < p.size(); i++){
            System.out.println(p.get(i).displayDomino());
        }
	}
    
        
    /*public static Domino playDomino(List<Domino> player){
        
        Domino chosen;
        
        if (chosen.getLeft() = chosen.getRight()){
            playDomino(player);
        }
        else{
            
        }
        
    }*/

}
