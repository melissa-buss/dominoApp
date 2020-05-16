
public class Domino {
	int left;
    int right;
    
    public Domino(int a, int b){
        left = a;
        right = b;
    }
    
    public boolean Double(Domino d){
        return left == right;
    }
    
    public String displayDomino(){
        return "|" + left + " - " + right + "|";
    }
    
    public int getLeft(){
        return left;
    }
    
    public int getRight(){
        return right;
    }
    
    public void rotateDomino(){
        int temp = left;
        left = right;
        right = temp;
    }
}
