import java.util.ArrayList;

/**
 * 
 * 
 * @author Melissa Buss
 * @version 4.1
 * @since 5/29/20
 *
 */
public class mexicanTrain extends game {
	
	ArrayList<Domino> playerOneTrack;
	ArrayList<Domino> playerTwoTrack;
	ArrayList<Domino> playerThreeTrack;
	ArrayList<Domino> playerFourTrack;
	
	boolean openOne;
	boolean openTwo;
	boolean openThree;
	boolean openFour;

	/**
	 * Creates the total set of dominos for the game 
	 * 
	 * @param s	The size of the set of dominos
	 */
	public mexicanTrain(int s) {
		super(s);
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
	
	
	
	

}
