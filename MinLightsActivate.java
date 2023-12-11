
import java.util.*;

public class MinLightsActivate
{

    // finding the minimum between a and b
    int min(int a, int b)
    {
        if(a > b)
        {
            return b;
        }

        return a;
    }

    // finding the maximum between a and b
    int max(int a, int b)
    {
        if(a > b)
        {
            return a;
        }

        return b;
    }

    // a method that computes the minimum number of lights that
// are required to illuminate the whole corridor.  
    public int minNoLight(int lightArr[], int lightPow)
    {
        int size = lightArr.length;
        int dpArr[] = new int[size + 1];

        for(int i= 0; i < size + 1; i++)
        {
            dpArr[i] = Integer.MAX_VALUE / 2;
        }

        // suppose dp[j] be the minimum number of bulbs that are required
        // for illuminating all the positions of the corridor till the jth position

        dpArr[0] = 0; // 0 number of bulbs for covering the 0th area

        for(int i = 0; i < size; i++)
        {
            if(lightArr[i] == 0)
            {
                // the light is faulty. Hence, check for the next light
                continue;
            }

            int lft = max(0, i - lightPow + 1) + 1; // +1 as dpArr.length == size + 1
            int rgt = min(i + lightPow - 1, size - 1) + 1;

            // computing the minimum number of lights that are required to
            // light up the corridor till the jth position
            for(int j = lft; j <= rgt; j++)
            {
                dpArr[j] = min(dpArr[j], dpArr[lft - 1] + 1);
            }
        }


        if(dpArr[size] == Integer.MAX_VALUE / 2)
        { return -1; }

        return dpArr[size];

    }

    // main method
    public static void main(String[] argvs)
    {
// creating an object of the class MinLightsActivate  
        MinLightsActivate obj = new MinLightsActivate();

        int lightArr[] = {1, 1, 0, 1, 1};
        int size = lightArr.length;
        int lightPow = 3;

        int ans = obj.minNoLight(lightArr, lightPow);
        System.out.println("For the following lights: ");
        for(int i = 0; i < size; i++)
        {
            System.out.print(lightArr[i] + " ");
        }
        System.out.println();
        if(ans != -1)
        {
            System.out.println("The minimum number of lights to light up the whole corridor is: " + ans);
        }
        else
        {
            System.out.println("It is not possible to light up the whole corridor.");
        }

        int lightArr1[] = {0, 0, 0, 1, 1, 1, 1, 1, 1};
        size = lightArr1.length;
        lightPow = 3;
        System.out.println();
        ans = obj.minNoLight(lightArr1, lightPow);
        System.out.println("For the following lights: ");
        for(int i = 0; i < size; i++)
        {
            System.out.print(lightArr1[i] + " ");
        }
        System.out.println();
        if(ans != -1)
        {
            System.out.println("The minimum number of lights to light up the whole corridor is: " + ans);
        }
        else
        {
            System.out.println("It is not possible to light up the whole corridor.");
        }

    }
}  