package com.dolphinnlp.java.algorithms.core;
import java.io.File;
import java.util.Scanner;

/**
 * QuickUnionUF.java	
 * Quick Union Algorithm Implementation.
 * @author Miao Fan
 * @afflication Department of Computer Science and Technology in Tsinghua University
 * @email fanmiao.cslt.thu@gmail.com
*/
public class QuickUnionUF {
	
	private int[] id;
	private int count;
	
	public QuickUnionUF(int N)
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
	
	//This find operation will be slow!
	public int find(int p)
	{
		while(p != id[p])
			p = id[p];
		return p;
	}
	
	public boolean connected(int p, int q)
	{
		return find(p) == find(q);
	}
	
	//The union operation is relatively fast!
	public void union(int p, int q)
	{
		int i = find(p);
		int j = find(q);
		
		if(i == j)
			return;
		id[i] = j; //Set the root of i to j(q)
		
		count --;
	}
	
	/**
	 * 
	 * @param args [example: data\\tinyUF.txt]
	 * @throws Exception
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
		QuickUnionUF uf = new QuickUnionUF(N);
			
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
