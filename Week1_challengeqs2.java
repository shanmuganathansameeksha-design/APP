import java.util.Scanner;
public class Palindrome{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.println("Enter a number:");
int n = sc.nextInt();
int reverse=0;
int original=n;
while(n!=0){
int digit= n%10;
reverse= reverse*10+digit;
n=n/10;
}
if(original==reverse){
System.out.println("It is a palindrome");
}
else{
System.out.println("It is not a palindrome");
}
}
}
