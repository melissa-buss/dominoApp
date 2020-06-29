import java.util.ArrayList;
import java.util.Random;


/**
 * 
 * 
 * @author Melissa Buss
 * @version 5.0
 * @since 6/29/20
 *
 */
public class game {
	ArrayList<Domino> dominoSet;
	ArrayList<Domino> playerOne;
	ArrayList<Domino> playerTwo;
	ArrayList<Domino> playerThree;
	ArrayList<Domino> playerFour;
	ArrayList<Domino> gameTrack;
	
	/**
	 * Creates the total set of dominos for the game 
	 * 
	 * @param s	The size of the set of dominos
	 */
	public game(int s) {
		createDominoSet(s);
	}
	
	/**
	 * Accesses the full domino set (undrawn)
	 * 
	 * @return The set of dominos
	 */
	public ArrayList<Domino> getDominoSet() {
		return dominoSet;
	}
	
	/**
	 * Adds and/or updates the ArrayList of the domino set in the game object
	 * 
	 * @param s The ArrayList being set in the game object
	 */
	public void setDominoSet(ArrayList<Domino> s) {
		this.dominoSet = s;
	}
	
	/**
	 * Creates the complete set of dominos using the user-determined size
	 * 
	 * @param numInSet 	The size of the set
	 */
	public void createDominoSet(int numInSet){
		dominoSet = new ArrayList<Domino>();
        for (int i = 0; i <= numInSet; i++){
            for (int j= i; j <= numInSet; j++){
                dominoSet.add(new Domino(i, j));
            }
        }
	}
	
	/**
	 * Accesses player one's domino set
	 * 
	 * @return Player one's domino set
	 */
	public ArrayList<Domino> getPlayerOne() {
		return playerOne;
	}
	
	/**
	 * Adds and/or updates player one's domino set
	 * 
	 * @param p The ArrayList being added for player one
	 */
	public void setPlayerOne(ArrayList<Domino> p) {
		this.playerOne = p;
	}
	
	/**
	 * Accesses player two's domino set
	 * 
	 * @return Player two's domino set
	 */
	public ArrayList<Domino> getPlayerTwo() {
		return playerTwo;
	}
	
	/**
	 * Adds and/or updates player two's domino set
	 * 
	 * @param p The ArrayList being added for player two
	 */
	public void setPlayerTwo(ArrayList<Domino> p) {
		this.playerTwo = p;
	}
	
	/**
	 * Accesses player three's domino set
	 * 
	 * @return Player three's domino set
	 */
	public ArrayList<Domino> getPlayerThree() {
		return playerThree;
	}
	
	/**
	 * Adds and/or updates player three's domino set
	 * 
	 * @param p The ArrayList being added for player three
	 */
	public void setPlayerThree(ArrayList<Domino> p) {
		this.playerThree = p;
	}
	
	/**
	 * Returns a value determining if the game has 3 players
	 * 
	 * @return Whether the game has 3 players or not
	 */
	public boolean hasPlayerThree() {
		if (playerThree == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Accesses player four's domino set
	 * 
	 * @return Player four's domino set
	 */
	public ArrayList<Domino> getPlayerFour() {
		return playerFour;
	}
	
	/**
	 * Adds and/or updates player four's domino set
	 * 
	 * @param p The ArrayList being added for player four
	 */
	public void setPlayerFour(ArrayList<Domino> p) {
		this.playerFour = p;
	}
	
	/**
	 * Returns a value determining if the game has 4 players
	 * 
	 * @return Whether the game has 4 players or not
	 */
	public boolean hasPlayerFour() {
		if (playerFour == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Accesses the game track
	 * 
	 * @return The game track
	 */
	public ArrayList<Domino> getGameTrack(){
		return gameTrack;
	}
	
	/**
	 * Adds and/or updates the game track
	 * 
	 * @param t The game track being added to the game object
	 */
	public void setGameTrack(ArrayList<Domino> t) {
		this.gameTrack = t;
	}
		
	/** 
	 * Creates a player hand.
	 * 	
	 * @param numInHand The number of dominos the player should draw
	 * @param s 		The set of dominos that are not yet drawn
	 * @return 			The player's hand
	 */
	public ArrayList<Domino> createPlayerHand(int numInHand, ArrayList<Domino> s) {
		ArrayList<Domino> p = new ArrayList<>();
		
	    int i = 0;
	    while (i < numInHand){
	        p.add(chooseRandomDomino());
	        i++;
	    }
	    
	    return p;
	}

	/**
	 * Chooses a random domino out of the set, also removing it once it's chosen.
	 * 
	 * @return 		The domino chosen
	 */
	public Domino chooseRandomDomino() {
		Random rand = new Random();
		int randomIndex = rand.nextInt(dominoSet.size());
		Domino r = dominoSet.get(randomIndex);
	    dominoSet.remove(randomIndex);
	    
	    return r;		
	}

	/**
	 * Prints set to the screen for user to see.
	 * 
	 * @param p 	The domino set
	 */
	public static void printSet(ArrayList<Domino> s) {
		for (int i = 0; i < s.size(); i++){
            System.out.print(s.get(i).displayDomino() + "   ");
        }
		System.out.println();
	}
	
	/**
	 * Prints the last five elements in an array list, used to print the game track during play.
	 * 
	 * @param s Array list being printed
	 */
	public static void printLastFive(ArrayList<Domino> s) {
		for (int i = 5; i > 0; i--) {
			try {
				System.out.print(s.get(s.size() - i).displayDomino() + "   ");
			} catch ( IndexOutOfBoundsException e ) {
			    continue;
			}
		}
	}
	
	/**
	 * Determines whether a domino set is empty
	 * 
	 * @param s		ArrayList being checked
	 * @return 		boolean value determining whether the ArrayList is empty or not 
	 */
	public boolean isEmpty(ArrayList<Domino> s) {
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
	 * @param s 	Set of undrawn dominos
	 */
	public void draw(ArrayList<Domino> p, ArrayList<Domino> s){
		p.add(chooseRandomDomino());
	}
    
	
}
