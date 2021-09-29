//JSMJ
package com.ncu.sjfAlgo;

//29-09-21
//19csu003

class Prc 
{
    int pid, bt,arv; ; // Process ID-busttime-arivaltime
      
    public Prc(int pid, int bt, int art)
    {
        this.pid = pid;
        this.bt = bt;
        this.arv = arv;
    }
}

public class sjfPreemtive {
 
	 static void waittime(Prc proc[], int n,
             int wt[])
		{
		int rt[] = new int[n];
		for (int i = 0; i < n; i++)
		rt[i] = proc[i].bt;
		
		int finished = 0, time = 0, minrm = Integer.MAX_VALUE;
		int shortest = 0, endtime;
		boolean flag = false;
		
		while (finished!= n) {
			for (int j = 0; j < n; j++)    //shortest remaining among arrved till now
			{
				if ((proc[j].arv <= time) &&(rt[j] < minrm) && rt[j] > 0) 
				{
				minrm = rt[j];
				shortest = j;
				flag = true;
			}
			}
			if (flag == false) {
				time++;
				continue;
			}
			
			rt[shortest]--; //remaining time-1
					minrm = rt[shortest];
			if (minrm == 0)
				minrm = Integer.MAX_VALUE;
			
			if (rt[shortest] == 0) {
				finished++;
				flag = false;
				endtime = time + 1;
				wt[shortest] = endtime - proc[shortest].bt - proc[shortest].arv;
				if (wt[shortest] < 0)
					wt[shortest] = 0;
			}
			time++;
		}
		}
	 
	static void tattime(Prc proc[], int n, int wt[], int tat[])
		{
			for (int i = 0; i < n; i++)
				tat[i] = proc[i].bt + wt[i]; //tat=bt+wt
		}
	 static void findavgTime(Prc proc[], int n)
	    {
	        int wt[] = new int[n], tat[] = new int[n];
	        int  total_wt = 0, total_tat = 0;
	   
	        waittime(proc,n, wt);    //waiting time for all process 
	        tattime(proc,n,wt,tat);   //tat
	        System.out.println("Prc " + " BT" + " WT " +"TAT");
	      
	        for (int i = 0; i < n; i++) {
	            total_wt = total_wt + wt[i];  //TOTAL-WT
	            total_tat = total_tat + tat[i]; //TOTAL-TAT
	            System.out.println("" + proc[i].pid + "\t"+ proc[i].bt + "\t" + wt[i] + "\t" + tat[i]);
	        }
	        System.out.println("Avg wt time = " + (float)total_wt / (float)n);
	        System.out.println("Avg tat = " +(float)total_tat / (float)n);
	    }
	public static void main(String[] args)
    {
		Prc proc[] = { new Prc(1, 6, 1),new Prc(2, 8, 1),new Prc(3, 7, 2),new Prc(4, 3, 3)};
         
         findavgTime(proc, proc.length);
    }
}
