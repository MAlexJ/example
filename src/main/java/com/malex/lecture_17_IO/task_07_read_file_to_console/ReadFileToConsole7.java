package com.malex.lecture_17_IO.task_07_read_file_to_console;

import java.io.*;

/**
 * java7 closing resources automatically
 */
public class ReadFileToConsole7
{
    private static final String SOURCE = "/home/malex/text.txt";
    private static final String DESTINATION = "/home/malex/result.txt";

    public static void main(String[] args)
    {
        try (InputStream in = new FileInputStream(SOURCE);
             OutputStream out = new FileOutputStream(DESTINATION))
        {
            int s;
            while ((s = in.read()) != -1)
            {
                System.out.println(s);
                out.write(s);
            }
        } catch (IOException ignored)
        {
            // NON
        }
    }
}
