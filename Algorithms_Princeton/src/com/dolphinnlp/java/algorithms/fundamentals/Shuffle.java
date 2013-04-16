package com.dolphinnlp.java.algorithms.fundamentals;

import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;

public class Shuffle {
	
	/**
	 * 
	 * @param args [example: dataset\\cards.txt]
	 */
	public static void main(String[] args)
	{
		String[] a = In.readStrings(args[0]);
		
		int N = a.length;
		
		for(int i = 0; i < N; i++)
		{
			int r = i + (int)(Math.random() * (N - i));
			String swap = a[i];
			a[i] = a[r];
			a[r] = swap;
		}
		
		for(int i = 0; i < N; i++)
			StdOut.println(a[i]);
		
	}
}
