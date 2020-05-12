import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class main {

	
	
	public static void main(String[] args) {
        ArrayList<Domino> doubleTwelve = new ArrayList<>();
        
        /** CREATE DOMINO SET AND SHUFFLE **/
        for (int i = 0; i <= 12; i++){
            for (int j= i; j <= 12; j++){
                doubleTwelve.add(new Domino(i, j));
            }
        }
               
        
        /** CREATE PLAYER HANDS & DRAW **/
        ArrayList<Domino> playerOne = new ArrayList<>();
        ArrayList<Domino> playerTwo = new ArrayList<>();
        ArrayList<Domino> playerThree = new ArrayList<>();
        ArrayList<Domino> playerFour = new ArrayList<>();
        
        Random rand = new Random();
        int i = 0;
        int randomIndex;
        while (i < 7){
            randomIndex = rand.nextInt(doubleTwelve.size());
            playerOne.add(doubleTwelve.get(randomIndex));
            doubleTwelve.remove(randomIndex);
            
            randomIndex = rand.nextInt(doubleTwelve.size());
            playerTwo.add(doubleTwelve.get(randomIndex));
            doubleTwelve.remove(randomIndex);
            
            randomIndex = rand.nextInt(doubleTwelve.size());
            playerThree.add(doubleTwelve.get(randomIndex));
            doubleTwelve.remove(randomIndex);
            
            randomIndex = rand.nextInt(doubleTwelve.size());
            playerFour.add(doubleTwelve.get(randomIndex));    
            doubleTwelve.remove(randomIndex);
            
            i++;
        }
        
        /* PRINTS EACH PLAYERS HAND */
        System.out.println("\nPlayer One: ");
        for (i = 0; i < playerOne.size(); i++){
            System.out.println(playerOne.get(i).displayDomino());
        }
        
        System.out.println("\nPlayer Two: ");
        for (i = 0; i < playerTwo.size(); i++){
            System.out.println(playerTwo.get(i).displayDomino());
        }
        
        System.out.println("\nPlayer Three: ");
        for (i = 0; i < playerThree.size(); i++){
            System.out.println(playerThree.get(i).displayDomino());
        }
        
        System.out.println("\nPlayer Four: ");
        for (i = 0; i < playerFour.size(); i++){
            System.out.println(playerFour.get(i).displayDomino());
        }
        
        System.out.println("\nEntire Set: ");
        for (i = 0; i < doubleTwelve.size(); i++){
            System.out.println(doubleTwelve.get(i).displayDomino());
        }
        
        
        
    }
    
        
    /*public static Domino playDomino(List<Domino> player){
        
        Domino chosen;
        
        if (chosen.getLeft() = chosen.getRight()){
            playDomino(player);
        }
        else{
            
        }
        
    }*/

}
