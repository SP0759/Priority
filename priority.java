import java.util.*;
import java.util.Scanner;
public class Priority {
public static void main(String args[]) 
{
Scanner s = new Scanner(System.in);
int temp,n,p[],pp[],bt[],w[],t[],i,j;   //////PP Add
float awt=0, atat=0;
//awt is average waiting time
//atat is average turnaround time

System.out.print("Enter the number of process : ");
n = s.nextInt();   //n is number of process

p = new int[10];   //p is process 
pp = new int[10];  //pp is process priority //////////////////////////////////
bt = new int[10];  //bt is process burst time 
w = new int[10];   //w is wait time 
t = new int[10];   // t is turnaround time 


System.out.print("\n\t Enter CPU time---priority \n");
for(i=0;i<n;i++)
{
System.out.print("\nProcess["+(i+1)+"]:");
bt[i] = s.nextInt();
pp[i] = s.nextInt();            //////////////////////////////////
p[i]=i+1;
}

//sorting on the basis of priority

for(i=0;i<n-1;i++)
{
for(j=i+1;j<n;j++)
{
if(pp[j]<pp[i]) //////////////////////////////
{
temp=pp[i];     ///////////////////////////   
pp[i]=pp[j];    ///////////////////////////
pp[j]=temp;     ///////////////////////////

temp=bt[i];
bt[i]=bt[j];
bt[j]=temp;

temp=p[i];
p[i]=p[j];
p[j]=temp;
}
}
}

w[0]=0;

for(i=1;i<n;i++)
{
w[i]=0;
for(j=0;j<i;j++)
w[i]+=bt[j];
awt +=w[i];
}

for(i=0;i<n;i++)
{
t[i]=w[i]+bt[i];
atat+=t[i]; 
}

//Displaying the process

System.out.println("-----------------------------------------------------------------------");
System.out.print("\n\nProcess \t\t |Burst Time \t\t |Wait Time \t\t |Turn Time \n");
System.out.println("-----------------------------------------------------------------------");
for(i=0;i<n;i++)
System.out.print("\n"+p[i]+"\t\t| "+bt[i]+"\t\t| "+w[i]+"\t\t|"+t[i]+"\t\t| "+pp[i]+"\n");
System.out.println("-----------------------------------------------------------------------");
awt/=n;
atat/=n;
System.out.print("\n Average Wait Time : "+awt);
System.out.print("\n Average Turn Around Time : "+atat);
}
}
