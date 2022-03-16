import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] arg) {
        try {
            System.out.println("server connecting....");
            Socket clientSocket = new Socket("127.0.0.1",3000);
            System.out.println("connection established....");
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream  cois = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("Enter employee's salary to send to server \n\t('0' − programme terminate)");
            try{
            float clientMessage = Float.parseFloat(stdin.readLine());
            System.out.println("you've entered: " + clientMessage + " BYN");

            while(clientMessage != 0) {
                coos.writeObject(clientMessage);
                System.out.println("~server returns tax~: " + cois.readObject() + "BYN");
                System.out.println("---------------------------");

                clientMessage = Float.parseFloat(stdin.readLine());
                System.out.println("you've entered: " + clientMessage + " BYN");
            }

            coos.close();
            cois.close();
            clientSocket.close();
            } catch(NumberFormatException e) {
                System.out.println("Неверный ввод числа");
            }

        } catch(Exception e)	{ e.printStackTrace(); }
    }
}