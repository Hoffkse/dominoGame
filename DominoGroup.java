import java.util.Random;
public class DominoGroup {

	private  Domino[] dominosArray;
	private int numDominoes;
	

    public DominoGroup() {
    	this.numDominoes = 0;
    	this.dominosArray = new Domino [28];
    }
    
    public void setNumDominoes(int n)
    {
    	this.numDominoes = n;
    }
    public int getNumDominos()
    {
    	return this.numDominoes;
    }
    
    public Domino getDomino(int i)
    {
    	return this.dominosArray[i];
    }
    
    public void setDomino(int num, Domino d)
    {
    	this.dominosArray[num] = d;
    }
    
    public void makeDominoSet()
    {
    	int counter = 1;
  		
  		//Domino d = new Domino(0,0);
  		//this.setDomino(0, d);
  		//this.setNumDominoes(counter);
    	
    	for (int i = 0; i <=6; i++)
    	{
    		for (int j = 0; j <= i; j++)
    		{
    			Domino holder;
    			holder = new Domino(i, j);
    			this.setDomino(this.numDominoes, holder);
    			this.setNumDominoes(counter);
    			counter = counter + 1;
    		}
    	}
    }
	public void mix()
	{
		Random rnd = new Random();
		for (int i = this.numDominoes - 1; i > 0; i--)
		{
			int k = rnd.nextInt(i);
			Domino holder;
			holder = new Domino(this.dominosArray[k]);
			this.setDomino(k, this.dominosArray[i]);
			this.setDomino(i, holder);
		}
	}

    public void addDominoFront (Domino d)
    {
    	for (int i = this.numDominoes - 1 ; i >= 0; i--)
    	{
    		this.setDomino(i+1, this.getDomino(i));
    	}
    	
    	this.setDomino(0, d);
    	this.setNumDominoes(this.numDominoes + 1);
    	
    }
    public void addDominoBack (Domino d)
    {
    	this.setDomino(this.numDominoes, d);
    	this.setNumDominoes((this.numDominoes + 1));
    }
    public Domino removeDomino(int i)
    {
    	Domino d;
    	d = new Domino(this.dominosArray[i]);
     	for (int k = i; k < this.numDominoes - 1; k++)
        {
            this.setDomino(k,this.dominosArray[k+1]);
        }
        this.setNumDominoes(this.numDominoes - 1); 
        return d; 
    }
    public String toString()
    {
    	String dominoString = "";
    	for (int i = 0; i <= (this.getNumDominos() - 1); i++)
    	{
    		Domino holder;
    		holder = new Domino(this.getDomino(i));
    		dominoString = dominoString + holder.toString();
    	}
    	return dominoString;
    	
    }
    
    
 
    	
    
    
}