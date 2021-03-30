package Mine;

public class Calc
	{
	public Calc() 
		{
		
		}
	public int number(char a)
		{
		return Character.getNumericValue(a);
		}	
	
	public int add(int a, int b)
		{return a+b;}
		
	public int multiply(int a, int b)
		{return a*b;}
		
	public int divide(int a, int b)
		{
		if(b == 0)
			{
			//throw new IllegalArgumentException();
			System.out.println("B is 0, this is bad");
			return a;
			}
		return a/b;
		}
		
	public int factorial(int a)
		{
		int counter = 1;
		for(; a > 0; a--)
			{
			counter *= a;
			}
		return counter;
		}
		
	public static void main(String arge[])
		{
		Calc c2 = new Calc();
		System.out.println(c2.number('E'));
		System.out.println(c2.factorial(5));
		}
	}
