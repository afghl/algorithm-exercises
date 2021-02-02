package demo.java.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Web {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(911);
        Socket socket = ss.accept();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        String input = "";
        String buffer;
        while ((buffer = br.readLine()) != null && !buffer.equals("")) {
            System.out.println(buffer);
            input += buffer;
        }

        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        bw.write(input.toUpperCase());
        bw.flush();
        bw.close();

        br.close();
        socket.close();
        ss.close();
    }
}
