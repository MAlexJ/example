package com.malex.lecture_17_IO.task_07_read_file_to_console;

import java.io.*;

/**
 * Created by malex on 27.02.16.
 */
public class REPLAY {
public static final String IN = "/home/malex/text.txt";
public static final String OUT = "/home/malex/result.txt";

    public static void main(String[] args) {
        InputStream inStream =null;
        OutputStream outStream = null;

        try {
            inStream = new FileInputStream(IN);
            outStream = new FileOutputStream(OUT);
            int i;
            while ((i=inStream.read())!=-1){

                outStream.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (inStream != null) {
                    inStream.close();
                }

                if (outStream != null)
                    outStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
