package chat_many_to_many;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4449);

        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        while (true){
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();

            dos.writeUTF(message);
            dos.flush();
        }
    }
}
