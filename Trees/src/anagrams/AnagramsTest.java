package anagrams;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;
public class AnagramsTest {
	@Test
	void test1(){
		Anagrams a = new Anagrams();
		String s = "{a=2, b=3, c=5, d=7, e=11, "
				+ "f=13, g=17, h=19, i=23, j=29, "
				+ "k=31, l=37, m=41, n=43, o=47, "
				+ "p=53, q=59, r=61, s=67, t=71, "
				+ "u=73, v=79, w=83, x=89, y=97, z=101}";

		System.out.println(a.letterTable.toString());
		assertEquals(a.letterTable.toString(),s);
		System.out.println("END OF TEST1");
		System.out.println();
	}
	@Test
	void test2() {
		Anagrams a = new Anagrams();
		a.addWord("alerts");
		a.addWord("alters");
		a.addWord("khakistans");
		a.addWord("khakistasn");
		a.addWord("khakistsan");
		a.addWord("a");
		
		assertEquals(a.myhashcode("a"), 2);
		assertEquals(a.myhashcode("alerts"), 236204078);
		
		ArrayList l =new ArrayList<String>();
		l.add("alerts");
		l.add("alters");
		long x = 236204078;
		assertEquals(a.anagramTable.get(x), l);
		
		ArrayList l2 =new ArrayList<String>();
		l2.add("a");
		x = 2;
		assertEquals(a.anagramTable.get(x), l2);
		
		System.out.println(a.anagramTable.toString());
		System.out.println("END OF TEST2");
		System.out.println();
	}
	
	@Test
	void test3() {
		Anagrams a = new Anagrams();
		a.addWord("alerts");
		a.addWord("alters");
		a.addWord("altesr");
		a.addWord("altrse");
		a.addWord("khakistans");
		a.addWord("khakistasn");
		a.addWord("khakistsan");
		a.addWord("khakitssan");
		a.addWord("ores");
		a.addWord("sore");
		a.addWord("soer");
		
		a.addWord("bast");
		a.addWord("tabs");
		a.addWord("stab");
		a.addWord("abst");
		
		ArrayList<Entry<Long, ArrayList<String>>> s = a.getMaxEntries();
		assertTrue(s.size() == 3);
		System.out.print(s);
		a.addWord("eros");
		s = a.getMaxEntries();
		assertTrue(s.size() == 4);
		System.out.print(s);
		System.out.println("END OF TEST3");
		System.out.println();
	}
}
