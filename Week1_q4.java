import java.util.Scanner;
public class Factorial{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
int fact=1;
System.out.println("Enter a number:");
 int n= sc.nextInt();
for(int i=1;i<=n;i++){
fact=fact*i;
}
System.out.println("Factorial:" + fact);
}
}

