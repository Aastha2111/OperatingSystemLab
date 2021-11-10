//JSMJ

//aastha-19csu003
//10-11-21
package com.ncu.RRobinAlgo;

public class RRobinAlgo {
	
	static void WaitingTime(int pid[], int n, int bt[], int wt[], int quantum)
	{
      int rest_bt[] = new int[n];  //remaining bt
      for (int i =0;i<n;i++)
    	  rest_bt[i]= bt[i]; //store remaining bt
      int t=0; // current time
 
   while(true)  //traversing till remianing time of all =0
   {
       boolean done = true;
       for (int i=0;i<n;i++)
       {
           if (rest_bt[i]>0)
           {
               done = false; //meaning rest_bt!=0
                if (rest_bt[i] > quantum)
               { 
                	t += quantum;
                    rest_bt[i] -= quantum;
               }
                else  //if bt<qntm
               {
                   t = t + rest_bt[i];
                   wt[i] = t - bt[i];
                   rest_bt[i] = 0;    //Process complete
               }
           }
       }
 
       if (done == true)
         break;
   }
}
	
	  static void TurnAroundTime(int pid[], int n,int bt[], int wt[], int tat[])
	  {
		  //tat= bt + wt
		  for (int i = 0; i < n ; i++)
			  tat[i] = bt[i] + wt[i];
	  }
	static void avgtime(int pid[], int n, int bt[],int quantum)
	{
		int wt[] = new int[n], tat[] = new int[n];
		int total_wt = 0, total_tat = 0;

		WaitingTime(pid, n, bt, wt, quantum); //wt of all P's
		TurnAroundTime(pid, n, bt, wt, tat); //tat of all P's

		System.out.println("Processes " + " Burst time " +" Waiting time " + " Turn around time");

		for (int i=0; i<n; i++)    //calc total wt&tat
		{
			total_wt = total_wt + wt[i];
			total_tat = total_tat + tat[i];
			System.out.println(" " + (i+1) + "\t\t" + bt[i] +"\t " +wt[i] +"\t\t " + tat[i]);
		}

		System.out.println("Average waiting time = " +(float)total_wt / (float)n);
		System.out.println("Average turn around time = " +(float)total_tat / (float)n);
}
	
    public static void main(String[] args)
    {
        
        int pid[] = { 1, 2, 3}; //processes
        int n = pid.length;
        int burst_time[] = {10, 5, 8};
        int quantum = 2;
        avgtime(pid, n, burst_time, quantum);
    }
}
