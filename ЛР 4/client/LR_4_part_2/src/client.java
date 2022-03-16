import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client {
    public final static int SERVICE_PORT = 50001;
    public static void main(String[] args) throws IOException{
        try{
            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName("localhost");

            byte[] sendingDataBuffer = new byte[1024];
            byte[] receivingDataBuffer = new byte[1024];

            Scanner in = new Scanner(System.in);

            float x = 0, y = 0, z = 0;
            System.out.println("Введите значения параметров функции");
            System.out.print("\tx = "); x = in.nextFloat();
            System.out.print("\ty = "); y = in.nextFloat();
            System.out.print("\tz = "); z = in.nextFloat();

            String str = Float.toString(x) + ' ' + Float.toString(y) + ' ' + Float.toString(z);

            sendingDataBuffer = str.getBytes();

            DatagramPacket sendingPacket = new DatagramPacket(sendingDataBuffer,sendingDataBuffer.length,IPAddress, SERVICE_PORT);

            clientSocket.send(sendingPacket);

            DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer,receivingDataBuffer.length);
            clientSocket.receive(receivingPacket);

            Double receivedData = Double.parseDouble(new String(receivingPacket.getData()));
            System.out.println("Значение функции σ = " + Math.round(receivedData * 100.0) / 100.0);

            clientSocket.close();
        }
        catch(SocketException e) { e.printStackTrace(); }
    }
}