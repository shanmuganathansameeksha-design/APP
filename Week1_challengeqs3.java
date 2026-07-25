import java.util.Scanner;
public class Fibonnaciseries{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.print("Enter the number of terms:");
int n = sc.nextInt();
int a=0;
int b=1;
int c;
System.out.print("Fibonnaci series:");
for(int i=1;i<=n;i++){
System.out.print(a + " ");
c= a+b;
a=b;
b=c;
}
}
}
