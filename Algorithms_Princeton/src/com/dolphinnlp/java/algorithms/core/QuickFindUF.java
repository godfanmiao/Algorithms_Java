package com.dolphinnlp.java.algorithms.core;

import java.io.File;
import java.util.Scanner;

/**
 * QuickFindUF.java	
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
			id[i] = i;
	}
	
	public int find(int p)
	{
		return id[p];
	}
	
	public int count()
	{
		return count;
	}
	
	public boolean connected(int p, int q)
	{
		return id[p] == id[q];
	}
	
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
	
	/**
	 * @param args 输入文件args[0]
	 */
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
				continue;
			uf.union(p, q);
			System.out.println(p + " " + q);
		}
		
		System.out.println(uf.count() + " components");
		
	}

}
