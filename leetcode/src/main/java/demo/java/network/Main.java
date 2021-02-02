package demo.java.network;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        TcpServer server = new TcpServer(922);
        server.start();


        TcpClient client = new TcpClient(922);
        String res = client.sendAndClose("abcd");

        System.out.println(res);


    }
}
