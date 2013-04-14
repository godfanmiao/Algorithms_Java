package com.dolphinnlp.java.algorithms.core;

import java.util.Arrays;

import com.dolphinnlp.java.algorithms.utils.In;
import com.dolphinnlp.java.algorithms.utils.StdOut;
import com.dolphinnlp.java.algorithms.utils.Stopwatch;

/**
 * ThreeSumFast.java	
 * Three sum fast Algorithm.
 * @author Miao Fan
 * @afflication Department of Computer Science and Technology in Tsinghua University
 * @email fanmiao.cslt.thu@gmail.com
*/

public class ThreeSumFast {
	public static void printAll(int[] a)
	{
		int N = a.length;
		
		Arrays.sort(a);
		
		for(int i = 0; i < N; i++)
		{
			for(int j = i + 1; j < N; j++)
			{
				int k = Arrays.binarySearch(a, -(a[i] + a[j]));
				
				if(k > j)
					StdOut.println(a[i] + " " + a[j] + " " + a[k]);
			}
		}
	}
	
	public static int count(int[] a)
	{
		int N = a.length;
		Arrays.sort(a);
		
		int cnt = 0;
		
		for(int i = 0; i < N; i++)
		{
			for(int j = i + 1; j < N; j++)
			{
				int k = Arrays.binarySearch(a, -(a[i] + a[j]));
				
				if(k > j)
					cnt ++;
			}
		}
		return cnt;
	}
	
	/**
	 * 
	 * @param args [example: dataset\\8Kints.txt]
	 * @throws Exception
	 */	
	
	public static void main(String[] args)
	{
		int[] a = In.readInts(args[0]);
		Stopwatch stopwatch = new Stopwatch();
		int cnt = count(a);
		StdOut.println(cnt);
		//ThreeSumFast is much faster then Brute-force ThreeSum
		StdOut.println(args[0] + " costs " + stopwatch.elapsedTime() + " seconds");
	}
}
