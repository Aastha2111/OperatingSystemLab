package com.ncu.fcfsAlgo;

import java.util.Scanner;
//31/08/21
//METHOD -1**
//Turn Around Time = Completion Time - Arrival Time   
//Waiting Time = Turnaround time - Burst Time  


public class fsfc2Algo {

	static void WaitTime(int proc[],int n,int bt[],int wt[]) {
		wt[0]=0;
		for(int i=1;i<n;i++)
		{wt[i]=bt[i-1]+wt[i-1];	
		}
	}
	
	static void turnArndTime(int proc[],int n,int bt[],int wt[],int tat[]) {
		for(int i=1;i<n;i++)
		{tat[i]=bt[i]+wt[i];}
	}
	
	static void AvgTime(int proc[],int n,int bt[]){
		int wt[]=new int[n];
		int tat[]=new int[n];
		int total_wt=0;
		int total_tat=0;
		
		WaitTime(proc,n,bt,wt);
		turnArndTime(proc,n,bt,wt,tat);
		
		System.out.printf("Processes Burst time Waiting"+" time Turn around time\n");
		
		for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            System.out.printf(" %d ", (i + 1));
            System.out.printf("        %d ", bt[i]);
            System.out.printf("          %d", wt[i]);
            System.out.printf("          %d\n", tat[i]);
           
        }
		float avg_wt = (float)total_wt /(float) n;
        int avg_tat = total_tat / n;
        System.out.printf("Average waiting time = %f", avg_wt);
        System.out.printf("\n");
        System.out.printf("Average turn around time = %d ", avg_tat);
	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int proc[]= {1,2,3,4};   
//		int n=proc.length;
//		int bt[]= {10,5,8,9};   //busttime
		
		
		//user-input   ariival time 
		int n = 0;  
		int[] bt = new int[10];  
		int[] proc = new int[10];  
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the numbers of process "); 
		n=sc.nextInt(); 
		System.out.print("Enter the bust times ");  
		for(int i=0; i<n; i++)  
		{  
		proc[i]=i+1;
		System.out.print("Enter bust times for process " + i +" = ");  
		bt[i]=sc.nextInt();  
		} 
		AvgTime(proc,n,bt);
		
	
	}
}
