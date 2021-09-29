package com.ncu.fcfsAlgo;

import java.util.Scanner;


//31/08/21
//METHOD -2***
//Turn Around Time = Completion Time - Arrival Time   
//Waiting Time = Turnaround time - Burst Time  
//19CSUU003-AASTHA


public class fsfcAlgo {
	
	static void compltTime(int proc[],int n,int bt[],int ct[]) {
		int sum=0;
		ct[0]=bt[0];
		sum=ct[0];
		for(int i=1;i<n;i++)               //==important see logic here we keep on adding the sum of previous burst to the next burst time
		{
			ct[i]=bt[i]+sum;
			sum=sum+bt[i];
		}
	}
	
	static void turnArndTime(int proc[],int n,int bt[],int wt[],int tat[],int arrv[],int ct[]) {
		for(int i=0;i<n;i++)
		{
//			tat[i]=bt[i]+wt[i];
			tat[i]=ct[i]-arrv[i];
			
		}
	}
	static void WaitTime(int proc[],int n,int bt[],int wt[],int tat[],int arrv[],int ct[]) {
		wt[0]=0;
		for(int i=1;i<n;i++)
		{
//			wt[i]=bt[i-1]+wt[i-1];
			wt[i]=tat[i]-bt[i];
		}
	}
	
	static void AvgTime(int proc[],int n,int bt[],int arrv[]){
		int wt[]=new int[n];
		int tat[]=new int[n];
		int ct[]=new int[n];    //completion time
		int total_wt=0;
		int total_tat=0;
		                    //ALWAYS CHECK ORDDER OF FUNCTION CALLING
		compltTime(proc,n,bt,ct);
		turnArndTime(proc,n,bt,wt,tat,arrv,ct);
		WaitTime(proc,n,bt,wt,tat,arrv,ct);
		
		
		
		System.out.printf("Processes ArrivalTime  Bursttime CompletionTime  Waitingtime Turn around time\n");
		
		for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
		}
		for (int i = 0; i < n; i++) {
          
            System.out.printf(" %d ", (i + 1));
            System.out.printf("         %d", arrv[i]);
            System.out.printf("          %d ", bt[i]);
            System.out.printf("           %d ", ct[i]);
            System.out.printf("           %d", wt[i]);
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
		int[] arrv=new int[10];
		
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the numbers of process "); 
		n=sc.nextInt();   
		for(int i=0; i<n; i++)  
		{  
		proc[i]=i+1;
		System.out.print("bust times for process " + i +" = ");  
		bt[i]=sc.nextInt();
		System.out.print("arrival times for process " + i +" = ");  
		arrv[i]=sc.nextInt();
		} 
		AvgTime(proc,n,bt,arrv);
		
	
	}

}




//error-faced-in this code
//Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
//	Cannot make a static reference to the non-static method AvgTime(int[], int, int[]) from the type fsfcAlgo
//

