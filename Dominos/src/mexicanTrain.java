import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * 
 * @author Melissa Buss
 * @version 5.0
 * @since 6/29/20
 *
 */
public class mexicanTrain extends game {
	
	ArrayList<Domino> playerOneTrack;
	ArrayList<Domino> playerTwoTrack;
	ArrayList<Domino> playerThreeTrack;
	ArrayList<Domino> playerFourTrack;
	
	boolean openGameTrack;
	boolean openOne;
	boolean openTwo;
	boolean openThree;
	boolean openFour;
	
	int size;

	/**
	 * Creates the total set of dominos for the game 
	 * 
	 * @param s	The size of the set of dominos
	 */
	public mexicanTrain(int s) {
		super(s);
		size = s;
	}
	
	/** 
	 * Accesses player one's game track
	 * 
	 * @return player one's track
	 */
	public ArrayList<Domino> getPlayerOneTrack(){
		return playerOneTrack;
	}
	
	/**
	 * Adds and/or updates player one's game track
	 * 
	 * @param t Array list being added to player one's game track
	 */
	public void setPlayerOneTrack(ArrayList<Domino> t) {
		this.playerOneTrack = t;
	}
	
	/** 
	 * Accesses player two's game track
	 * 
	 * @return player two's track
	 */
	public ArrayList<Domino> getPlayerTwoTrack(){
		return playerTwoTrack;
	}
	
	/**
	 * Adds and/or updates player two's game track
	 * 
	 * @param t Array list being added to player two's game track
	 */
	public void setPlayerTwoTrack(ArrayList<Domino> t) {
		this.playerTwoTrack = t;
	}
	
	/** 
	 * Accesses player three's game track
	 * 
	 * @return player three's track
	 */
	public ArrayList<Domino> getPlayerThreeTrack(){
		return playerThreeTrack;
	}
	
	/**
	 * Adds and/or updates player three's game track
	 * 
	 * @param t Array list being added to player three's game track
	 */
	public void setPlayerThreeTrack(ArrayList<Domino> t) {
		this.playerThreeTrack = t;
	}
	
	/** 
	 * Accesses player four's game track
	 * 
	 * @return player four's track
	 */
	public ArrayList<Domino> getPlayerFourTrack(){
		return playerFourTrack;
	}
	
	/**
	 * Adds and/or updates player four's game track
	 * 
	 * @param t Array list being added to player four's game track
	 */
	public void setPlayerFourTrack(ArrayList<Domino> t) {
		this.playerFourTrack = t;
	}
	
	/**
	 * Determines if the game's track is open to all users. 
	 * 
	 * @return boolean value determining whether the track is open
	 */
	public boolean getOpenGameTrack() {
		return openGameTrack;
	}
	
	/**
	 * Updates value determining if the game track is open
	 * 
	 * @param b boolean value determining whether the track is open
	 */
	public void setOpenGameTrack(boolean b) {
		openGameTrack = b;
	}
	
	/**
	 * Determines if player one's track is open for other users to play on
	 * 
	 * @return boolean value determining whether the track is open
	 */
	public boolean getOpenOne() {
		return openOne;
	}
	
	/**
	 * Updates value determining if player one's track is open for play
	 * 
	 * @param b boolean value determining whether the track is open
	 */
	public void setOpenOne(boolean b) {
		openOne = b;
	}
	
	/**
	 * Determines if player two's track is open for other users to play on
	 * 
	 * @return boolean value determining whether the track is open
	 */
	public boolean getOpenTwo() {
		return openTwo;
	}
	
	/**
	 * Updates value determining if player two's track is open for play
	 * 
	 * @param b boolean value determining whether the track is open
	 */
	public void setOpenTwo(boolean b) {
		openTwo = b;
	}
	
	/**
	 * Determines if player three's track is open for other users to play on
	 * 
	 * @return boolean value determining whether the track is open
	 */
	public boolean getOpenThree() {
		return openThree;
	}
	
	/**
	 * Updates value determining if player three's track is open for play
	 * 
	 * @param b boolean value determining whether the track is open
	 */
	public void setOpenThree(boolean b) {
		openThree = b;
	}
	
	/**
	 * Determines if player four's track is open for other users to play on
	 * 
	 * @return boolean value determining whether the track is open
	 */
	public boolean getOpenFour() {
		return openFour;
	}
	
	/**
	 * Updates value determining if player four's track is open for play
	 * 
	 * @param b boolean value determining whether the track is open
	 */
	public void setOpenFour(boolean b) {
		openFour = b;
	}
	
	/**
	 * User chooses how many players are in the game. This input is then used to run the game.
	 * 
	 * @return The game after it's played
	 */
	public game chooseNumOfPlayers() {
		int n = 10;
		
		
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
	 * Finds starting double for the round
	 * 
	 * @param n The value of the starting double for the round
	 * @return The starting double
	 */
	public Domino findStartingDouble(int n) {
    	Domino check = new Domino(-1,-1);
    	
    	for (int i = 0; i < dominoSet.size(); i++) {
    		check = dominoSet.get(i);
    		if (check.isDouble() && (check.getRight() == n)) {
    			System.out.println("Starting double played from undrawn pile.");
    			dominoSet.remove(check);
    			return check;
    		}
    	}
    	
    	for (int i = 0; i < playerOne.size(); i++) {
    		check = playerOne.get(i);
    		if (check.isDouble() && (check.getRight() == n)) {
    			System.out.println("Starting double played by player one.");
    			playerOne.remove(check);
    			return check;
    		}
    	}
    	
    	for (int i = 0; i < playerTwo.size(); i++) {
    		check = playerTwo.get(i);
    		if (check.isDouble() && (check.getRight() == n)) {
    			System.out.println("Starting double played by player two.");
    			playerTwo.remove(check);
    			return check;
    		}
    	}
    	
    	for (int i = 0; i < playerThree.size(); i++) {
    		check = playerThree.get(i);
    		if (check.isDouble() && (check.getRight() == n)) {
    			System.out.println("Starting double played by player three.");
    			playerThree.remove(check);
    			return check;
    		}
    	}
    	
    	for (int i = 0; i < playerFour.size(); i++) {
    		check = playerFour.get(i);
    		if (check.isDouble() && (check.getRight() == n)) {
    			System.out.println("Starting double played by player four.");
    			playerFour.remove(check);
    			return check;
    		}
    	}
    	
    	    	
    	return check;
	}
	
	/**
	 * Checks if the player has moves on any open track
	 * 
	 * @param p The player hand being checked
	 * @return boolean value determining if they have moves
	 */
	public boolean hasMoves(ArrayList<Domino> p) {
		Domino tail;
		if (openGameTrack) {
			tail = gameTrack.get(gameTrack.size() - 1);
			for (int i = 0; i < p.size(); i++) {
	    		Domino check = p.get(i);
	    		if ((check.getLeft() == tail.getRight()) || (check.getRight() == tail.getRight())) {
	    			return true;
	    		}
	    	}
		}
		if (openOne) {
			tail = playerOneTrack.get(playerOneTrack.size() - 1);
			for (int i = 0; i < p.size(); i++) {
	    		Domino check = p.get(i);
	    		if ((check.getLeft() == tail.getRight()) || (check.getRight() == tail.getRight())) {
	    			return true;
	    		}
	    	}
		}
		if (openTwo) {
			tail = playerTwoTrack.get(playerTwoTrack.size() - 1);
			for (int i = 0; i < p.size(); i++) {
	    		Domino check = p.get(i);
	    		if ((check.getLeft() == tail.getRight()) || (check.getRight() == tail.getRight())) {
	    			return true;
	    		}
	    	}
		}
		if (openThree) {
			tail = playerThreeTrack.get(playerThreeTrack.size() - 1);
			for (int i = 0; i < p.size(); i++) {
	    		Domino check = p.get(i);
	    		if ((check.getLeft() == tail.getRight()) || (check.getRight() == tail.getRight())) {
	    			return true;
	    		}
	    	}
		}
		if (openFour) {
			tail = playerFourTrack.get(playerFourTrack.size() - 1);
			for (int i = 0; i < p.size(); i++) {
	    		Domino check = p.get(i);
	    		if ((check.getLeft() == tail.getRight()) || (check.getRight() == tail.getRight())) {
	    			return true;
	    		}
	    	}
		}
		
		return false;
	}
	
	/**
	 * Checks if the player has moves on a specific track, used to determine playing track for computer players
	 * 
	 * @param p Player hand being checked
	 * @param n Number representing track being checked
	 * @param np Number of players in the game
	 * @return Boolean value determining if the player has moves on this track
	 */
	public boolean hasMovesOnTrack(ArrayList<Domino> p, int n, int np) {
		ArrayList<Domino> t;
		
		if (n == 0) {
			n = np;
		}
		
		
		if (n == 1) {
			t = playerOneTrack;
		}
		else if (n == 2) {
			t = playerTwoTrack;
		}
		else if (n == 3) {
			t = playerThreeTrack;
		}
		else if (n == 4) {
			t = playerFourTrack;
		}
		else {
			t = gameTrack;
		}
		
		
		Domino tail = t.get(t.size() - 1);
		for (int i = 0; i < p.size(); i++) {
    		Domino check = p.get(i);
    		if ((check.getLeft() == tail.getRight()) || (check.getRight() == tail.getRight())) {
    			return true;
    		}
    	}
		
		return false;
	}
	
	/**
	 * Check moves in the game regardless of the track being open or not, used to determine if there are any moves left in the round (given all tracks are open)
	 * 
	 * @param p Player hand being checked
	 * @return Boolean value representing whether there are moves or not
	 */
	public boolean checkMovesInGame(ArrayList<Domino> p) {
		Domino tail;
		tail = gameTrack.get(gameTrack.size() - 1);
		for (int i = 0; i < p.size(); i++) {
			Domino check = p.get(i);
			if ((check.getLeft() == tail.getRight()) || (check.getRight() == tail.getRight())) {
				return true;
			}
		}
	
		tail = playerOneTrack.get(playerOneTrack.size() - 1);
		for (int i = 0; i < p.size(); i++) {
			Domino check = p.get(i);
			if ((check.getLeft() == tail.getRight()) || (check.getRight() == tail.getRight())) {
				return true;
			}
		}
	
		tail = playerTwoTrack.get(playerTwoTrack.size() - 1);
		for (int i = 0; i < p.size(); i++) {
			Domino check = p.get(i);
			if ((check.getLeft() == tail.getRight()) || (check.getRight() == tail.getRight())) {
				return true;
			}
		}
		
		
		if (hasPlayerThree()) {
			tail = playerThreeTrack.get(playerThreeTrack.size() - 1);
			for (int i = 0; i < p.size(); i++) {
				Domino check = p.get(i);
				if ((check.getLeft() == tail.getRight()) || (check.getRight() == tail.getRight())) {
					return true;
				}
			}
		}
		
		if (hasPlayerFour()) {
			tail = playerFourTrack.get(playerFourTrack.size() - 1);
			for (int i = 0; i < p.size(); i++) {
				Domino check = p.get(i);
				if ((check.getLeft() == tail.getRight()) || (check.getRight() == tail.getRight())) {
					return true;
				}
			}
		}
		
		
		
		return false;
	}

	/**
	 * Allows user input to play the game on this players turn
	 * 
	 * @param p User hand
	 * @param n Number of player, used to temporarily open the track for the player and close for other players
	 * @param np Number of players in the game
	 * @return int value for who the next player is. Used in the case that the play double method is called, and the double is played by a different player, resulting in a different player being next
	 */
	public int userChooseDomino(ArrayList<Domino> p, int n, int np) {
		
		boolean tempOpenVal = true;
		if (n == 1) {
			tempOpenVal = false;
			openOne = true;
		}
		if (n == 2) {
			tempOpenVal = false;
			openTwo = true;
		}
		if (n == 3) {
			tempOpenVal = false;
			openThree = true;
		}
		if (n == 4) {
			tempOpenVal = false;
			openFour = true;
		}
		
		System.out.print("Your dominos: \t");
		printSet(p);
		System.out.println();
		printGame();
		
		if (hasMoves(p)) {
			ArrayList<Domino> track = userChoosePlayingTrack();
    		Domino tail = track.get(track.size() - 1);
    		
    		Scanner chooseDomino = new Scanner(System.in);
    		int chosen;
    		System.out.println("Which domino do you choose?: ");
    		for (int i = 0; i < p.size(); i++) {
    			System.out.println((i+1) + ": " + p.get(i).displayDomino());
    		}
    		chosen = chooseDomino.nextInt();
    		
    		if (chosen > 0 && chosen <= p.size()) {
    			Domino check = p.get(chosen - 1);
    			if (tail.getRight() == check.getRight()) {
        			check.rotateDomino();
        		}
    			if (tail.getRight() == check.getLeft()) {
    				track.add(check);
    	        	p.remove(check);
    	        	if ((check.isDouble()) && (p.size() > 0)) {
    	        		System.out.println("You played a double! Please play another domino.");
    					int temp = playDouble(n, track);
    					n += temp;
    				}
        		}
    			else {
    				System.out.println("This domino cannot be placed here. Please try again.");
    				userChooseDomino(p, n, np);
    			}
    		}
    		else {
    			System.out.println("Invalid input. Please try again");
    			userChooseDomino(p, n, np);
    		}
		}
		else {
			if (dominoSet.isEmpty() == false) {
				draw(p, dominoSet);
	    		Domino newDomino = p.get(p.size()-1);
				System.out.println("You did not have any moves. You just drew the domino " + newDomino.displayDomino());
				System.out.println("Can you play this domino? Enter 0 for NO and 1 for YES: ");
				Scanner playDraw = new Scanner(System.in);
		    	int ans = playDraw.nextInt();
		    	if (ans == 1) {
		    		ArrayList<Domino> track = userChoosePlayingTrack();
		    		Domino tail = track.get(track.size() - 1);
		    		
		    		if (tail.getRight() == newDomino.getRight()) {
		    			newDomino.rotateDomino();
		    		}
					if (tail.getRight() == newDomino.getLeft()) {
						track.add(newDomino);
			        	p.remove(newDomino);
			        	if ((newDomino.isDouble()) && (p.size() > 0)) {
			        		int temp = playDouble(((n+1)%np), track);
	    					n += temp;
	    					tempOpenVal = false;
						}
		    		}
		    	}
		    	else { 
					tempOpenVal = true;
		    	}
			}
			else {
				tempOpenVal = true;
			}
			
		}
		
		if (n == 1) {
			openOne = tempOpenVal;
		}
		if (n == 2) {
			openTwo = tempOpenVal;
		}
		if (n == 3) {
			openThree = tempOpenVal;
		}
		if (n == 4) {
			openFour = tempOpenVal;
		}
		
		int r;
		if ((n + 1) > 4) {
			r = (n+1)%np;
		}
		else {
			r = n+1;
		}
		
		return r;
	}
	
	/**
	 * User chooses which track to play their domino on based on current open tracks
	 * 
	 * @return Track chosen
	 */
	public ArrayList<Domino> userChoosePlayingTrack(){
		System.out.println("Please choose which track you want to play a domino on: ");
		Scanner chooseTrack = new Scanner(System.in);
		int opt = chooseTrack.nextInt();
		switch(opt){
			case 0:
				if (openGameTrack) {
					return gameTrack;
				}
				else {
					userChoosePlayingTrack();
				}
			case 1:
				if (openOne) {
					return playerOneTrack;
				}
				else {
					userChoosePlayingTrack();
				}
			case 2:
				if (openTwo) {
					return playerTwoTrack;
				}
				else {
					userChoosePlayingTrack();
				}
			case 3:
				if (openThree) {
					return playerThreeTrack;
				}
				else {
					userChoosePlayingTrack();
				}
			case 4:
				if (openFour) {
					return playerFourTrack;
				}
				else {
					userChoosePlayingTrack();
				}
			default:
				userChoosePlayingTrack();
		}
		
		return gameTrack;
	}

	/**
	 * User chooses a domino to play on the double. Called via the playDouble method.
	 * 
	 * @param p Player whose turn it is
	 * @param t Track the domino needs to be played on
	 * @return Boolean value representing whether they played or not, used to determine if playDouble continues
	 */
	public boolean userChooseDouble(ArrayList<Domino> p, ArrayList<Domino> t) {
		
		Domino tail = t.get(t.size() - 1);
		Scanner choose = new Scanner(System.in);
		Scanner playDraw = new Scanner(System.in);
		
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
		int chosen = choose.nextInt();
		
		if (chosen == 0) {
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
						t.add(newDomino);
			        	p.remove(newDomino);
			        	return true;
		    		}
					else {
						System.out.println("This domino cannot be placed here.");
						return false;
					}
	    		}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else if (chosen > 0 && chosen <= p.size()) {
			Domino check = p.get(chosen - 1);
			if (tail.getRight() == check.getRight()) {
				check.rotateDomino();
			}
			if (tail.getRight() == check.getLeft()) {
				t.add(check);
	        	p.remove(check);
	        	return true;
			}
			else {
				System.out.println("This domino cannot be placed here. Please try again.");
				userChooseDouble(p, t);
			}
		}
		else {
			System.out.println("Invalid input. Please try again");
			userChooseDouble(p, t);
		}
		
		return false;
	}

	/**
	 * Computer automatically chooses the domino to play and track to play it on. Priority for track choosing goes first to this player, then to the game track, and then to the other players tracks. 
	 * 
	 * @param p Player choosing domino
	 * @param n Player number, used to temporarily open the game track for this player only.
	 * @param np Number of players in the game.
	 * @return int value for who the next player is. Used in the case that the play double method is called, and the double is played by a different player, resulting in a different player being next
	 */
	public int cpChooseDomino(ArrayList<Domino> p, int n, int np) {
		boolean tempOpenVal = true;
		ArrayList<Domino> track;
		if (n == 1) {
			tempOpenVal = false;
			openOne = true;
		}
		if (n == 2) {
			tempOpenVal = false;
			openTwo = true;
		}
		if (n == 3) {
			tempOpenVal = false;
			openThree = true;
		}
		if (n == 4) {
			tempOpenVal = false;
			openFour = true;
		}
		
		
		int tempIndex = 99;
		int largestRight = -1;
		
		if (hasMoves(p)) {
			if (hasMovesOnTrack(p, ((n)%np), np)) {
				track = cpChoosePlayingTrack((n)%np, np);
			}
			else if (hasMovesOnTrack(p, 100, np)) {
				track = cpChoosePlayingTrack(100, np);
			}
			else if (hasMovesOnTrack(p, ((n+1)%np), np)) {
				track = cpChoosePlayingTrack((n+1)%np, np);
			}
			else if (hasMovesOnTrack(p, ((n+2)%np), np)) {
				track = cpChoosePlayingTrack((n+2)%np, np);
			}
			else if (hasMovesOnTrack(p, ((n+3)%np), np)) {
				track = cpChoosePlayingTrack((n+3)%np, np);
			}
			else {
				track = gameTrack;
			}
			
			Domino tail = track.get(track.size() - 1);
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
			
			Domino newDomino = p.get(tempIndex);
	    	track.add(newDomino);
	    	p.remove(newDomino);
	    	if ((newDomino.isDouble()) && (p.size() > 0)) {
	    		int temp = playDouble(n, track);
				n += temp;
			}
		}
		else {
			if (dominoSet.isEmpty() == false) {
				draw(p, dominoSet);
				Domino newDomino = p.get(p.size() - 1);
				
				
				
	    		if (hasMovesOnTrack(p, ((n)%np), np)) {
	    			track = cpChoosePlayingTrack((n)%np, np);
	    		}
	    		else if (hasMovesOnTrack(p, 100, np)) {
	    			track = cpChoosePlayingTrack(100, np);
	    		}
	    		else if (hasMovesOnTrack(p, ((n+1)%np), np)) {
	    			track = cpChoosePlayingTrack((n+1)%np, np);
	    		}
	    		else if (hasMovesOnTrack(p, ((n+2)%np), np)) {
	    			track = cpChoosePlayingTrack((n+2)%np, np);
	    		}
	    		else if (hasMovesOnTrack(p, ((n+3)%np), np)) {
	    			track = cpChoosePlayingTrack((n+3)%np, np);
	    		}
	    		else {
	    			track = gameTrack;
	    		}
	    		
	    		Domino tail = track.get(track.size() - 1);
	    		if (tail.getRight() == newDomino.getRight()) {
	    			newDomino.rotateDomino();
	    		}
	    		if (tail.getRight() == newDomino.getLeft()) {
	    			track.add(newDomino);
	    			p.remove(newDomino);
	    			if ((newDomino.isDouble()) && (p.size() > 0)) {
	    				int temp = playDouble(((n+1)%np), track);
						n += temp;
	    			}
	    		}
	    		else {
	    			tempOpenVal = true;
	    		}
			}
			else {
				tempOpenVal = true;
			}
		}
		
		
		
		
		if (n == 1) {
			openOne = tempOpenVal;
		}
		if (n == 2) {
			openTwo = tempOpenVal;
		}
		if (n == 3) {
			openThree = tempOpenVal;
		}
		if (n == 4) {
			openFour = tempOpenVal;
		}
		
		printGame();
		int r;
		if ((n + 1) > np) {
			r = (n+1)%np;
		}
		else {
			r = n+1;
		}
		
		return r;
		
	}
	
	/**
	 * Returns the track that the computer player will place a domino on.
	 * 
	 * @param n Number of the player track being chosen
	 * @param np Number of players in the game
	 * @return
	 */
	public ArrayList<Domino> cpChoosePlayingTrack(int n, int np) {
		if (n == 0) {
			n = np;
		}
		
		if (n == 1) {
			return playerOneTrack;
		}
		else if (n == 2) {
			return playerTwoTrack;
		}
		else if (n == 3) {
			return playerThreeTrack;
		}
		else if (n == 0) {
			return playerFourTrack;
		}
		else {
			return gameTrack;
		}
	}
	
	/**
	 * Computer chooses a domino to play on the double. Called via the playDouble method.
	 * 
	 * @param p Player whose turn it is
	 * @param t Track the domino needs to be played on
	 * @return Boolean value representing whether they played or not, used to determine if playDouble continues
	 */
	public boolean cpChooseDouble(ArrayList<Domino> p, ArrayList<Domino> t) {
		Domino tail = t.get(t.size() - 1);
		
		int tempIndex = 99;
		int largestRight = -1;
		
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
			if (dominoSet.isEmpty() == false){
				draw(p, dominoSet);
				Domino newDomino = p.get(p.size() - 1);
	    		if (tail.getRight() == newDomino.getRight()) {
	    			newDomino.rotateDomino();
	    		}
	    		else if (tail.getRight() == newDomino.getLeft()) {
	    			t.add(newDomino);
	    			p.remove(newDomino);
	    			return true;
	    		}
	    		else {
	    			return false;
	    		}
			}
			else {
				return false;
			}
		}
		else {
			Domino newDomino = p.get(tempIndex);
			t.add(newDomino);
			p.remove(newDomino);
			return true;
		}
		
		return false;
		
	}

	/**
	 * Separate method called when a double is played. This closes all game tracks except the one the double was played on until a domino can follow the double. It then returns the game tracks open/closed value back to what it was prior.
	 * 
	 * @param n Number representing which player's turn is first
	 * @param t Track the double is on
	 * @return
	 */
	public int playDouble(int n, ArrayList<Domino> t) {
		boolean tempOpenGameTrack = openGameTrack;
		boolean tempOpenOne = openOne;
		boolean tempOpenTwo = openTwo;
		
		openGameTrack = false;
		openOne = false;
		openTwo = false;
		
		int temp = 0;
		
		if (t == playerOneTrack) {
			openOne = true;
		}
		else if (t == playerTwoTrack) {
			openTwo = true;
		}
		else if (t == playerThreeTrack) {
			openThree = true;			
		}
		else if (t == playerFourTrack) {
			openFour = true;
		}
		else {
			openGameTrack = true;
		}
		
		
		if (hasPlayerThree() == false) {
			ArrayList<Domino> turn1;
			ArrayList<Domino> turn2;
			
			boolean turn1User = false;
			boolean turn2User = false; 
			
			if (n == 1) {
				turn1 = playerOne;
				turn2 = playerTwo;
				turn1User = true;
			}
			else {
				turn1 = playerTwo;
				turn2 = playerOne;
				turn2User = true;
			}
			
			boolean doublePlayed = false;
			while (doublePlayed == false) {
				if (turn1User) {
					printGame();
					doublePlayed = userChooseDouble(turn1, t);
					if (doublePlayed == true) {
						temp = 0;
						break;
					}
				}
				else {
					doublePlayed = cpChooseDouble(turn1, t);
					if (doublePlayed == true) {
						temp = 0;
						break;
					}
				}
				
				
				if (turn2User) {
					printGame();
					doublePlayed = userChooseDouble(turn2, t);
					if (doublePlayed == true) {
						temp = 1;
						break;
					}
				}
				else {
					doublePlayed = cpChooseDouble(turn2, t);
					if (doublePlayed == true) {
						temp = 1;
						break;
					}
				}
				
				
			}
		}
		else if (hasPlayerThree() && hasPlayerFour() == false) {
			boolean tempOpenThree = openThree;

			openThree = false;
						
			ArrayList<Domino> turn1;
			ArrayList<Domino> turn2;
			ArrayList<Domino> turn3;
			
			boolean turn1User = false;
			boolean turn2User = false; 
			boolean turn3User = false;
			
			if (n == 1) {
				turn1 = playerOne;
				turn2 = playerTwo;
				turn3 = playerThree;
				turn1User = true;
			}
			else if (n == 2) {
				turn1 = playerTwo;
				turn2 = playerThree;
				turn3 = playerOne;
				turn3User = true;
			}
			else {
				turn1 = playerThree;
				turn2 = playerOne;
				turn3 = playerTwo;
				turn2User = true;
			}
			
			boolean doublePlayed = false;
			while (doublePlayed == false) {
				if (turn1User) {
					printGame();
					doublePlayed = userChooseDouble(turn1, t);
					if (doublePlayed == true) {
						temp = 0;
						break;
					}
				}
				else {
					doublePlayed = cpChooseDouble(turn1, t);
					if (doublePlayed == true) {
						temp = 0;
						break;
					}
				}
				
				
				if (turn2User) {
					printGame();
					doublePlayed = userChooseDouble(turn2, t);
					if (doublePlayed == true) {
						temp = 1;
						break;
					}
				}
				else {
					doublePlayed = cpChooseDouble(turn2, t);
					if (doublePlayed == true) {
						temp = 1;
						break;
					}
				}
				
				
				if (turn3User) {
					printGame();
					doublePlayed = userChooseDouble(turn3, t);
					if (doublePlayed == true) {
						temp = 2;
						break;
					}
				}
				else {
					doublePlayed = cpChooseDouble(turn3, t);
					if (doublePlayed == true) {
						temp = 2;
						break;
					}
				}
				
			}
			
			openThree = tempOpenThree;
		}
		else {
			boolean tempOpenThree = openThree;
			boolean tempOpenFour = openFour;
			
			openThree = false;
			openFour = false;
			
			ArrayList<Domino> turn1;
			ArrayList<Domino> turn2;
			ArrayList<Domino> turn3;
			ArrayList<Domino> turn4;
			
			boolean turn1User = false;
			boolean turn2User = false; 
			boolean turn3User = false;
			boolean turn4User = false;
			
			if (n == 1) {
				turn1 = playerOne;
				turn2 = playerTwo;
				turn3 = playerThree;
				turn4 = playerFour;
				turn1User = true;
			}
			else if (n == 2) {
				turn1 = playerTwo;
				turn2 = playerThree;
				turn3 = playerFour;
				turn4 = playerOne;
				turn4User = true;
			}
			else if (n == 3) {
				turn1 = playerThree;
				turn2 = playerFour;
				turn3 = playerOne;
				turn4 = playerTwo;
				turn3User = true;
			}
			else {
				turn1 = playerFour;
				turn2 = playerOne;
				turn3 = playerTwo;
				turn4 = playerThree;
				turn2User = true;
			}
			
			boolean doublePlayed = false;
			while (doublePlayed == false) {
				if (turn1User) {
					printGame();
					doublePlayed = userChooseDouble(turn1, t);
					if (doublePlayed == true) {
						temp = 0;
						break;
					}
				}
				else {
					doublePlayed = cpChooseDouble(turn1, t);
					if (doublePlayed == true) {
						temp = 0;
						break;
					}
				}
				
				
				if (turn2User) {
					printGame();
					doublePlayed = userChooseDouble(turn2, t);
					if (doublePlayed == true) {
						temp = 1;
						break;
					}
				}
				else {
					doublePlayed = cpChooseDouble(turn2, t);
					if (doublePlayed == true) {
						temp = 1;
						break;
					}
				}
				
				
				if (turn3User) {
					printGame();
					doublePlayed = userChooseDouble(turn3, t);
					if (doublePlayed == true) {
						temp = 2;
						break;
					}
				}
				else {
					doublePlayed = cpChooseDouble(turn3, t);
					if (doublePlayed == true) {
						temp = 2;
						break;
					}
				}
				
				if (turn4User) {
					printGame();
					doublePlayed = userChooseDouble(turn4, t);
					if (doublePlayed == true) {
						temp = 3;
						break;
					}
				}
				else {
					doublePlayed = cpChooseDouble(turn4, t);
					if (doublePlayed == true) {
						temp = 3;
						break;
					}
				}
			}
			
			openThree = tempOpenThree;
			openFour = tempOpenFour;
		}
		
		
		openOne = tempOpenOne;
		openTwo = tempOpenTwo;
		openGameTrack = tempOpenGameTrack;
		return temp;
	}
	
	/**
	 * This method runs a game of mexican train dominos involving one user and one computer player
	 * 
	 */
	public void twoPlayers() {
		gameTrack = new ArrayList<Domino>();
		playerOneTrack = new ArrayList<Domino>();
		playerTwoTrack = new ArrayList<Domino>();
		
		for (int i = 0; i <= size; i++) {

			openGameTrack = true;
			openOne = false;
			openTwo = false;
			
			gameTrack.add(findStartingDouble(size - i));
			playerOneTrack.add(gameTrack.get(0));
			playerTwoTrack.add(gameTrack.get(0));
			
			int n = 1;
			while ((playerOne.size() > 0) && (playerTwo.size() > 0)) {

				if (n == 1) {
					System.out.println("Player 1: ");
					n = userChooseDomino(playerOne, 1, 2);
				}
				if (n == 2) {
					System.out.println("Player 2: ");
			       	n = cpChooseDomino(playerTwo, 2, 2);
				}
		       	
		       	
		       	if ((checkMovesInGame(playerOne) == false) && (checkMovesInGame(playerTwo) == false)) {
		       		System.out.print("No more moves. ");
		       		break;
		       	}
		       	
			}
			
			resetVariables();
			
			
			System.out.println("Next round starting now.");
			
		}
		
	}
	
	/**
	 * This method runs a game of mexican train dominos involving one user and two computer players
	 * 
	 */
	public void threePlayers() {
		gameTrack = new ArrayList<Domino>();
		playerOneTrack = new ArrayList<Domino>();
		playerTwoTrack = new ArrayList<Domino>();
		playerThreeTrack = new ArrayList<Domino>();
		
		for (int i = 0; i <= size; i++) {

			openGameTrack = true;
			openOne = false;
			openTwo = false;
			openThree = false;
			
			gameTrack.add(findStartingDouble(size - i));
			playerOneTrack.add(gameTrack.get(0));
			playerTwoTrack.add(gameTrack.get(0));
			playerThreeTrack.add(gameTrack.get(0));
			
			int n = 1;
			while ((playerOne.size() > 0) && (playerTwo.size() > 0) && (playerThree.size() > 0)) {

				if (n == 1) {
					System.out.println("Player 1: ");
					n = userChooseDomino(playerOne, 1, 3);
				}
				if (n == 2) {
					System.out.println("Player 2: ");
			       	n = cpChooseDomino(playerTwo, 2, 3);
				}
				if (n == 3) {
					System.out.println("Player 3: ");
			       	n = cpChooseDomino(playerThree, 3, 3);
				}
				
		       	
		       	
		       	if ((checkMovesInGame(playerOne) == false) && (checkMovesInGame(playerTwo) == false) && (checkMovesInGame(playerThree) == false)) {
		       		System.out.print("No more moves. ");
		       		break;
		       	}
		       	
			}
			
			resetVariables();
			
			
			System.out.println("Next round starting now.");
			
		}
		
	}
	
	/**
	 * This method runs a game of mexican train dominos involving one user and three computer players
	 * 
	 */
	public void fourPlayers() {
		gameTrack = new ArrayList<Domino>();
		playerOneTrack = new ArrayList<Domino>();
		playerTwoTrack = new ArrayList<Domino>();
		playerThreeTrack = new ArrayList<Domino>();
		playerFourTrack = new ArrayList<Domino>();
		
		for (int i = 0; i <= size; i++) {

			openGameTrack = true;
			openOne = false;
			openTwo = false;
			openThree = false;
			openFour = false;
			
			gameTrack.add(findStartingDouble(size - i));
			playerOneTrack.add(gameTrack.get(0));
			playerTwoTrack.add(gameTrack.get(0));
			playerThreeTrack.add(gameTrack.get(0));
			playerFourTrack.add(gameTrack.get(0));
			
			int n = 1;
			while ((playerOne.size() > 0) && (playerTwo.size() > 0) && (playerThree.size() > 0) && (playerFour.size() > 0)) {

				if (n == 1) {
					System.out.println("Player 1: ");
					n = userChooseDomino(playerOne, 1, 4);
				}
				if (n == 2) {
					System.out.println("Player 2: ");
			       	n = cpChooseDomino(playerTwo, 2, 4);
				}
				if (n == 3) {
					System.out.println("Player 3: ");
			       	n = cpChooseDomino(playerThree, 3, 4);
				}
				if (n == 4) {
			       	System.out.println("Player 4: ");
			       	n = cpChooseDomino(playerFour, 4, 4);
				}
				
		       	
		       	
		       	if ((checkMovesInGame(playerOne) == false) && (checkMovesInGame(playerTwo) == false) && (checkMovesInGame(playerThree) == false) && (checkMovesInGame(playerFour) == false)) {
		       		System.out.print("No more moves. ");
		       		break;
		       	}
		       	
			}
			
			resetVariables();
			
			
			System.out.println("Next round starting now.");
			
		}
		
	}
	
	/**
	 * This method prints the last five dominos on each game track and whether it is open or not
	 * 
	 */
	public void printGame() {
		System.out.print("0: ");
	   	printLastFive(gameTrack);
	   	if (openGameTrack) {
	   		System.out.print("| OPEN | ");
	   	}
	   	System.out.println();
	   	
	   	System.out.print("1: ");
	   	printLastFive(playerOneTrack);
	   	if (openOne) {
	   		System.out.print("| OPEN |");
	   	}
	   	System.out.println();
	   	
	   	System.out.print("2: ");
	   	printLastFive(playerTwoTrack);
	   	if (openTwo) {
	   		System.out.print("| OPEN |");
	   	}
	   	System.out.println();
	   	
	   	if(hasPlayerThree()) {
	       	System.out.print("3: ");
	       	printLastFive(playerThreeTrack);
	       	if (openThree) {
	       		System.out.print("| OPEN |");
	       	}
	       	System.out.println();
	   	}
	   	
	   	if(hasPlayerFour()) {
	       	System.out.print("4: ");
	       	printLastFive(playerFourTrack);
	       	if (openFour) {
	       		System.out.print("| OPEN |");
	       	}
	       	System.out.println();
	   	}
	}

	/**
	 * This method resets the game tracks, player hands, and domino sets between rounds
	 * 
	 */
	public void resetVariables() {
		dominoSet.clear();
		gameTrack.clear();
		createDominoSet(size);
		
		playerOneTrack.clear();
		playerTwoTrack.clear();
		playerOne = createPlayerHand(10, dominoSet);
		playerTwo = createPlayerHand(10, dominoSet);
		
		
		if (hasPlayerThree()) {
			playerThreeTrack.clear();
			playerThree = createPlayerHand(10, dominoSet);
		}
		if (hasPlayerFour()) {
			playerFourTrack.clear();		
			playerFour = createPlayerHand(10, dominoSet);
		}
		
	}
	

}
