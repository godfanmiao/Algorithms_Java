package com.dolphinnlp.java.algorithms.core;

import java.io.File;
import java.util.Scanner;

/**
 * QuickFindUF.java	
 * Quick Find Algorithm Implementation.
 * @author Miao Fan
 * @afflication Department of Computer Science and Technology in Tsinghua University
 * @email fanmiao.cslt.thu@gmail.com
*/

public class QuickFindUF {
	private int[] id;
	private int count;
	
	public QuickFindUF(int N)
	{
		id = new int[N];
		count = N;
		
		for(int i = 0; i < N; i++)
		{
			id[i] = i;
		}
	}
	
	public int count()
	{
		return count;
	}
	
	//The find operation is quick!
	public int find(int p)
	{
		return id[p];
	}
	
	public boolean connected(int p, int q)
	{
		return id[p] == id[q];
	}
	
	//The union operation is quite slow!
	public void union(int p, int q)
	{
		if(connected(p, q))
			return;
		int pid = id[p];
		for(int i = 0; i < id.length; i++)
		{
			if(id[i] == pid)
				id[i] = id[q];
		}
		
		count --;
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		if(args.length == 0)
		{
			System.err.println("Parameter args[0] must be the path of input file!");
			return;
		}

		Scanner scan = new Scanner(new File(args[0]));
		
		int N = scan.nextInt();
		QuickFindUF uf = new QuickFindUF(N);
			
		while(scan.hasNext())
		{
			int p = scan.nextInt();
			int q = scan.nextInt();
			
			if(uf.connected(p, q))
			{
				System.out.println(p + " and " + q + " has connected!");
				continue;
			}
			uf.union(p, q);
			System.out.println(p + " union " + q);
		}
		
		System.out.println(uf.count() + " components");
	}

}