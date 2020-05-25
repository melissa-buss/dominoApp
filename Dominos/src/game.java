import java.util.ArrayList;
import java.util.Random;

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
		dominoSet = createDominoSet(s);
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
	 * Creates the complete set of dominos using the user-determined size
	 * 
	 * @param numInSet 	The size of the set
	 * @return 			The ArrayList of dominos
	 */
	public static ArrayList<Domino> createDominoSet(int numInSet){
		ArrayList<Domino> completeDominoSet = new ArrayList<>();
        
        for (int i = 0; i <= numInSet; i++){
            for (int j= i; j <= numInSet; j++){
                completeDominoSet.add(new Domino(i, j));
            }
        }
        
        return completeDominoSet;
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
	 * Creates a player hand.
	 * 	
	 * @param numInHand The number of dominos the player should draw
	 * @param s 		The set of dominos that are not yet drawn
	 * @return 			The player's hand
	 */
	public ArrayList<Domino> playerHand(int numInHand, ArrayList<Domino> s) {
		ArrayList<Domino> p = new ArrayList<>();
		
        int i = 0;
        while (i < numInHand){
            p.add(chooseRandomDomino());
            i++;
        }
        
        return p;
	}
	
	/**
	 * Determines whether a domino set is empty
	 * 
	 * @param s		ArrayList being checked
	 * @return 		boolean value determining whether the ArrayList is empty or not 
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
	 * @param s 	Set of undrawn dominos
	 * @return 		Players updated hand
	 */
	public ArrayList<Domino> draw(ArrayList<Domino> p, ArrayList<Domino> s){
		p.add(chooseRandomDomino());
		return p;
	}
    
	
}
