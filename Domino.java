
public class Domino 
{
	private int num1, num2;
    
    public Domino(int n, int j) {
    	this.setNum1(n);
    	this.setNum2(j);  
    	
    }
    public Domino (Domino d)
    {
    	this.setNum1(d.num1);
    	this.setNum2(d.num2);
    }
    public int getNum1()
    {
    	return this.num1;
    }
    public int getNum2()
    {
    	return this.num2;
    }
    public void setNum1(int n)
    {
    	this.num1 = n;
    }
    public void setNum2(int n)
    {
    	this.num2 = n;
    }
    public String toString()
    {
    	return String.format("[" + this.num1 + "|" + this.num2 + "]");
    }
    
    public Boolean equals(Domino d)
    {
        Domino c = (Domino) d;

        return Integer.compare(num1, c.num1) == 0 || Integer.compare(num1, c.num2) == 0 || Integer.compare(num2, c.num1) == 0 || Integer.compare(num2, c.num2) == 0;
    }
    
    public void swapNumbers()
    { 
    	int holder;
   
    	holder = this.num1;
    	this.num1 = this.num2;
    	this.num2 = holder;
    
    }
    public int getValue()
    {
    	int total;
    	total = this.num1 + this.num2;
    	return total;
    }
    
    
    
}