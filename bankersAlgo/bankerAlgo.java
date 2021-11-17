package com.ncu.bankersAlgo;
//JSMJ
//17-11-21
//19CSU003-AASTHA

public class bankerAlgo {
	 int n = 5; // no.of process
     int m = 3; //no.of resour
	 static int [][]max;
	 static int [][]alloc;
	 static int []avail;
	 int need[][] = new int[n][m];
	 int safeseq[] = new int[n];
	 
	 void calneed()
	    {
	    for (int i=0;i<n;i++)
	    {
	        for (int j= 0;j<m;j++)
	         {   need[i][j] = max[i][j]-alloc[i][j];  //need=max-allocated resources
	         }
	    }        
	    }
	   
	 void chksafe()
	    {
	    int count=0;
	    
	    boolean assigned[] = new boolean[n];  //aleady alloc p's info
	    for (int i =0;i<n;i++)
	    {assigned[i] = false;}
	          
	    int avail2[] = new int[m];    //copy of availresoure [initial avail]
	    for (int i = 0;i < m; i++)
	    { avail2[i] = avail[i];}
	  
	    while (count<n)
	    {
	        boolean flag = false;
	        for (int i=0;i<n;i++)
	        {
	            if (assigned[i]==false)  //not aloocated
	             {
	            int j;
	            for (j=0;j<m;j++)  //parsing resources in matrix
	            	
	            {        
	                if (need[i][j] >avail2[j])
	                break;
	            }
	            if (j == m)
	            {
	               safeseq[count++]=i; //update safeseq.list
	               assigned[i]=true;
	               flag=true;
	                          
	                for (j=0;j<m;j++)
	                {
	                avail2[j] = avail2[j]+alloc[i][j];//release resource and updating available
	                }
	            }
	             }
	        }
	        if (flag==false)
	        {
	            break;
	        }
	    }
	    if (count<n) // it chk is all proces are covered or not
	    {
	        System.out.println("The System is UnSafe!");
	    }
	    else
	    {
	        System.out.println("yes it is safe");
	        System.out.println(" safe seq is:");
	                for (int i = 0;i < n; i++)
	        {
	            System.out.print("-->p" + safeseq[i]+"");
	           
	        }
	    }
	    }
	      
	public static void main(String[] args)
    {  
      int i, j, k; 
      bankerAlgo banker = new  bankerAlgo();
       alloc = new int[][] {{ 0, 1, 0 },{ 2, 0, 0 },{ 3, 0, 2 }, { 2, 1, 1 }, { 0, 0, 2 } }; // Alloc matix  p0,p1,p2,3..4.5
	   max = new int[][] {{ 7, 5, 3 }, { 3, 2, 2 }, { 9, 0, 2 }, { 2, 2, 2 },  { 4, 3, 3 } };	  // max Matrix of p's
      avail = new int[] { 3, 3, 2 };    // resorce avail 
      banker.calneed();     //calc need matrix     
      banker.chksafe();     //chk safe or not   
    }
}
