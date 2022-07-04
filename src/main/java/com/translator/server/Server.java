package com.translator.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {

            while (true) {
                Socket socket = serverSocket.accept();

                new Thread(() -> GetRequest(socket)).start();

            }


        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void GetRequest(Socket socket) {
        try(BufferedReader input = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

            PrintWriter output = new PrintWriter(socket.getOutputStream());
        ) {

            while (input.ready()) {
                System.out.println(input.readLine());
            }

            output.println("HTTP/1.1 200 OK");
            output.println("Content-type: text/html; charset=utf-8");
            output.println("");
            output.println("<h3>server work<h3>");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
