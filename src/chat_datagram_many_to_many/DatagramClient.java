package chat_datagram_many_to_many;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class DatagramClient {

    public static void main(String[] args) throws Exception {
        byte[] sendData;
        byte[] receiveData = new byte[1024];

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        System.out.println("Enter text : ");
        System.out.println("============");
        while (true) {
            String message = bufferedReader.readLine();
            sendData = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, ServerConsts.PORT);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, 0, receiveData.length);
            clientSocket.receive(receivePacket);
        }
    }
}

