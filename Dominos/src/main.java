import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class main {

	
	
	public static void main(String[] args) {
		
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
        
        ArrayList<Domino> playerOne = playerHand(5, dominoSet);
        System.out.print("Player One: ");
        printSet(playerOne);
        
        ArrayList<Domino> playerTwo = playerHand(5, dominoSet);
        System.out.print("PlayerTwo: ");
        printSet(playerTwo);
        
        if (players > 2) {
        	ArrayList<Domino> playerThree = playerHand(5, dominoSet);
        	System.out.print("Player Three: ");
        	printSet(playerThree);
        }
        
        if (players > 3) {
        	ArrayList<Domino> playerFour = playerHand(5, dominoSet);
        	System.out.print("\nPlayer Four: ");
        	printSet(playerFour);
        }
        
        /** Plays a two player game
         */
        ArrayList<Domino> game = twoPlayer(playerOne, playerTwo, dominoSet);
        
        System.out.println("\nComplete Game:");
        printSet(game);
    }
	
	/** 
	 * User determines the size of the set of dominos
	 * 
	 * @return 		The size of the set of dominos
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
	 * @param n 	The size of the set
	 * @return 		The ArrayList of dominos
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
	 * @return 		The number of players in the game
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
	 * Chooses a random domino out of the set input and removes it from original set.
	 * 
	 * @param s 	Set the domino is being chosen from
	 * @return 		The domino chosen
	 */
	public static Domino chooseRandomDomino(ArrayList<Domino> s) {
		Random rand = new Random();
		int randomIndex = rand.nextInt(s.size());
		Domino r = s.get(randomIndex);
        s.remove(randomIndex);
        
        return r;		
	}
	
	/** 
	 * Creates a player hand.
	 * 	
	 * @param numInHand The number of dominos the player should draw
	 * @param s 		The set of dominos that are not yet drawn
	 * @return 			The player's hand
	 */
	public static ArrayList<Domino> playerHand(int numInHand, ArrayList<Domino> s) {
		ArrayList<Domino> p = new ArrayList<>();
		
        int i = 0;
        while (i < numInHand){
            p.add(chooseRandomDomino(s));
            i++;
        }
        
        return p;
	}
	
	/**
	 * Prints the set input to the method.
	 * 
	 * @param p 	The domino set
	 */
	public static void printSet(ArrayList<Domino> p) {
		for (int i = 0; i < p.size(); i++){
            System.out.print(p.get(i).displayDomino() + "   ");
        }
		System.out.println();
	}
    
	/**
	 * Determines whether an ArrayList is empty
	 * 
	 * @param s		ArrayList being checked
	 * @return 		boolean value for whether the ArrayList is empty or not 
	 */
	public static boolean isEmpty(ArrayList<Domino> s) {
		if (s.size() == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Allows the player to add another domino to their set
	 * 
	 * @param p 	Players hand
	 * @param s 	Undrawn dominos in the set
	 * @return 		Players new hand
	 */
	public static ArrayList<Domino> draw(ArrayList<Domino> p, ArrayList<Domino> s){
		p.add(chooseRandomDomino(s));
		return p;
	}
	
	/**
	 * Adds value of the dominos in the player's hand. Used at the end of the game to determine ranking.
	 * 
	 * @param p 	Player hand
	 * @return 		Total number value of the dominos in the player's hand
	 */
	public static int addValues(ArrayList<Domino> p) {
		int value = 0;
		
		for (int i = 0; i < p.size(); i++){
			value += p.get(i).getLeft();
			value += p.get(i).getRight();
        }
		
		return value;
	}
	
	/**
	 * This method allows for a basic game of dominos involving a single playing track
	 * 
	 * @param one 	Player one's hand
	 * @param two 	Player two's hand
	 * @param s 	Undrawn set of dominos
	 * @return 		The ArrayList holding the game track
	 */
    public static ArrayList<Domino> twoPlayer(ArrayList<Domino> one, ArrayList<Domino> two, ArrayList<Domino> s){
    	
    	ArrayList<Domino> track = new ArrayList<Domino>();
    	Domino tail = chooseRandomDomino(s);
    	track.add(tail);
    	
    	int count = 1;
        while((one.size() > 0) && (two.size() > 0)) {
        	boolean movesOne = chooseDomino(one, tail, s, track);
        	tail = track.get(track.size() - 1);
        	
        	boolean movesTwo = chooseDomino(two, tail, s, track);
        	tail = track.get(track.size() - 1);
        	
        	
        	System.out.println("\n\n\nRound " + (count) + ": ");
        	printSet(track);
        	
        	
        	System.out.println("\nPlayer one hand size: " + one.size());
        	System.out.println("Player one hand: ");
        	printSet(one);
        	
        	
        	System.out.println("\nPlayer two hand size: " + two.size());
        	System.out.println("Player two hand: ");
        	printSet(two);
        	
        	
        	if ((movesOne == true) && (movesTwo == true)) {
        		System.out.println("No more moves. Game terminated.");
        		break;
        	}
        	
        	

        	count++;
        }
        
        System.out.println("\nPlayer one total: " + addValues(one));
        System.out.println("Player two total: " + addValues(two));
        
        return track;
        
    }
    
    /**
     * Chooses a domino from the player hand to be played in the game
     *     
     * @param p 	Player hand being chosen from
     * @param tail 	Last domino on game track
     * @param s 	Full set of undrawn dominos, used in case the player needs to draw
     * @param t 	Game track
     * @return		Boolean value determining if the player can make moves given the current tail
     */
    public static boolean chooseDomino(ArrayList<Domino> p, Domino tail, ArrayList<Domino> s, ArrayList<Domino> t) {
    	int tempIndex = 99;
    	int largestRight = -1;
    	boolean noMoves = false;
    	for (int i = 0; i < p.size(); i++) {
    		if (tail.getRight() == p.get(i).getRight()) {
    			p.get(i).rotateDomino();
    		}
    		if (tail.getRight() == p.get(i).getLeft()) {
    			if (p.get(i).getRight() > largestRight) {
    				largestRight = p.get(i).getRight();
    				tempIndex = i;
    			}
    		}
    	}
    	if (tempIndex == 99) {
    		if (s.isEmpty() == false) {
    			draw(p,s);
        		if (tail.getRight() == p.get(p.size() - 1).getRight()) {
        			p.get(p.size() - 1).rotateDomino();
        		}
        		if (tail.getRight() == p.get(p.size() - 1).getLeft()) {
        			Domino newTail = p.get(p.size() - 1);
        			t.add(newTail);
        			p.remove(newTail);
        		}
    		}
    		else {
    			System.out.println("No more dominos");
    			noMoves = true;
    		}
    	}
    	else {
    		Domino newTail = p.get(tempIndex);
        	t.add(newTail);
        	p.remove(newTail);
    	}
    	
    	return noMoves;
    }
    

}
