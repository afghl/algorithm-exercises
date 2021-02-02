package demo.java.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    private ServerSocket serverSocket;
    private HandlePolicy handlePolicy;

    public TcpServer(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            handlePolicy = String::toUpperCase;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        new Thread(() -> {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    String input;
                    input = br.readLine();

                    String output = handlePolicy.handle(input);
                    BufferedWriter bw = new BufferedWriter(
                            new OutputStreamWriter(socket.getOutputStream()));
                    bw.write(output);
                    bw.flush();
                    bw.close();

                    br.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
