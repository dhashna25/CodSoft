import java.util.Random;
import java .util.Scanner;

public class task1{

public static void main(String[] args)
{
Scanner scanner=new Scanner (System.in);
Random random=new Random();
int min=1;
int max=100;
int target= random .nextInt(max -min +1)+ min;
int guess;
int attempts=0;
System.out.println("welcome to the number guessing game!");
System.out.println(" I have selected a number between 1 and 100.can you guess it?");

do{
System.out.println("Enter your guess:");
guess =scanner.nextInt();
attempts++;
if(guess < target)
{
System.out.println("too low! Try again.");
}
else if(guess > target)
{
System.out.println("too high! Try again.");
}
}while( guess != target);
System.out.println("congratulations! you guessad the number" + target +" correctly in " + attempts + "attempts!");
scanner.close();
}
}