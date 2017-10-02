package chat_one_to_one;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4447);
        ServerSocket serverSocket2 = new ServerSocket(4448);
        System.out.println("Waiting for clients...");

        Socket socket = serverSocket.accept();
        Socket socket2 = serverSocket2.accept();

        System.out.println("We've got a client 1 !!");
        System.out.println("We've got a client 2 !!");

        InputStream inputStream = socket.getInputStream();
        DataInputStream das = new DataInputStream(inputStream);

        InputStream inputStream2 = socket2.getInputStream();
        DataInputStream das2 = new DataInputStream(inputStream2);

        while (true) {
            String message = das.readUTF();
            String message2 = das2.readUTF();
            System.out.println(message);
            System.out.println(message2);
        }
    }
}
