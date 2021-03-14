import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
//6135512003
public class Bag {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (args.length != 1)
            System.out.println("Usage: java Bag <number of array>");
        else {
            int n = Integer.parseInt(args[0]);
            Random rand = new Random();
            int random = rand.nextInt(n) + 1;
            // System.out.println(random);
            for (int i = 1; i <= n; i++) {
                if (i != random)
                    arr.add(i);

            }
            System.out.println("Bag : " + arr);
            int k = arr.size();
            int count[] = new int[n + 1];
            Arrays.fill(count, 0);
            for (int i = 0; i < k; i++) {
                count[arr.get(i)]++;
            }

            for (int i = 1; i < count.length; i++) {

                System.out.println(i + " : " + count[i]);

            }

            for (int i = 1; i < count.length; i++) {
                if (count[i] == 0)
                    System.out.println("Number : " + i);
            }

        }
    }
}
