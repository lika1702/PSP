import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientAccepted = null;
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            System.out.println("Connection starting...");
            serverSocket = new ServerSocket(3000);
            clientAccepted = serverSocket.accept();
            System.out.println("Connection established...");
            inputStream = new ObjectInputStream(clientAccepted.getInputStream());
            outputStream = new ObjectOutputStream(clientAccepted.getOutputStream());
            float clientMessageRecieved = (float) inputStream.readObject();

            while (clientMessageRecieved != 0) {
                System.out.println("Salary recieved: " + clientMessageRecieved + "BYN");
                float tax = 0;
                if(clientMessageRecieved < 100000) { tax = (float)(clientMessageRecieved * 0.05); }
                if(clientMessageRecieved >= 100000 && clientMessageRecieved < 500000) { tax = (float)(clientMessageRecieved * 0.1); }
                if(clientMessageRecieved >= 500000) { tax = (float)(clientMessageRecieved * 0.15);}
                outputStream.writeObject(tax);
                clientMessageRecieved = (float) inputStream.readObject();
            }
        }
        catch (Exception e) { }
        finally {
            try {
                inputStream.close();
                outputStream.close();
                clientAccepted.close();
                serverSocket.close();
            }
            catch (Exception e) { e.printStackTrace(); }
        }
    }
}
