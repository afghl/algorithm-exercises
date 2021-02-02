package demo.java.network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TcpClient {

    private Socket socket;

    public TcpClient(int targetPort) {
        try {
            this.socket = new Socket("localhost", targetPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sendAndClose(String message) throws IOException {
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outputStream.writeBytes(message + '\n');
        String res = reader.readLine();
        socket.close();
        return res;
    }
}
