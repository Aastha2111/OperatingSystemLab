//JSMJ
package com.ncu.prioritySchedAlgo;

import java.util.Arrays;
import java.util.Comparator;


//06-10-21
//Priority Scheduling non Premtive.
//19csu003-aastha

class Process
{
    int pid,bt, priority; 
    
    Process(int pid, int bt, int priority)
    {
        this.pid = pid;
        this.bt = bt;
        this.priority = priority;
    }
    public int prior() {
        return priority;
    }
}
 
public class PriorityQueAlgo {

	public void waitngtime(Process proc[], int n, int wt[])
	{
	    wt[0] = 0;
	 	    for (int i = 1; i < n ; i++ )
	        wt[i] = proc[i - 1].bt + wt[i - 1] ;   //wt= bt+wt of prviuus
	}
	public void tat( Process proc[], int n,int wt[], int tat[])
	{
		for (int i = 0; i < n ; i++)
		tat[i] = proc[i].bt + wt[i];    
	}
	public void avgTime(Process proc[], int n)
	{
	    int wt[] = new int[n], tat[] = new int[n], total_wt = 0, total_tat = 0;
	 
	    waitngtime(proc, n, wt);
	    tat(proc, n, wt, tat);
	    System.out.print("\nPid   Bt   Wt  Tat  priority\n");
	 	    for (int i = 0; i < n; i++)
	    {
	        total_wt = total_wt + wt[i];
	        total_tat = total_tat + tat[i];
	        System.out.print("" + proc[i].pid + "     " + proc[i].bt + "    " + wt[i] + "   " + tat[i] + "   " + proc[i].priority +"\n");
	    }
	 
	    System.out.print("\nAvg wt = " +(float)total_wt / (float)n);
	    System.out.print("\nAvg tat = "+(float)total_tat / (float)n);
	}
	public void priorityScheduling(Process proc[], int n)
	{
	   	    Arrays.sort(proc, new Comparator<Process>() {
	        public int compare(Process a, Process b) {
	            return b.prior() - a.prior();
	        }
	    });
	    System.out.print(" \n");
//	    for (int i = 0 ; i < n; i++)
//	        System.out.print(proc[i].pid + " ") ;
	 
	    avgTime(proc, n);
	}
	public static void main(String[] args)
	{
		PriorityQueAlgo ob=new PriorityQueAlgo();
	    int n = 4;
	    Process proc[] = new Process[n];
	    proc[0] = new Process(1, 10, 2);
	    proc[1] = new Process(2, 5, 0);
	    proc[2] = new Process(3, 8, 1);
	    proc[3] = new Process(4, 8, 1);
	    ob.priorityScheduling(proc, n);
	}
}
