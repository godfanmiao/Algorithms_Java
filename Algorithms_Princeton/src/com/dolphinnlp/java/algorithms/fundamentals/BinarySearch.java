package com.dolphinnlp.java.algorithms.fundamentals;

import java.util.Arrays;

import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;

public class BinarySearch {
	
	public static int rank(int[] a, int key)
	{
		int lo = 0; 
		int hi = a.length - 1;
		while(lo <= hi)
		{
			int mid = (lo + hi) / 2;
			
			if(a[mid] == key)
				return mid;
			else if(a[mid] > key)
			{
				hi = mid - 1;
			}
			else {
				lo = mid + 1;
			}
		}
		
		return -1;
	}
	/**
	 * 
	 * @param args [example: dataset\\tinyW.txt dataset\\tinyT.txt ]
	 */
	public static void main(String[] args)
	{
		int[] whitelist = In.readInts(args[0]);
		int[] searchKeys = In.readInts(args[1]);
		
		Arrays.sort(whitelist);
		
		for(int key : searchKeys)
		{
			if(rank(whitelist, key) != -1)
			{
				StdOut.println(key);//Output the keys that are also included in the whitelist
				
			}
		}
	}
}
