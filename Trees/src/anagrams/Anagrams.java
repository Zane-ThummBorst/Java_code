//Zane ThummBorst
//I pledge my honor that I have abided by The Stevens Honor System.

package anagrams;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Anagrams {
	final Integer[] primes =  
			{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 
			31, 37, 41, 43, 47, 53, 59, 61, 67, 
			71, 73, 79, 83, 89, 97, 101};
	Map<Character,Integer> letterTable;
	Map<Long,ArrayList<String>> anagramTable;

	
	//links every prime to a letter in the alphabet going in order. loop uses string of alphabet and list of primes.
	//We use to put function to add into our map letterTable.
	private void buildLetterTable() {
		letterTable = new HashMap<Character,Integer>();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < primes.length; i++) {
			letterTable.put(alphabet.charAt(i), primes[i]);
		}
	}

	Anagrams() {
		buildLetterTable();
		anagramTable = new HashMap<Long,ArrayList<String>>();
	}

	//if the words hash already exists in the anagramTable, add to the pre-existing list of that hash,
	// otherwise create the list starting with our word and add it to the anagram table using put along with its hash.
	public void addWord(String s) {
		long x = myhashcode(s);
		if (anagramTable.get(x) != null) {
			anagramTable.get(x).add(s);
			//anagramTable.put(x,anagramTable.get(x));
		}
		else {
			ArrayList<String> y = new ArrayList<>();
			y.add(s);
			anagramTable.put(x,y);
		}
		
	}
	
	// x is set to one for product. for every letter, we find its corresponding prime and multiply them all up.
	// when there are no more letters return x.
	public long myhashcode(String s) {
		long x = 1;
		for(int i = 0; i < s.length(); i++) {
			x = x * letterTable.get(s.charAt(i));
		}
		return x;
	}
	
	public void processFile(String s) throws IOException {
		FileInputStream fstream = new FileInputStream(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while ((strLine = br.readLine()) != null)   {
		  this.addWord(strLine);
		}
		br.close();
	}
	
	// use a for each loop to traverse every existing hash in the table.
	// when a new max is found, clear the total and add in the entry.
	//when an entry has an equal number of values to the max, add it to the total.
	// when every hash has been observed, return total.
	public ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries() {
		int max = 0;
		ArrayList<Map.Entry<Long,ArrayList<String>>> total = new ArrayList<>();
		for(Map.Entry<Long, ArrayList<String>> entry: anagramTable.entrySet()) {
			if(entry.getValue().size() > max) {
				total.clear();
				total.add(entry);
				max = entry.getValue().size();
			}
			else if(entry.getValue().size() == max) {
				total.add(entry);
			}
		}
		return total;
	}
	
	public static void main(String[] args) {
		Anagrams a = new Anagrams();
		final long startTime = System.nanoTime();    
		try {
			a.processFile("words_alpha.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries = a.getMaxEntries();
		final long estimatedTime = System.nanoTime() - startTime;
		final double seconds = ((double) estimatedTime/1000000000);
		System.out.println("Time: "+ seconds);
		System.out.println("List of max anagrams: "+ maxEntries);
	}
}
