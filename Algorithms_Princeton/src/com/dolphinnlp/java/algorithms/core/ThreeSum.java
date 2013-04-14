package com.dolphinnlp.java.algorithms.core;

import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;
import com.dolphinnlp.java.algorithms.utils.Stopwatch;

/**
 * ThreeSum.java	
 * Brute-force Three sum Algorithm.
 * @author Miao Fan
 * @afflication Department of Computer Science and Technology in Tsinghua University
 * @email fanmiao.cslt.thu@gmail.com
*/

public class ThreeSum {

	public static int count(int[] a)
	{
		int count = 0;
		int N = a.length;
		
		for(int i = 0; i < N; i++)
		{
			for(int j = i + 1; j < N; j++)
			{
				for(int k = j + 1; k < N; k++)
					//Count the num of sequence that the sum of three number is 0.
					if(a[i] + a[j] + a[k] == 0)
						count ++;
			}
		}
		
		return count;
	}
	
	/**
	 * 
	 * @param args [example: dataset\\8Kints.txt]
	 * @throws Exception
	 */	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = In.readInts(args[0]);
		
		Stopwatch stopwatch = new Stopwatch();
		
		StdOut.println(count(a));
		
		StdOut.println(args[0] + " costs " + stopwatch.elapsedTime() + " seconds");
	}

}
