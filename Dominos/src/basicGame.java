import java.util.ArrayList;
import java.util.Scanner;

public class basicGame extends game{

	public basicGame(int s) {
		super(s);
	}
	
	/**
     * Allows the user to choose the domino they'd like to play in games with user input
     * 
     * @param p		Player hand being chosen from
     * @param g		Game object holding necessary information such as game track and the set of undrawn dominos
     * @return		Boolean value determining if the player can make moves given the current tail
     */
    public boolean userChooseDomino(ArrayList<Domino> p, game g) {
    	ArrayList<Domino> s = g.getDominoSet();
    	ArrayList<Domino> track = g.getGameTrack();
    	Domino tail = track.get(track.size() - 1);
    	
    	boolean noMoves = false;
    	Scanner choose = new Scanner(System.in);
    	Scanner playDraw = new Scanner(System.in);
		int chosen = 0;
		
		System.out.println("Which domino do you choose?: ");
		for (int i = 0; i < p.size(); i++) {
			System.out.println((i+1) + ": " + p.get(i).displayDomino());
		}
		System.out.println("0: Draw");
		System.out.println("100: No moves");
		
		chosen = choose.nextInt();
		
		if (chosen == 0) {
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
    					track.add(newDomino);
    		        	p.remove(newDomino);
    		        	if ((newDomino.isDouble()) && (p.size() > 0)) {
    		        		System.out.println("You played a double! Please play another domino.");
    						userChooseDomino(p, g);
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
		else if (chosen == 100) {
			noMoves = true;
		}
		else if (chosen > 0 && chosen <= p.size()) {
			Domino check = p.get(chosen - 1);
			if (tail.getRight() == check.getRight()) {
    			check.rotateDomino();
    		}
			if (tail.getRight() == check.getLeft()) {
				track.add(check);
	        	p.remove(check);
	        	if ((check.isDouble()) && (p.size() > 0)) {
	        		System.out.println("You played a double! Please play another domino.");
					userChooseDomino(p, g);
				}
    		}
			else {
				System.out.println("This domino cannot be placed here. Please try again.");
				userChooseDomino(p, g);
			}
		}
		else {
			System.out.println("Invalid input. Please try again");
			userChooseDomino(p, g);
		}
		
				
		
		return noMoves;
    }
            
    /**
     * Chooses a domino from the computer player's hand to be played in the game
     *     
     * @param p		Player hand being chosen from
     * @param g		Game object holding necessary information such as game track and the set of undrawn dominos
     * @return		Boolean value determining if the player can make moves given the current tail
     */
    public boolean cpChooseDomino(ArrayList<Domino> p, game g) {
    	ArrayList<Domino> s = g.getDominoSet();
    	ArrayList<Domino> track = g.getGameTrack();
    	Domino tail = track.get(track.size() - 1);    	
    	
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
        			track.add(newDomino);
        			p.remove(newDomino);
        			if ((newDomino.isDouble()) && (p.size() > 0)) {
        				System.out.println("The computer player played a double!");
						cpChooseDomino(p, g);
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
        	track.add(newDomino);
        	p.remove(newDomino);
        	if ((newDomino.isDouble()) && (p.size() > 0)) {
				System.out.println("The computer player played a double!.");
				cpChooseDomino(p, g);
			}
    	}
    	
    	return noMoves;
    }
	
	/**
     * User chooses how many players are in the game. This input is then used to run the game.
     * 
     * @return 		The game track after it is played
     */
	public game chooseNumOfPlayers() {
		int n = 5;
		ArrayList<Domino> s = this.getDominoSet();
		
		
		Scanner players = new Scanner(System.in);
        System.out.println("How many players?");
        System.out.println("1. 2 Players \t\t\t2. 3 Players\t\t\t3. 4 Players");
        int opt = players.nextInt();
		
		switch(opt){
        	case 1:
        		this.setPlayerOne(playerHand(n, s));
        		this.setPlayerTwo(playerHand(n, s));
        		return twoPlayers(this);
        		        		
        	case 2: 
        		this.setPlayerOne(playerHand(n, s));
        		this.setPlayerTwo(playerHand(n, s));
        		this.setPlayerThree(playerHand(n, s));
        		return threePlayers(this);
        	        		
        	case 3: 
        		this.setPlayerOne(playerHand(n, s));
        		this.setPlayerTwo(playerHand(n, s));
        		this.setPlayerThree(playerHand(n, s));
        		this.setPlayerFour(playerHand(n, s));
        		return fourPlayers(this);
        		
        	default:
        		System.out.println("Invalid input. Ending now.");
        		return this;
		}
	}
	
	/** 
     * This method runs a basic game of dominos involving one user and one computer player
	 * 
	 * @param g 	Game object used to run the game
	 * @return 		The game with the newly created game track and updated player sets and undrawn sets
	 */
    public game twoPlayers(game g){
   	    	    	
   		gameTrack = new ArrayList<Domino>();
   		gameTrack.add(chooseRandomDomino());
   		
   		printSet(gameTrack);
   	
   		int count = 1;
   		while((playerOne.size() > 0) && (playerTwo.size() > 0)) {
	       	boolean movesOne = userChooseDomino(playerOne, g);
	       	
	       	boolean movesTwo = cpChooseDomino(playerTwo, g);
	       	printSet(gameTrack);
	       	
	       	if ((movesOne == true) && (movesTwo == true)) {
	       		System.out.println("No more moves. Game terminated.");
	       		break;
	       	}
	       	
	       	count++;
   		}
   		
   		System.out.println("\n\nGame Stats: ");
   		System.out.println("Total rounds = " + count);
        System.out.println("Player one total: " + addValues(playerOne));
	    System.out.println("Player two total: " + addValues(playerTwo));
       
	    return g;
       
    }  
        
    /**
     * This method runs a basic game of dominos involving one user and two computer players
     * 
	 * @param g 	Game object used to run the game
	 * @return 		The game with the newly created game track and updated player sets and undrawn sets
     */
    public game threePlayers(game g){
    	
    	gameTrack = new ArrayList<Domino>();
   		gameTrack.add(chooseRandomDomino());
   		
   		printSet(gameTrack);
   	
   		int count = 1;
   		while((playerOne.size() > 0) && (playerTwo.size() > 0) && (playerThree.size() > 0)) {
	       	boolean movesOne = userChooseDomino(playerOne, g);
	       	
	       	boolean movesTwo = cpChooseDomino(playerTwo, g);
	       	
	       	boolean movesThree = cpChooseDomino(playerThree, g);
	       	printSet(gameTrack);
	       	
	       	if ((movesOne == true) && (movesTwo == true) && (movesThree == true)) {
	       		System.out.println("No more moves. Game terminated.");
	       		break;
	       	}
	       	
	       	count++;
   		}
   		
   		System.out.println("\n\nGame Stats: ");
   		System.out.println("Total rounds = " + count);
        System.out.println("Player one total: " + addValues(playerOne));
	    System.out.println("Player two total: " + addValues(playerTwo));
	    System.out.println("Player three total: " + addValues(playerThree));
       
	    return g;
    }
    
    /**
     * This method runs a basic game of dominos involving one user and three computer players
     * 
	 * @param g 	Game object used to run the game
	 * @return 		The game with the newly created game track and updated player sets and undrawn sets
     */
    public game fourPlayers(game g){
    	
    	gameTrack = new ArrayList<Domino>();
   		gameTrack.add(chooseRandomDomino());
   		
   		printSet(gameTrack);
   	
   		int count = 1;
   		while((playerOne.size() > 0) && (playerTwo.size() > 0) && (playerThree.size() > 0) && (playerFour.size() > 0)) {
	       	boolean movesOne = userChooseDomino(playerOne, g);
	        
	       	boolean movesTwo = cpChooseDomino(playerTwo, g);
	       	
	       	boolean movesThree = cpChooseDomino(playerThree, g);
	       	
	       	boolean movesFour = cpChooseDomino(playerFour, g);
	       	printSet(gameTrack);
	       	
	       	if ((movesOne == true) && (movesTwo == true) && (movesThree == true) && (movesFour == true)) {
	       		System.out.println("No more moves. Game terminated.");
	       		break;
	       	}
	       	
	       	count++;
   		}
   		
   		System.out.println("\n\nGame Stats: ");
   		System.out.println("Total rounds = " + count);
        System.out.println("Player one total: " + addValues(playerOne));
	    System.out.println("Player two total: " + addValues(playerOne));
        System.out.println("Player three total: " + addValues(playerThree));
	    System.out.println("Player four total: " + addValues(playerFour));
       
	    return g;
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

	


