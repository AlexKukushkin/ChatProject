package chat_datagram_many_to_many;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class DatagramServer {
    public static void main(String args[]) throws Exception {
        byte[] receiveData = new byte[1024];
        byte[] sendData;

        DatagramSocket serverSocket = new DatagramSocket(ServerConsts.PORT);
        System.out.println("Waiting for Client...");
        System.out.println("From Client : ");
        System.out.println("=============");
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println(message);

            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            String capitalizedSentence = message.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            //while (true) {
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
            //}
        }
    }
}
