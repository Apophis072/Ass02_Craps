import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random rnd = new Random();
        int rollA = -1;
        int rollB = -2;

    rollA = rnd.nextInt(6) + 1;
    rollB = rnd.nextInt(6) + 1;

    System.out.println(rollA);
    System.out.println(rollB);
    }
}