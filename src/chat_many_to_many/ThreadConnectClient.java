package chat_many_to_many;

import java.io.*;
import java.net.Socket;

public class ThreadConnectClient extends Thread {
    private Socket sock;

    public ThreadConnectClient(Socket s) throws IOException {
        sock = s;
        System.out.println("new user IP :" + s.getInetAddress().toString());
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = sock.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataInputStream das = new DataInputStream(inputStream);

        while(true){
            String message = null;
            try {
                message = das.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(message);
        }

    }
}
