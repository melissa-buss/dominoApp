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
        
        /** User chooses game and it runs through chooseGame method 
         **/   
        Scanner players = new Scanner(System.in);
        System.out.println("How many players?");
        System.out.println("1. 1 User, 1 CP \t\t\t5. 2 User's, 1 CP\t\t\t9. 3 User's, 1 CP");
        System.out.println("2. 2 CP's \t\t\t\t6. 3 CP's\t\t\t\t10. 2 User's, 2 CP's");
        System.out.println("3. 2 Users \t\t\t\t7. 3 User's\t\t\t\t11. 4 CP's");
        System.out.println("4. 1 User, 2 CP's \t\t\t8. 1 User, 3 CP's\t\t\t12. 4 User's");
        int opt = players.nextInt();
        
        chooseGame(opt, dominoSet);
        
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
     * User chooses how many players are in the game and how many are users or computer players. This input is then used to run the game of their choosing.
     * 
     * @param c User's choice
     * @param s The set of undrawn dominos
     * @return The game track after it is played
     */
	public static ArrayList<Domino> chooseGame(int c, ArrayList<Domino> s) {
		int n = 5;
		
		ArrayList<Domino> playerOne;
		ArrayList<Domino> playerTwo;
		ArrayList<Domino> playerThree;
		ArrayList<Domino> playerFour;
		
		switch(c){
        	case 1:
        		playerOne = playerHand(n, s);
        		playerTwo = playerHand(n, s);
        		return oneUserOneCP(playerOne, playerTwo, s);
        		
        	case 2:
        		playerOne = playerHand(n, s);
        		playerTwo = playerHand(n, s);
        		return twoCP(playerOne, playerTwo, s);
        		
        	case 3:
        		playerOne = playerHand(n, s);
        		playerTwo = playerHand(n, s);
        		return twoUser(playerOne, playerTwo, s);
        		
        	case 4: 
        		playerOne = playerHand(n, s);
        		playerTwo = playerHand(n, s);
        		playerThree = playerHand(n, s);
        		return oneUserTwoCP(playerOne, playerTwo, playerThree, s);
        		
        	case 5:
        		playerOne = playerHand(n, s);
        		playerTwo = playerHand(n, s);
        		playerThree = playerHand(n, s);
        		return twoUserOneCP(playerOne, playerTwo, playerThree, s);
        		
        	case 6:
        		playerOne = playerHand(n, s);
        		playerTwo = playerHand(n, s);
        		playerThree = playerHand(n, s);
        		return threeCP(playerOne, playerTwo, playerThree, s);
        		
        	case 7:
        		playerOne = playerHand(n, s);
        		playerTwo = playerHand(n, s);
        		playerThree = playerHand(n, s);
        		return threeUser(playerOne, playerTwo, playerThree, s);
        		
        	case 8: 
        		playerOne = playerHand(n, s);
        		playerTwo = playerHand(n, s);
        		playerThree = playerHand(n, s);
        		playerFour = playerHand(n, s);
        		return oneUserThreeCP(playerOne, playerTwo, playerThree, playerFour, s);
        		
        	case 9:
        		playerOne = playerHand(n, s);
        		playerTwo = playerHand(n, s);
        		playerThree = playerHand(n, s);
        		playerFour = playerHand(n, s);
        		return threeUserOneCP(playerOne, playerTwo, playerThree, playerFour, s);
        		
        	case 10:
        		playerOne = playerHand(n, s);
        		playerTwo = playerHand(n, s);
        		playerThree = playerHand(n, s);
        		playerFour = playerHand(n, s);
        		return twoUserTwoCP(playerOne, playerTwo, playerThree, playerFour, s);
        		
        	case 11:
        		playerOne = playerHand(n, s);
        		playerTwo = playerHand(n, s);
        		playerThree = playerHand(n, s);
        		playerFour = playerHand(n, s);
        		return fourCP(playerOne, playerTwo, playerThree, playerFour, s);
        		
        	case 12: 
        		playerOne = playerHand(n, s);
        		playerTwo = playerHand(n, s);
        		playerThree = playerHand(n, s);
        		playerFour = playerHand(n, s);
        		return fourUsers(playerOne, playerTwo, playerThree, playerFour, s);
        		
        	default:
        		System.out.println("Invalid input. Ending now.");
        		ArrayList<Domino> track = new ArrayList<Domino>();
        		return track;
		}
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
     * Allows the user to choose the domino they'd like to play in games with user input
     * 
     * @param p		Player hand being chosen from
     * @param tail 	Last domino on game track
     * @param s 	Full set of undrawn dominos, used in case the player needs to draw
     * @param t 	Game track
     * @return		Boolean value determining if the player can make moves given the current tail
     */
    public static boolean userChooseDomino(ArrayList<Domino> p, Domino tail, ArrayList<Domino> s, ArrayList<Domino> t) {
    	boolean noMoves = false;
    	Scanner choose = new Scanner(System.in);
    	Scanner playDraw = new Scanner(System.in);
		int chosen = 0;
		
		System.out.println("Which domino do you choose?: ");
		for (int i = 0; i < p.size(); i++) {
			System.out.println((i+1) + ": " + p.get(i).displayDomino());
		}
		System.out.println("100: Draw");
		System.out.println("101: No moves");
		
		chosen = choose.nextInt();
		
		if (chosen == 100) {
			if (s.isEmpty() == false) {
				draw(p,s);
				Domino newDomino = p.get(p.size()-1);
				System.out.println(newDomino.displayDomino());
        		System.out.print("Would you like to place this domino? Enter 0 for NO or 1 for YES: ");
        		int ans = playDraw.nextInt();
        		if (ans == 1) {
        			if (tail.getRight() == newDomino.getRight()) {
    	    			newDomino.rotateDomino();
    	    		}
    				if (tail.getRight() == newDomino.getLeft()) {
    					t.add(newDomino);
    		        	p.remove(newDomino);
    		        	if (newDomino.isDouble()) {
    		        		System.out.println("You played a double! Please play another domino.");
    						userChooseDomino(p, newDomino, s, t);
    					}
    	    		}
    				else {
    					System.out.println("This domino cannot be placed here.");
    				}
        		}
			}
			else {
				System.out.println("No more dominos");
				noMoves = true;
			}
		}
		else if (chosen == 101) {
			noMoves = true;
		}
		else if (chosen > 0 && chosen <= p.size()) {
			Domino check = p.get(chosen - 1);
			if (tail.getRight() == check.getRight()) {
    			check.rotateDomino();
    		}
			if (tail.getRight() == check.getLeft()) {
				t.add(check);
	        	p.remove(check);
	        	if (check.isDouble()) {
	        		System.out.println("You played a double! Please play another domino.");
					userChooseDomino(p, check, s, t);
				}
    		}
			else {
				System.out.println("This domino cannot be placed here. Please try again.");
				userChooseDomino(p, tail, s, t);
			}
		}
		else {
			System.out.println("Invalid input. Please try again");
			userChooseDomino(p, tail, s, t);
		}
		
		
		return noMoves;
    }
            
    /**
     * Chooses a domino from the computer player's hand to be played in the game
     *     
     * @param p 	Player hand being chosen from
     * @param tail 	Last domino on game track
     * @param s 	Full set of undrawn dominos, used in case the player needs to draw
     * @param t 	Game track
     * @return		Boolean value determining if the player can make moves given the current tail
     */
    public static boolean cpChooseDomino(ArrayList<Domino> p, Domino tail, ArrayList<Domino> s, ArrayList<Domino> t) {
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
    			Domino newDomino = p.get(p.size() - 1);
        		if (tail.getRight() == newDomino.getRight()) {
        			newDomino.rotateDomino();
        		}
        		if (tail.getRight() == newDomino.getLeft()) {
        			t.add(newDomino);
        			p.remove(newDomino);
        			if (newDomino.isDouble()) {
        				System.out.println("The computer player played a double!");
						cpChooseDomino(p, newDomino, s, t);
        			}
        		}
    		}
    		else {
    			System.out.println("No more dominos");
    			noMoves = true;
    		}
    	}
    	else {
    		Domino newDomino = p.get(tempIndex);
        	t.add(newDomino);
        	p.remove(newDomino);
        	if (newDomino.isDouble()) {
				System.out.println("The computer player played a double!.");
				cpChooseDomino(p, newDomino, s, t);
			}
    	}
    	
    	return noMoves;
    }

    /** 
     * This method runs a basic game of dominos involving one user and one computer player
	 * 
	 * @param one 	Player one's hand
	 * @param two 	Player two's hand
	 * @param s 	Undrawn set of dominos
	 * @return 		The ArrayList holding the game track
	 */
    public static ArrayList<Domino> oneUserOneCP(ArrayList<Domino> one, ArrayList<Domino> two, ArrayList<Domino> s){
   	
   		ArrayList<Domino> track = new ArrayList<Domino>();
   		Domino tail = chooseRandomDomino(s);
   		track.add(tail);
   		
   		printSet(track);
   	
   		int count = 1;
   		while((one.size() > 0) && (two.size() > 0)) {
	       	boolean movesOne = userChooseDomino(one, tail, s, track);
	       	tail = track.get(track.size() - 1);
	       	
	       	boolean movesTwo = cpChooseDomino(two, tail, s, track);
	       	tail = track.get(track.size() - 1);
	       	printSet(track);
	       	
	       	if ((movesOne == true) && (movesTwo == true)) {
	       		System.out.println("No more moves. Game terminated.");
	       		break;
	       	}
	       	
	       	count++;
   		}
   		
   		System.out.println("\n\nGame Stats: ");
   		System.out.println("Total rounds = " + count);
        System.out.println("Player one total: " + addValues(one));
	    System.out.println("Player two total: " + addValues(two));
       
	    return track;
       
    }
    
	/**
	 * This method runs a basic game of dominos involving two computer players
	 * 
	 * @param one 	Player one's hand
	 * @param two 	Player two's hand
	 * @param s 	Undrawn set of dominos
	 * @return 		The ArrayList holding the game track
	 */
    public static ArrayList<Domino> twoCP(ArrayList<Domino> one, ArrayList<Domino> two, ArrayList<Domino> s){
    	
    	ArrayList<Domino> track = new ArrayList<Domino>();
    	Domino tail = chooseRandomDomino(s);
    	track.add(tail);
    	
    	int count = 1;
        while((one.size() > 0) && (two.size() > 0)) {
        	boolean movesOne = cpChooseDomino(one, tail, s, track);
        	tail = track.get(track.size() - 1);
        	
        	boolean movesTwo = cpChooseDomino(two, tail, s, track);
        	tail = track.get(track.size() - 1);
        	
        	printSet(track);
        	      	
        	if ((movesOne == true) && (movesTwo == true)) {
        		System.out.println("No more moves. Game terminated.");
        		break;
        	}
        	
        	

        	count++;
        }
        
        System.out.println("\n\nGame Stats: ");
   		System.out.println("Total rounds = " + count);
        System.out.println("Player one total: " + addValues(one));
	    System.out.println("Player two total: " + addValues(two));
        
        return track;
        
    }
    
    /**
     * IN PROGRESS. This method runs a basic game of dominos involving two users
     * 
     * @param one	Player one's hand
     * @param two	Player two's hand
     * @param s		Undrawn set of dominos
     * @return		The ArrayList holding the game track
     */
    public static ArrayList<Domino> twoUser(ArrayList<Domino> one, ArrayList<Domino> two, ArrayList<Domino> s){
    	System.out.println("Coming soon!");
    	
    	ArrayList<Domino> track = new ArrayList<Domino>();
    	return track;
    }
        
    /**
     * IN PROGRESS. This method runs a basic game of dominos involving one user and two computer players
     * 
     * @param one	Player one's hand
     * @param two	Player two's hand
     * @param three Player three's hand
     * @param s		Undrawn set of dominos
     * @return		The ArrayList holding the game track
     */
    public static ArrayList<Domino> oneUserTwoCP(ArrayList<Domino> one, ArrayList<Domino> two, ArrayList<Domino> three, ArrayList<Domino> s){
    	System.out.println("Coming soon!");
    	
    	ArrayList<Domino> track = new ArrayList<Domino>();
    	return track;
    }
    
    /**
     * IN PROGRESS. This method runs a basic game of dominos involving two users and one computer player
     * 
     * @param one	Player one's hand
     * @param two	Player two's hand
     * @param three Player three's hand
     * @param s		Undrawn set of dominos
     * @return		The ArrayList holding the game track
     */
    public static ArrayList<Domino> twoUserOneCP(ArrayList<Domino> one, ArrayList<Domino> two, ArrayList<Domino> three, ArrayList<Domino> s){
    	System.out.println("Coming soon!");
    	
    	ArrayList<Domino> track = new ArrayList<Domino>();
    	return track;
    }
    
    /**
     * IN PROGRESS. This method runs a basic game of dominos involving three computer players
     * 
     * @param one	Player one's hand
     * @param two	Player two's hand
     * @param three Player three's hand
     * @param s		Undrawn set of dominos
     * @return		The ArrayList holding the game track
     */
    public static ArrayList<Domino> threeCP(ArrayList<Domino> one, ArrayList<Domino> two, ArrayList<Domino> three, ArrayList<Domino> s){
    	System.out.println("Coming soon!");
    	
    	ArrayList<Domino> track = new ArrayList<Domino>();
    	return track;
    }
    
    /**
     * IN PROGRESS. This method runs a basic game of dominos involving three users
     * 
     * @param one	Player one's hand
     * @param two	Player two's hand
     * @param three Player three's hand
     * @param s		Undrawn set of dominos
     * @return		The ArrayList holding the game track
     */
    public static ArrayList<Domino> threeUser(ArrayList<Domino> one, ArrayList<Domino> two, ArrayList<Domino> three, ArrayList<Domino> s){
    	System.out.println("Coming soon!");
    	
    	ArrayList<Domino> track = new ArrayList<Domino>();
    	return track;
    }
    
    /**
     * IN PROGRESS. This method runs a basic game of dominos involving one user and three computer players
     * 
     * @param one	Player one's hand
     * @param two	Player two's hand
     * @param three Player three's hand
     * @param four	Player four's hand
     * @param s		Undrawn set of dominos
     * @return		The ArrayList holding the game track
     */
    public static ArrayList<Domino> oneUserThreeCP(ArrayList<Domino> one, ArrayList<Domino> two, ArrayList<Domino> three, ArrayList<Domino> four, ArrayList<Domino> s){
    	System.out.println("Coming soon!");
    	
    	ArrayList<Domino> track = new ArrayList<Domino>();
    	return track;
    }
    
    /**
     * IN PROGRESS. This method runs a basic game of dominos involving three users and one computer player
     * 
     * @param one	Player one's hand
     * @param two	Player two's hand
     * @param three Player three's hand
     * @param four	Player four's hand
     * @param s		Undrawn set of dominos
     * @return		The ArrayList holding the game track
     */
    public static ArrayList<Domino> threeUserOneCP(ArrayList<Domino> one, ArrayList<Domino> two, ArrayList<Domino> three, ArrayList<Domino> four, ArrayList<Domino> s){
    	System.out.println("Coming soon!");
    	
    	ArrayList<Domino> track = new ArrayList<Domino>();
    	return track;
    }
    
    /**
     * IN PROGRESS. This method runs a basic game of dominos involving two users and two computer players
     * 
     * @param one	Player one's hand
     * @param two	Player two's hand
     * @param three Player three's hand
     * @param four	Player four's hand
     * @param s		Undrawn set of dominos
     * @return		The ArrayList holding the game track
     */
    public static ArrayList<Domino> twoUserTwoCP(ArrayList<Domino> one, ArrayList<Domino> two, ArrayList<Domino> three, ArrayList<Domino> four, ArrayList<Domino> s){
    	System.out.println("Coming soon!");
    	
    	ArrayList<Domino> track = new ArrayList<Domino>();
    	return track;
    }
    
    /**
     * IN PROGRESS. This method runs a basic game of dominos involving four computer players
     * 
     * @param one	Player one's hand
     * @param two	Player two's hand
     * @param three Player three's hand
     * @param four	Player four's hand
     * @param s		Undrawn set of dominos
     * @return		The ArrayList holding the game track
     */
    public static ArrayList<Domino> fourCP(ArrayList<Domino> one, ArrayList<Domino> two, ArrayList<Domino> three, ArrayList<Domino> four, ArrayList<Domino> s){
    	System.out.println("Coming soon!");
    	
    	ArrayList<Domino> track = new ArrayList<Domino>();
    	return track;
    }
    
    /**
     * IN PROGRESS. This method runs a basic game of dominos involving four users
     * 
     * @param one	Player one's hand
     * @param two	Player two's hand
     * @param three Player three's hand
     * @param four	Player four's hand
     * @param s		Undrawn set of dominos
     * @return		The ArrayList holding the game track
     */
    public static ArrayList<Domino> fourUsers(ArrayList<Domino> one, ArrayList<Domino> two, ArrayList<Domino> three, ArrayList<Domino> four, ArrayList<Domino> s){
    	System.out.println("Coming soon!");
    	
    	ArrayList<Domino> track = new ArrayList<Domino>();
    	return track;
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
}
