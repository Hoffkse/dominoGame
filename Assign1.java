
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Assign1 {

    public static void main (String [] args)
   	{
   		int entry = 0;
   		int count = 0;
   		int choice = 0;
   		int cpuStatus = 0;
    	DominoGroup pool;
    	DominoGroup user;
    	DominoGroup cpu;
    	DominoGroup played;
    	
    	user = new DominoGroup();
    	cpu = new DominoGroup();
    	pool = new DominoGroup();
    	played = new DominoGroup();
    	
    	pool.makeDominoSet();
    	pool.mix();
    	
    	
    	for (int i = 0; i <=6; i++)
    	{
    		user.setDomino(i, pool.getDomino(i));
    		user.setNumDominoes(user.getNumDominos() + 1);
    		pool.removeDomino(i);
    		
    	}
    	
    	for (int i = 0; i <= 6; i++)
    	{
    		cpu.setDomino(i, pool.getDomino(i));
    		cpu.setNumDominoes(cpu.getNumDominos() + 1);
    		pool.removeDomino(i);
    	}
    		
    		
    		
    	System.out.println(pool.toString() + System.lineSeparator());	
    	System.out.println(user.toString() + System.lineSeparator());
    	System.out.println(cpu.toString() + System.lineSeparator());
    	
    while (count < 100)
    {
    	entry = 0;
    	
    	if (user.getNumDominos() == 0){
				JOptionPane.showMessageDialog(null, "WIN");
				System.exit(0);
		}
    	
    	String userDominos = "";
    	String finalString = "" + System.lineSeparator() + System.lineSeparator() + System.lineSeparator() + System.lineSeparator() + System.lineSeparator() + "Pick a domino to play:" + System.lineSeparator();
    	String playedDominoString = "";
    	
    	
    	
    	for (int i = 0; i <= user.getNumDominos()-1; i++)
    	{
  
    		userDominos = userDominos + (i + 1) + " " + user.getDomino(i)+ System.lineSeparator();
    		
    	}
    	finalString =  finalString + userDominos + System.lineSeparator() + "Or..No Moves - Take a domino - Type pass" + System.lineSeparator();
		
		String ans = JOptionPane.showInputDialog(played.toString() + finalString);
		if (ans.equals("pass"))
		{
			System.out.println("fgdfgdfgdfg");
		}
		else
		{
			choice = Integer.parseInt(ans);
		}
    	
    	
    	
    	if (ans.equals("pass") )
    	{
    		System.out.print("HI");
    		if (pool.getNumDominos() > 0)
    		{
    			Domino d = new Domino(pool.removeDomino(0));
    			user.addDominoBack(d);
    			System.out.println(user.toString());
    			entry = 1;
    		}
    	}
    	
    	
    	if (count == 0 && entry != 1 )
    	{
    		played.setDomino(played.getNumDominos(), user.getDomino(choice - 1));
  			played.setNumDominoes(played.getNumDominos() + 1);
     		user.removeDomino(choice - 1);
     		System.out.println(user.toString());
    	}
    	
    	if (count >= 1 && entry != 1)
    	{
    		Domino d2;
    		d2 = new Domino(user.getDomino(choice - 1));
    		String position = JOptionPane.showInputDialog("Pick a position to play the domino: " + System.lineSeparator() + "1. Left" + System.lineSeparator() + "2.Right");
    		int pos = Integer.parseInt(position);
    	
    		if (pos == 1)
    		{
    			Domino first;
    			first = new Domino(played.getDomino(0));
    			if (first.equals(d2))
    			{		
    				if (first.getNum1() == (d2.getNum1()) || first.getNum1() == (d2.getNum2()))
    				{	

    					if (first.getNum1() == d2.getNum1())
    					{
    						d2.swapNumbers();
    					}
    					played.addDominoFront(d2);
    					user.removeDomino(choice - 1); 	
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(null, "You have no turn");	
    				}
    			}
    		}
    		else if(pos == 2)
    		{
    			Domino last;
    			last = new Domino(played.getDomino(played.getNumDominos() - 1));
    			if(last.equals(d2))
    			{
    				if(last.getNum2() == (d2.getNum1()) ||last.getNum2() == (d2.getNum2()))
    				{
    					if(last.getNum2() == d2.getNum2())
    					{
    						d2.swapNumbers();
    					}
    					played.addDominoBack(d2);
    					user.removeDomino(choice - 1);
    					
    				}
    				else
    				{
    					JOptionPane.showMessageDialog(null, "You have no turn");
    				}
    			}
    		}
    			
    	}
    		
    	
    	int num1 = played.getDomino(0).getNum1();
    	int num2 = played.getDomino(played.getNumDominos() - 1).getNum2();
    	cpuStatus = 0;
    	for(int i =0; i < cpu.getNumDominos();i++)
    	{
    		if(num1 == cpu.getDomino(i).getNum2())
    		{
    			Domino s;
    			s = new Domino(cpu.removeDomino(i));
    			played.addDominoFront(s);
    			JOptionPane.showMessageDialog(null, "CPU has played a domino at the front");
    			cpuStatus = 1;
    			break;
    		}
    		if(num1 == cpu.getDomino(i).getNum1())
    		{
    			Domino s;
    			s = new Domino(cpu.removeDomino(i));
    			s.swapNumbers();
    			played.addDominoFront(s);
    			JOptionPane.showMessageDialog(null, "CPU has played a domino at the front");
    			cpuStatus = 1;
    			break;
    		}
    		if(num2 == cpu.getDomino(i).getNum1())
    		{
    			Domino s;
    			s = new Domino(cpu.removeDomino(i));
    			played.addDominoBack(s);
    			JOptionPane.showMessageDialog(null, "CPU has played a domino at the back");
    			cpuStatus = 1;
    			break;
    		}
    		if(num2 == cpu.getDomino(i).getNum2())
    		{
    			Domino s;
    			s = new Domino(cpu.removeDomino(i));
    			s.swapNumbers();
    			played.addDominoBack(s);
    			JOptionPane.showMessageDialog(null, "CPU has played a domino at the back");
    			cpuStatus = 1;
    			break;
    		}
    		
    	}
    	if(cpuStatus == 0)
    	{
    		if(pool.getNumDominos() > 0)
    		{
    			Domino s;
    			s = new Domino(pool.removeDomino(0));
    			cpu.addDominoBack(s);
    			JOptionPane.showMessageDialog(null, "CPU PASSED");
    			
    		}
    	}
    	if (cpu.getNumDominos() == 0){
				JOptionPane.showMessageDialog(null, "CPU HAS WON");
				System.exit(0);
			}
		
    	
    	if (pool.getNumDominos() == 0)
    	{
    		JOptionPane.showMessageDialog(null, "The Game has concluded to a draw.");
			System.exit(0);
    	}
    	
    		
    		count++;
     	
     	finalString = "";	
    }
   
   	}
    
    	
    	
 	
     	
    	
    	
    		
    		
    		
    		
    }
    /*
    for(int i = 0; i < comHand.getNumDominoes(); i++){
		userscore = userscore + comHand.getDomino(i).getValue();
	}
	
	for (int i = 0; i < userHand.getNumDominoes(); i++){
		comscore = comscore + userHand.getDomino(i).getValue();
	}
	
	if (comscore > userscore){
		JOptionPane.showMessageDialog(null, "The computer won by a score of " + comscore + " to " + userscore + ".\n Please Play Again!");
		System.exit(0);
	}
	
	if (userscore > comscore){
		JOptionPane.showMessageDialog(null, "You won by a score of " + userscore + " to " + comscore + ".\n Please Play Again!");
		System.exit(0);
	}
	
	if (userscore == comscore){
		JOptionPane.showMessageDialog(null, "You tied.\n Please Play Again!");
		System.exit(0);
	}
    */
    
	
