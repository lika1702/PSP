import javax.swing.text.MaskFormatter;
import java.net.*;
import java.io.*;

public class server {
    public final static int SERVICE_PORT = 50001;

    public static void main(String[] args) throws IOException {
        try {
            DatagramSocket serverSocket = new DatagramSocket(SERVICE_PORT);
            byte[] receivingDataBuffer = new byte[1024];
            byte[] sendingDataBuffer = new byte[1024];

            DatagramPacket inputPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
            System.out.println("Ожидание подключения клиента...");

            serverSocket.receive(inputPacket);

            String receivedData = new String(inputPacket.getData());
            float x = Float.parseFloat(receivedData.substring(0, receivedData.indexOf(" ")));
            float y = Float.parseFloat(receivedData.substring(receivedData.indexOf(" ") + 1, receivedData.lastIndexOf(" ")));
            float z = Float.parseFloat(receivedData.substring(receivedData.lastIndexOf(" ") + 1));

            System.out.println("Получено от клиента :" + "\n\tx = " + x + "\n\ty = " + y + "\n\tz = " + z);

            double result = 2 * Math.cos(x - Math.PI / 6) /
                    (Math.pow(Math.E, 0.5) + Math.pow(Math.sin(y), 2)) * (1 + Math.pow(z, 2) / (3 - Math.pow(z, 2) / 5));

            sendingDataBuffer = Double.toString(result).getBytes();

            InetAddress senderAddress = inputPacket.getAddress();
            int senderPort = inputPacket.getPort();

            DatagramPacket outputPacket = new DatagramPacket(sendingDataBuffer, sendingDataBuffer.length, senderAddress, senderPort);

            serverSocket.send(outputPacket);
            serverSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
