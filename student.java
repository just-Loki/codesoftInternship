//6 sub marks
//calculate total
//calculate average(percentage)
//assign grade   
import java.util.Scanner;

public class student
{

public static void markscalc()
{
int total=0;
System.out.println("please enter the number of subject");
Scanner sc= new Scanner(System.in);

int subject=sc.nextInt();
for (int i=1;i<=subject;i++)
{
System.out.println("enter marks for subject marks"+i);
int marks =sc.nextInt();
total +=marks;
}

//int m1=sc.nextInt();
//int m2=sc.nextInt();
//int m3=sc.nextInt();
//int m4=sc.nextInt();
//int m5=sc.nextInt();
//int m6=sc.nextInt();

//int sum =m1+m2+m3+m4+m5+m6;

System.out.printf("\n\nyour total marks is %d ",total);

double avg=(double) total/subject;

if(total>=550)
{
System.out.println("\n\nyour are holdind A grade congrulation"); 
}
else if(total>=450)
{
System.out.println("\n\nyour are holding B grade conguralation");
}
else if(total>=350)
{
System.out.println("\n\nyour holding C grade conguralation");
}
else
{
System.out.println("\n\ntry hard to score good marks");
}

 

}

public static void main(String args[])
{
markscalc();
}

}