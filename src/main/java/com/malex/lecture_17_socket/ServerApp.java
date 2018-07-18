package com.malex.lecture_17_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.IntStream;

public class ServerApp
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(3000);

        // Listens for a connection to be made to this socket and accepts iit. The method blocks until a connection is made.
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        IntStream.range(0, 9).forEach(item ->
        {
            try
            {
                String str = bufferedReader.readLine();
                System.out.println(str);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        });

    }
}
