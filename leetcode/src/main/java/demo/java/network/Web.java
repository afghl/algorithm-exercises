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
        String buffer = null;
        while ((buffer = br.readLine()) != null && !buffer.equals("")) {
            System.out.println(buffer);
        }

        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        bw.write("HTTP/1.1 200 OK\n");
        bw.write("Content-Type: text/html; charset=UTF-8\n\n");
        bw.write("<html>\n" + "<head>\n" + "    <title>first page</title>\n"
                + "</head>\n" + "<body>\n" + "    <h1>Hello Web Server!</h1>\n"
                + "</body>\n" + "</html>\n");
        bw.flush();
        bw.close();

        br.close();
        socket.close();
        ss.close();
    }
}
