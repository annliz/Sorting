import java.util.Arrays;
import java.util.Random;

/**
 * Insert Sort and Counting Sort.
 *
 * @author Annli
 * @version 2/25/20
 */
public class Sorting
{
    public static int[] insertionSort(int[] input)
    {
        // make new array
        int[] a = new int[input.length];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = input[i];
        }
        // do the sort
        for (int i = 1; i < a.length; i++)
        {
            int x = a[i];
            int j = i-1;
            while (j >= 0 && a[j] > x)
            {
                a[j+1] = a[j];
                a[j] = x;
                j--;
            }
        }
        return a;
    }

    public static int[] countingSort(int[] input) // only works for integers
    {
        // finding the range
        int min = input[0];
        int max = input[0];
        for (int i = 1; i < input.length; i++)
        {
            if (input[i] < min)
            {
                min = input[i];
            }
            else if (input[i] > max)
            {
                max = input[i];
            }
        }
        int[] counter = new int[max-min+1];
        for (int i = 0; i < input.length; i++)
        {
            counter[input[i] - min]++;
        }
        // make new array
        int[] sorted = new int[input.length];
        int index = 0;
        for (int i = 0; i < counter.length; i++)
        {
            for (int j = 0; j < counter[i]; j++)
            {
                sorted[index] = i + min;
                index++;
            }
        }
        return sorted;
    }

    public static void testCountingSort(int[] input)
    {
        // make new array
        int[] copy = new int[input.length];
        for (int i = 0; i < input.length; i++)
        {
            copy[i] = input[i];
        }
        // sort both
        Arrays.sort(copy); // Java's sorting
        int[] a = countingSort(input); // my counting sort
        // test if my sorting is correct
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != copy[i])
            {
                System.out.println("My CountingSort did not work");
                return;
            }
        }
        System.out.println("My CountingSort worked");
    }

    public static void testInsertionSort(int[] input)
    {
        // make new array
        int[] copy = new int[input.length];
        for (int i = 0; i < input.length; i++)
        {
            copy[i] = input[i];
        }
        // sort both
        Arrays.sort(copy); // Java's sorting
        int[] a = insertionSort(input); // my inseriton sort
        // test if my sorting is correct
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != copy[i])
            {
                System.out.println("My InsertionSort did not work");
                return;
            }
        }
        System.out.println("My InsertionSort worked");
    }

    public static void main(String[] args)
    {
        // create random arrays
        Random rand = new Random(); // code for creating random taken from https://www.tutorialspoint.com/generate-a-random-array-of-integers-in-java
        int[] a = new int[100]; // you can change length
        System.out.println("***\nARRAY A IS:");
        for (int i = 0; i < a.length; i++)
        {
            a[i] = rand.nextInt()/10; // need to divide by 10 to prevent integer overflow when calculating range for countingsort
            System.out.print(a[i] + ", ");
        }
        System.out.println();
        int[] b = new int[273]; // you can change length
        System.out.println("***\nARRAY B IS:");
        for (int i = 0; i < b.length; i++)
        {
            b[i] = rand.nextInt()/10;
            System.out.print(b[i] + ", ");
        }
        System.out.println("\n***\n");
        // test if my sorting is correct
        System.out.println("FOR ARRAY A:");
        testCountingSort(a);
        testInsertionSort(a);
        System.out.println("FOR ARRAY B:");
        testCountingSort(b);
        testInsertionSort(b);
    }
}
