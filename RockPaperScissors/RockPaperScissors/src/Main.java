import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player bot = new Bot();
        Player human = new Human();

        //Ask user to decide how many rounds to play in total.
        System.out.println("How many rounds do you want to play?");
        System.out.println("Please enter an odd number so there will be no draw:");
        int rounds = 0;
        do{
            rounds = scanner.nextInt();
            if(rounds % 2 == 0){
                System.out.println("Please enter an odd number!");
            }
            else
                break;
        }

        //check if the game is finished.
        while (true);
        int temp = rounds;
        int win_counter = 0;
        int lose_counter = 0;

        //while the game is not finished (rounds > 0), continue playing.
        while(rounds >0){
            int cmp = compare(bot.play(), human.play());
            //if the result of the rounds is a draw, do not count that round and continue playing.
            if(cmp == 2){
                continue;
            }
            //if player wins the round, increment the win_counter and decrement the remaining rounds.
            else if(cmp == 1){
                win_counter++;
                rounds--;
            }
            //if player loses the round, increment the lose_counter and decrement the remaining rounds.
            else if(cmp == 0){
                lose_counter++;
                rounds--;
            }

            //check if one of the counters is already high enough to win the game
            //if yes, break the while loop and proceed to next step
            if(lose_counter == (temp/2)+1 || win_counter == (temp/2)+1){
                break;
            }
        }
        //check the winner and promp the final output
        if(win_counter > temp/2){
            System.out.println("**************************");
            System.out.println("* You win the best of " + temp + "! *");
            System.out.println("**************************");
        }
        else {
            System.out.println("**************************");
            System.out.println("* You lose the best of " + temp + "! *");
            System.out.println("**************************");
        }
    }
    //Compare the moves of player and the bot and prompt the result.
    public static int compare (char bot, char human){
        System.out.println(bot);
        System.out.println(human);
        int result;

            if (bot == human) {
                System.out.println("Draw!");
                result = 2;
            }
            else if(bot == 'R' && human == 'P'){
                System.out.println("You win!");
                result = 1;
            }
            else if(bot == 'R' && human == 'S'){
                System.out.println("You lose hehe :D");
                result = 0;

            }
            else if(bot == 'P' && human == 'R'){
                System.out.println("You lose hehe :D");
                result = 0;
            }
            else if(bot == 'P' && human == 'S'){
                System.out.println("You win!");
                result = 1;
            }
            else if(bot == 'S' && human == 'R'){
                System.out.println("You win!");
                result = 1;
            }
            else if(bot == 'S' && human == 'P'){
                System.out.println("You lose hehe :D");
                result = 0;
            }
            else{
                System.out.println("Wrong entry");
                result = 2;
            }
            return result;
    }
}
