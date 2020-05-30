import java.util.Scanner;

/**
 * 
 * 
 * @author Melissa Buss
 * @version 4.1
 * @since 5/29/20
 *
 */
public class main {

	
	
	public static void main(String[] args) {
		
		runGame();
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
	 * Runs game based on user input determining which game to play
	 * 
	 * @return Game object after it's played containing all updated components
	 */
	public static game runGame() {
		int size = setSize();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Which game option would you like to play? \n1. Basic Dominos \t\t\t 2. Mexican Train");
		int opt = sc.nextInt();
		
		
		game e = new game(0);
		switch(opt){
        	case 1:
        		basicGame g = new basicGame(size);
        		g.chooseNumOfPlayers();
        		return g;
        	case 2:
        		System.out.println("Coming soon!");
        		return e;
        	default:
        		System.out.println("Invalid. Ending now.");
        		return e;
        			
		}
		
		
	}
	
}
		
    