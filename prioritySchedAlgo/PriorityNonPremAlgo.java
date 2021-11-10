package com.ncu.prioritySchedAlgo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

//JSMJ
//06-10-21
public class PriorityNonPremAlgo {

	class Process {
	    int avt, bt, p, pid;  //arivaltime ,busttime, priorirty, processid
	    Process(int pid, int avt, int bt, int p)
	    {
	        this.pid=pid;
	        this.avt=avt;
	        this.bt=bt;
	        this.p=p;
	    }
	}
	class table {
	   int pid, starttime, compltime, wt, tat;
	}
	public class checking implements Comparator{      //comparing the process
		public int compare(Object p1, Object p2)
		{
			Process x=(Process)p1;
			Process y=(Process)p1;
			 if (x.avt < y.avt)
		            return (-1);
		 
		        else if (x.avt == y.avt && x.p > y.p)
		            return (-1);
		 
		        else
		            return (1);
		
		}

	}
	class Arranging{
		
		void arrangetable(LinkedList pque) {      //arrange processs in  ganttchart
			int time=0;
			TreeSet prique = new TreeSet(new checking());
			
			LinkedList finalresult = new LinkedList();
			
			 while (pque.size() > 0)
				 prique.add((Process)pque.removeFirst());
			
			 Iterator it = prique.iterator();  //iterator to iterat over collection
			 
			 time = ((Process)prique.first()).avt;
			  														// scheduling process
		        while (it.hasNext()) {
		            Process obj = (Process)it.next();
		            table gc1 = new table();
		            gc1.pid = obj.pid;
		            gc1.starttime = time;
		            time += obj.bt;
		            gc1.compltime = time;
		            gc1.tat = gc1.compltime - obj.at;
		            gc1.wt = gc1.tat - obj.bt;
		 
		          
		            finalresult.add(gc1); //final linkedlist
		        }
		 
		        // create object of output class and call method
//		        new ResultOutput(finalresult);
		}
		
	}

	public static void main(String[] args)
	{
		GFG ob=new GFG();
	    int n = 3;
	    Process proc[] = new Process[n];
	    proc[0] = new Process(1, 10, 2);
	    proc[1] = new Process(2, 5, 0);
	    proc[2] = new Process(3, 8, 1);
	    ob.priorityScheduling(proc, n);
	}
}
	

















