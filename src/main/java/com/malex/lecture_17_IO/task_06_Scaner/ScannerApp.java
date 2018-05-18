package com.malex.lecture_17_IO.task_06_Scaner;

import java.util.Scanner;

public class ScannerApp
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        int i = 2;
        System.out.print("Enter an integer: ");
        if (scanner.hasNextInt())
        { // returns true if an integer can be read from the input stream
            i = scanner.nextInt(); // reads an integer from the input stream and stores it in a variable
            System.out.println(i * 2);
        } else
        {
            System.out.println("You did not enter an integer!");
        }
    }
}
