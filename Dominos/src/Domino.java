/**
 * 
 * 
 * @author Melissa Buss
 * @version 5.0
 * @since 6/29/20
 *
 */
public class Domino {
	int left;
    int right;
    
    /**
     * Creates the domino
     * 
     * @param a 	Left side of the domino
     * @param b		Right side of the domino
     */
    public Domino(int a, int b){
        left = a;
        right = b;
    }
    
    /**
     * Displays the domino in a readable format
     * 
     * @return	A string containing the contents of the domino
     */
    public String displayDomino(){
        return "|" + left + " - " + right + "|";
    }
    
    /**
     * Accesses the left side of the domino
     * 
     * @return	The value of the left side of the domino
     */
    public int getLeft(){
        return left;
    }
    
    /**
     * Accesses the right side of the domino
     * 
     * @return 	The value of the right side of the domino
     */
    public int getRight(){
        return right;
    }
    
    /**
     * Checks if the domino is a double
     * 
     * @return 	boolean value determining if the domino is a double (left and right have the same value)
     */
    public boolean isDouble() {
    	if (this.getLeft() == this.getRight()){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    /**
     * Switches left and right side of domino for gameplay.
     */
    public void rotateDomino(){
        int temp = left;
        left = right;
        right = temp;
    }
}
