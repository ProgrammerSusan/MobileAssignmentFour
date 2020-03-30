package com.example.app2;

import android.util.Log;

public class Model
{
    public static int[] numbers = new int[10];
    public static int count = 45;

    public static int[] generateList()
    {
        for (int i = 0; i<numbers.length; i++)
        {
            numbers[i] = (int)(Math.random()*100);
        }
        return numbers;
    }

    public static String counter()
    {
        count--;
        return "You have "+ count+" tries left";
    }

    public static boolean isSorted()
    {
        boolean answer = false;
        for(int i = 0; i < numbers.length-1; i++)
        {
            if (numbers[i]<numbers[i+1])
                answer = true;
            else
            {
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static void updateArray(int pos1, int pos2)
    {
        int temp = 0;
        temp = numbers[pos1];
        numbers[pos1] = numbers[pos2];
        numbers[pos2] = temp;

    }
}
