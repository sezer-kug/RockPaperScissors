import java.util.Random;

public class Bot extends Player {
    Random rnd = new Random();

    //Return a random char(R, P, S)
    public char play(){
        int a = rnd.nextInt(3);

        char value = ' ';
        switch (a){
            case 0:
                value = 'R';
                break;
            case 1:
                value = 'P';
                break;
            case 2:
                value = 'S';
        }
        return value;
    }

}
