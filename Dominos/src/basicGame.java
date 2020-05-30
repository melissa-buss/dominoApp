import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * 
 * @author Melissa Buss
 * @version 4.1
 * @since 5/29/20
 *
 */
public class basicGame extends game{

	/**
	 * Creates the total set of dominos for the basic game 
	 * 
	 * @param s	The size of the set of dominos
	 */
	public basicGame(int s) {
		super(s);
	}
	
	/**
     * Allows the user to choose the domino they'd like to play in games with user input
     * 
     * @param p		Player hand being chosen from
     * @return		Boolean value determining if the player can make moves given the current tail
     */
    public boolean userChooseDomino(ArrayList<Domino> p) {
    	Domino tail = gameTrack.get(gameTrack.size() - 1);
    	
    	boolean noMoves = false;
    	Scanner choose = new Scanner(System.in);
    	Scanner playDraw = new Scanner(System.in);
		int chosen = 0;
		
		System.out.println("Which domino do you choose?: ");
		for (int i = 0; i < p.size(); i++) {
			System.out.println((i+1) + ": " + p.get(i).displayDomino());
		}
		if (dominoSet.isEmpty() == false) {
			System.out.println("0: Draw");
		}
		else {
			System.out.println("0: No moves");
		}
		
		
		chosen = choose.nextInt();
		
		if (chosen == 0) {
			if (userHasMoves(p)) {
				System.out.println("You have a domino you can play. Please try again");
				userChooseDomino(p);
			}
			else{
				if (dominoSet.isEmpty() == false) {
					draw(p, dominoSet);
					Domino newDomino = p.get(p.size()-1);
					System.out.println(newDomino.displayDomino());
	        		System.out.print("Would you like to place this domino? Enter 0 for NO or 1 for YES: ");
	        		int ans = playDraw.nextInt();
	        		if (ans == 1) {
	        			if (tail.getRight() == newDomino.getRight()) {
	    	    			newDomino.rotateDomino();
	    	    		}
	    				if (tail.getRight() == newDomino.getLeft()) {
	    					gameTrack.add(newDomino);
	    		        	p.remove(newDomino);
	    		        	if ((newDomino.isDouble()) && (p.size() > 0)) {
	    		        		System.out.println("You played a double! Please play another domino.");
	    						userChooseDomino(p);
	    					}
	    	    		}
	    				else {
	    					System.out.println("This domino cannot be placed here.");
	    				}
	        		}
	    			else {
	    				if (userHasMoves(p)) {
	    					System.out.println("You have a domino you can play. Please try again");
	    					userChooseDomino(p);
	    				}
	    				else {
		    				noMoves = true;
	    				}
	    			}
				}	
			}
		}
		else if (chosen > 0 && chosen <= p.size()) {
			Domino check = p.get(chosen - 1);
			if (tail.getRight() == check.getRight()) {
    			check.rotateDomino();
    		}
			if (tail.getRight() == check.getLeft()) {
				gameTrack.add(check);
	        	p.remove(check);
	        	if ((check.isDouble()) && (p.size() > 0)) {
	        		System.out.println("You played a double! Please play another domino.");
					userChooseDomino(p);
				}
    		}
			else {
				System.out.println("This domino cannot be placed here. Please try again.");
				userChooseDomino(p);
			}
		}
		else {
			System.out.println("Invalid input. Please try again");
			userChooseDomino(p);
		}
		
				
		
		return noMoves;
    }
    
    /**
     * Checks if the player has moves, prevents them from drawing a domino if they do not need to.
     * 
     * @param p Player whose hand is being checked for moves
     * @return boolean value determining whether or not the player has moves
     */
    public boolean userHasMoves(ArrayList<Domino> p) {
    	Domino tail = gameTrack.get(gameTrack.size() - 1);
    	int tailVal = tail.getRight();
    	
    	for (int i = 0; i < p.size(); i++) {
    		Domino check = p.get(i);
    		if ((check.getLeft() == tailVal) || (check.getRight() == tailVal)) {
    			return true;
    		}
    	}
    	    	
    	return false;
    }
    
            
    /**
     * Chooses a domino from the computer player's hand to be played in the game
     *     
     * @param p		Player hand being chosen from
     * @return		Boolean value determining if the player can make moves given the current tail
     */
    public boolean cpChooseDomino(ArrayList<Domino> p) {
    	Domino tail = gameTrack.get(gameTrack.size() - 1);    	
    	
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
    		if (dominoSet.isEmpty() == false) {
    			draw(p, dominoSet);
    			Domino newDomino = p.get(p.size() - 1);
        		if (tail.getRight() == newDomino.getRight()) {
        			newDomino.rotateDomino();
        		}
        		if (tail.getRight() == newDomino.getLeft()) {
        			gameTrack.add(newDomino);
        			p.remove(newDomino);
        			if ((newDomino.isDouble()) && (p.size() > 0)) {
						cpChooseDomino(p);
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
        	gameTrack.add(newDomino);
        	p.remove(newDomino);
        	if ((newDomino.isDouble()) && (p.size() > 0)) {
				cpChooseDomino(p);
			}
    	}
    	
    	return noMoves;
    }
	
	/**
     * User chooses how many players are in the game. This input is then used to run the game.
     * 
     */
	public game chooseNumOfPlayers() {
		int n = 5;
		
		
		
		Scanner players = new Scanner(System.in);
        System.out.println("How many players?");
        System.out.println("1. 2 Players \t\t\t2. 3 Players\t\t\t3. 4 Players");
        int opt = players.nextInt();
		
		switch(opt){
        	case 1:
        		this.setPlayerOne(createPlayerHand(n, dominoSet));
        		this.setPlayerTwo(createPlayerHand(n, dominoSet));
        		twoPlayers();
        		return this;
        		        		
        	case 2: 
        		this.setPlayerOne(createPlayerHand(n, dominoSet));
        		this.setPlayerTwo(createPlayerHand(n, dominoSet));
        		this.setPlayerThree(createPlayerHand(n, dominoSet));
        		threePlayers();
        		return this;
        	        		
        	case 3: 
        		this.setPlayerOne(createPlayerHand(n, dominoSet));
        		this.setPlayerTwo(createPlayerHand(n, dominoSet));
        		this.setPlayerThree(createPlayerHand(n, dominoSet));
        		this.setPlayerFour(createPlayerHand(n, dominoSet));
        		fourPlayers();
        		return this;
        		
        	default:
        		System.out.println("Invalid input. Ending now.");
        		return this;
		}
	}
	
	/** 
     * This method runs a basic game of dominos involving one user and one computer player
	 * 
	 */
    public void twoPlayers(){
   	    	    	
   		gameTrack = new ArrayList<Domino>();
   		gameTrack.add(findStartingDouble());
   		
   		printLastFive(gameTrack);
   	
   		int count = 1;
   		while((playerOne.size() > 0) && (playerTwo.size() > 0)) {
	       	boolean noMovesOne = userChooseDomino(playerOne);
	       	System.out.print("Player 1: \t");
	       	printLastFive(gameTrack);
	       	
	       	boolean noMovesTwo = cpChooseDomino(playerTwo);
	       	System.out.print("Player 2: \t");
	       	printLastFive(gameTrack);
	       	
	       	if ((noMovesOne) && (noMovesTwo)) {
	       		System.out.println("No more moves. Game terminated.");
	       		break;
	       	}
	       	else if (checkMovesInGame() == false) {
	       		System.out.println("No more moves. Game terminated.");
	       		break;
	       	}
	       	
	       	count++;
   		}
   		
   		System.out.println("\n\nGame Stats: ");
   		System.out.println("Total rounds = " + count);
   		System.out.println("Player one total: " + addValues(playerOne) + "\t\t\t# in Hand: " + playerOne.size());
	    System.out.println("Player two total: " + addValues(playerTwo) + "\t\t\t# in Hand: " + playerTwo.size());
       
       
    }  
        
    /**
     * This method runs a basic game of dominos involving one user and two computer players
     * 
     */
    public void threePlayers(){
    	
    	gameTrack = new ArrayList<Domino>();
    	gameTrack.add(findStartingDouble());
   		
   		printSet(gameTrack);
   	
   		int count = 1;
   		while((playerOne.size() > 0) && (playerTwo.size() > 0) && (playerThree.size() > 0)) {
	       	boolean noMovesOne = userChooseDomino(playerOne);
	       	System.out.print("Player 1: \t");
	       	printLastFive(gameTrack);
	       	
	       	boolean noMovesTwo = cpChooseDomino(playerTwo);
	       	System.out.print("Player 2: \t");
	       	printLastFive(gameTrack);
	       	
	       	boolean noMovesThree = cpChooseDomino(playerThree);
	       	System.out.print("Player 3: \t");
	       	printLastFive(gameTrack);
	       	
	       	if ((noMovesOne) && (noMovesTwo) && (noMovesThree)) {
	       		System.out.println("No more moves. Game terminated.");
	       		break;
	       	}
	       	if (checkMovesInGame() == false) {
	       		System.out.println("No more moves. Game terminated.");
	       		break;
	       	}
	       	
	       	count++;
   		}
   		
   		System.out.println("\n\nGame Stats: ");
   		System.out.println("Total rounds = " + count);
        System.out.println("Player one total: " + addValues(playerOne) + "\t\t\t# in Hand: " + playerOne.size());
	    System.out.println("Player two total: " + addValues(playerTwo) + "\t\t\t# in Hand: " + playerTwo.size());
	    System.out.println("Player three total: " + addValues(playerThree) + "\t\t\t# in Hand: " + playerThree.size());
       
    }
    
    /**
     * This method runs a basic game of dominos involving one user and three computer players
     * 
     */
    public void fourPlayers(){
    	
    	gameTrack = new ArrayList<Domino>();
    	gameTrack.add(findStartingDouble());
   		
   		printSet(gameTrack);
   	
   		int count = 1;
   		while((playerOne.size() > 0) && (playerTwo.size() > 0) && (playerThree.size() > 0) && (playerFour.size() > 0)) {
   			boolean noMovesOne = userChooseDomino(playerOne);
	       	System.out.print("Player 1: \t");
	       	printLastFive(gameTrack);
	       	
	       	boolean noMovesTwo = cpChooseDomino(playerTwo);
	       	System.out.print("Player 2: \t");
	       	printLastFive(gameTrack);
	       	
	       	boolean noMovesThree = cpChooseDomino(playerThree);
	       	System.out.print("Player 3: \t");
	       	printLastFive(gameTrack);
	       	
	       	boolean noMovesFour = cpChooseDomino(playerFour);
	       	System.out.print("Player 4: \t");
	       	printLastFive(gameTrack);
	       	
	       	if ((noMovesOne) && (noMovesTwo) && (noMovesThree) && (noMovesFour)) {
	       		System.out.println("No more moves. Game terminated.");
	       		break;
	       	}
	       	if (checkMovesInGame() == false) {
	       		System.out.println("No more moves. Game terminated.");
	       		break;
	       	}
	       	
	       	count++;
   		}
   		
   		System.out.println("\n\nGame Stats: ");
   		System.out.println("Total rounds = " + count);
   		System.out.println("Player one total: " + addValues(playerOne) + "\t\t\t# in Hand: " + playerOne.size());
	    System.out.println("Player two total: " + addValues(playerTwo) + "\t\t\t# in Hand: " + playerTwo.size());
	    System.out.println("Player three total: " + addValues(playerThree) + "\t\t\t# in Hand: " + playerThree.size());
	    System.out.println("Player four total: " + addValues(playerFour) + "\t\t\t# in Hand: " + playerFour.size());
       
    }
    
    /**
     * This method chooses the starting double by determining the largest double in a player hand. If no players hold doubles, it will then choose the largest double from the undrawn set.
     * 
     * @return The starting double
     */
    public Domino findStartingDouble() {
    	Domino start = new Domino(-1,-1);
    	ArrayList<Domino> tempArr = dominoSet;
    	
    	for (int i = 0; i < playerOne.size(); i++) {
    		Domino check = playerOne.get(i);
    		if (check.isDouble()) {
    			if (check.getLeft() > start.getLeft()) {
    				start = check;
    				tempArr = playerOne;
    			}
    		}
    	}
    	
    	for (int i = 0; i < playerTwo.size(); i++) {
    		Domino check = playerTwo.get(i);
    		if (check.isDouble()) {
    			if (check.getLeft() > start.getLeft()) {
    				start = check;
    				tempArr = playerTwo;
    			}
    		}
    	}
    	
    	if (hasPlayerThree()) {
    		for (int i = 0; i < playerThree.size(); i++) {
        		Domino check = playerThree.get(i);
        		if (check.isDouble()) {
        			if (check.getLeft() > start.getLeft()) {
        				start = check;
        				tempArr = playerThree;
        			}
        		}
        	}
    	}
    	
    	if (hasPlayerFour()) {
    		for (int i = 0; i < playerFour.size(); i++) {
        		Domino check = playerFour.get(i);
        		if (check.isDouble()) {
        			if (check.getLeft() > start.getLeft()) {
        				start = check;
        				tempArr = playerFour;
        			}
        		}
        	}
    	}
    	
    	
    	
    	if (start.getLeft() == -1) {
    		for (int i = 0; i < dominoSet.size(); i++) {
        		Domino check = dominoSet.get((dominoSet.size() - 1) - i);
        		if (check.isDouble()) {
        			if (check.getLeft() > start.getLeft()) {
        				start = check;
        				tempArr = dominoSet;
        				break;
        			}
        		}
        	}
    	}
    	
    	for (int i = 0; i < tempArr.size(); i++) {
    		Domino temp = tempArr.get(i);
    		if (temp == start) {
    			tempArr.remove(i);
    		}
    	}
    	
    	
    	
    	return start;
    }
      
    /**
     * This method checks if there are any moves left in the game, even if there are dominos left. For example, if the tail value is 3 all other 3's have already been played, the game will be terminated.
     * 
     * @return Boolean value determining if there are moves left in the game or not.
     */
    public boolean checkMovesInGame() {
    	Domino tail = gameTrack.get(gameTrack.size() - 1);
    	int tailVal = tail.getRight();
    	
    	for (int i = 0; i < playerOne.size(); i++) {
    		Domino check = playerOne.get(i);
    		if ((check.getLeft() == tailVal) || (check.getRight() == tailVal)) {
    			return true;    			
    		}
    	}
    	
    	for (int i = 0; i < playerTwo.size(); i++) {
    		Domino check = playerTwo.get(i);
    		if ((check.getLeft() == tailVal) || (check.getRight() == tailVal)) {
    			return true;    			
    		}
    	}
    	
    	if (hasPlayerThree()) {
    		for (int i = 0; i < playerThree.size(); i++) {
        		Domino check = playerThree.get(i);
        		if ((check.getLeft() == tailVal) || (check.getRight() == tailVal)) {
        			return true;    			
        		}
        	}
    	}
    	
    	if (hasPlayerFour()) {
    		for (int i = 0; i < playerFour.size(); i++) {
        		Domino check = playerFour.get(i);
        		if ((check.getLeft() == tailVal) || (check.getRight() == tailVal)) {
        			return true;    			
        		}
        	}
    	}
    	
    	for (int i = 0; i < dominoSet.size(); i++) {
    		Domino check = dominoSet.get(i);
    		if ((check.getLeft() == tailVal) || (check.getRight() == tailVal)) {
    			return true;    			
    		}
    	}
    	
    	return false;
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

	


