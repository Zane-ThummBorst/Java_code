package Mine;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcTest
	{
	Calc c1 = new Calc();
	
	@Test
	public void test()
		{
		assertEquals(c1.add(5, 2), 7);
		}
		
	@Test
	public void test2()
		{
		//Assert.
		assertEquals(c1.multiply(5, 2), 10);
		}
		
	@SuppressWarnings("deprecation")
	@Test
	public void test3()
		{
		assertEquals(c1.divide(5, 2), 3);
		}
		
	@Test
	public void daniel()
		{
		assertEquals(c1.divide(5, 2), 2);
		}

	}
