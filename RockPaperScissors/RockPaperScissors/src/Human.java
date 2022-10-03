import java.util.Scanner;

public class Human extends Player{
    Scanner scanner = new Scanner(System.in);

    //Ask user to enter a char and return it
    public char play(){
        System.out.println("Type the char you want to play ('R', 'P', 'S'): ");
        return  Character.toUpperCase(scanner.next().charAt(0));
    }
}
