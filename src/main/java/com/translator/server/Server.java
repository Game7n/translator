package com.translator.server;

import com.translator.controller.Controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Server {

    public void start() {
        try {

            Controller controller = new Controller();

            String[] data = controller.data().split(" ");

            //String str = "https://translate.yandex.ru/?from=tableau_yabro&lang=\"+data[0]+\"&text=\"+data[1]";

            URL getTranslate = new URL("https://translate.google.com/?hl="+data[0]+"&sl=auto&tl="+data[1]+"&text="+data[2]+"%0A&op=translate");

            //new Thread(() -> Request(socket)).start();

            Request(getTranslate);




        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void Request(URL getTranslate) {
        try(BufferedReader input = new BufferedReader(
                new InputStreamReader(getTranslate.openStream()));

            //PrintWriter output = new PrintWriter(getTranslate.getOutputStream());
        ) {

            while (input.readLine() != null) {
                System.out.println(input.readLine());
            }


//            output.println("HTTP/1.1 200 OK");
//            output.println("Content-type: text/html; charset=utf-8");
//            output.println("");
//            output.println("<h3>server work<h3>");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
