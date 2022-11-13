package scheduling;
import java.util.*;
public class priority {
	public static void main(String args[])
	{
		int i,n,j,temp;
		float sum=0;
		int p_id[]=new int[10];
		int bt[]=new int[10];
		int prio[]=new int[10],ft[]=new int[10],tat[]=new int[10],wt[]=new int[10];
		Scanner s = new Scanner(System.in);
		System.out.print("enter no of processes: ");
		n = s.nextInt();
		
		//entering values
		
		for(i=0;i<n;i++)
		{
			System.out.println("enter process "+(i+1)+" brust time: ");
			bt[i]=s.nextInt();
			System.out.println("enter process "+(i+1)+" priority: ");
			prio[i]=s.nextInt();
			p_id[i]=i+1;
		}
		
		//sorting
		for(i=0;i<n-1;i++)
		{
			for(j=i+1;j<n;j++)
			{
				if(prio[i]>prio[j])
				{
					temp=prio[i];
					prio[i]=prio[j];
					prio[j]=temp;
					
					temp=p_id[i];
					p_id[i]=p_id[j];
					p_id[j]=temp;
					
					temp=bt[i];
					bt[i]=bt[j];
					bt[j]=temp;
					
				}
			}
		}
		
		//calculation
	
		//wt 
		float total_wt=0;
		wt[0]=0;
		for(i=1;i<n;i++)
		{
		wt[i]=wt[i-1]+bt[i-1];
		total_wt=total_wt+wt[i];
		}
		// turn around
		float total_tat=0;
		for(i=0;i<n;i++)
		{
			tat[i]=wt[i]+bt[i];
			total_tat=total_tat+tat[i];
			
		}
		//printing
		System.out.println("pid\t brust_time\t priority\t wait time");
		for(i=0;i<n;i++)
		{
			System.out.println(p_id[i]+"\t\t"+bt[i] +"\t\t"+ prio[i]+"\t\t"+wt[i]);
		}
		System.out.println("avg wt is=  "+total_wt/n);
		System.out.println("avg tat is=  "+total_tat/n);

		
	}

}