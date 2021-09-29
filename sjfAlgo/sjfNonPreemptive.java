//JSMJ

//08-09-21
//19csu003

package com.ncu.sjfAlgo;

import java.util.Scanner;

public class sjfNonPreemptive {
	
	static int[][] recd=new int[12][6];
	static void argArvl(int n,int[][] recd)   //usigm bubble soting
	{
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (recd[j][1] > recd[j + 1][1]) {    //recd[j][1]--arv time
                    for (int k = 0; k < 5; k++) {
                        int temp = recd[j][k];
                        recd[j][k] = recd[j + 1][k];
                        recd[j + 1][k] = temp;
                    }
                }
            }
        }
		System.out.println("Arranging on basis of arrival time");
		System.out.println("PID \t avr \t bt");
		for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%d\t%d\n", recd[i][0], recd[i][1], recd[i][2]);
        }
		
		}
	
	static void Arranging(int n,int[][] recd) {
		
			recd[0][3] = recd[0][1] + recd[0][2];    //ct
			recd[0][5] = recd[0][3] - recd[0][1];    //tat
			recd[0][4] = recd[0][5] - recd[0][2];	//wt
		int temp,val=-1;
		int total_wt=0;
		int total_tat=0;
			
			for (int i = 1; i < n; i++) {
	            temp = recd[i - 1][3]; 
	            int lst = recd[i][2];
	            for (int j = i; j<n; j++) {
	                if (temp >= recd[j][1] && lst >= recd[j][2]) {   //chk for min arvtime and min busttime
	                    lst = recd[j][2];
	                    val = j;
	                }
	            }
	            
	            recd[val][3] = temp + recd[val][2];
	            recd[val][5] = recd[val][3] - recd[val][1];
	            recd[val][4] = recd[val][5] - recd[val][2];
//	            System.out.println(recd[val][4]);
	            
	            for (int k = 0; k < 6; k++) {
	                int t = recd[val][k];
	                recd[val][k] = recd[i][k];
	                recd[i][k] = t;
	            }
	            
	            total_wt+= recd[i][4];
	            total_tat+=recd[i][5];
			
			   }
			    float avg_wat=total_wt/n;
			   float avg_tat=total_tat/n;
			
			   System.out.println("final output");
	    		System.out.println("PID \t avr \t bt \t ct \t wt \t tat");
	    		for (int i = 0; i < 4; i++) {
	                System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\n", recd[i][0], recd[i][1], recd[i][2],recd[i][3],recd[i][4],recd[i][5]);
//	    			System.out.printf("%d\t%d\t%d\n", recd[i][0], recd[i][1], recd[i][2],recd[i][3]);	    			
	            }
	    		System.out.printf("avg_wt =%f", avg_wat);
	    		System.out.printf("avg_tat= %f", avg_tat);
			
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("number proc ID you want to enter: ");
        for (int i = 0; i < 4; i++) {
            System.out.println("P Id: ");
            
            recd[i][0] = sc.nextInt();
            System.out.println("Arv time: ");
            recd[i][1] = sc.nextInt();
            System.out.println("Bust time: ");
            recd[i][2] = sc.nextInt();            
        }
            argArvl(4, recd);    //aarange acc to arrival
            Arranging(4, recd);
            
         

}
	
}








