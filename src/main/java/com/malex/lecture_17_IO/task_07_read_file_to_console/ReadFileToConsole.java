package com.malex.lecture_17_IO.task_07_read_file_to_console;

import java.io.*;

/**
 * JAVA 6 support for closing resources
 */
public class ReadFileToConsole
{
    private static final String SOURCE = "/home/malex/text.txt";
    private static final String DESTINATION = "/home/malex/result.txt";

    public static void main(String[] args)
    {
        InputStream in = null;
        OutputStream out = null;
        try
        {
            in = new FileInputStream(SOURCE);                   //source
            out = new FileOutputStream(DESTINATION);    //destination
            int s;
            while ((s = in.read()) != -1)
            {
                System.out.println(s);
                out.write(s);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (in != null)
                {
                    in.close();
                }
                if (out != null)
                {
                    out.close();
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
