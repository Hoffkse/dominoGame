public class DominoTest {

    public static void main (String [] args)
    {
    	DominoGroup grp;
    	DominoGroup hold;
    	hold = new DominoGroup();
    	grp = new DominoGroup();
    	grp.makeDominoSet();
    	System.out.println("MIXED Set");
    	grp.mix();
    	System.out.print(grp.toString());
    	System.out.println("------------------------------------------------------");
    	System.out.println("REMOVED domino");
   		Domino t = new Domino (grp.removeDomino(9));
    	System.out.print(grp.toString());
    	System.out.println("     ------------------------------------------------------");
    	System.out.println("SWAPPED domino + VALUE");
    	t.swapNumbers();
    	System.out.print(t.toString() + System.lineSeparator());
 
    	System.out.println("The value is: " + t.getValue());
    	System.out.println("------------------------------------------------------");
    	System.out.println("The REMOVED domino added to the front");
    	grp.addDominoBack(t);
    	System.out.print(grp.toString());
    	
    	

    
    	
    }
    
    
}