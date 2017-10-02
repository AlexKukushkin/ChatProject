package chat_many_to_many;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    static ServerSocket socket;
    public static List<ThreadConnectClient> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        socket = new ServerSocket(4449);
        System.out.println("Waiting for clients...");

        while (true) {
            ThreadConnectClient client = new ThreadConnectClient(socket.accept());
            clients.add(client);
            client.start();
        }
    }
}
