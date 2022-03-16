import java.net.*;
import java.io.*;

public class server {
    static int countclients = 0;

    static boolean isPalindrom(String s) {
        if(s == null) return false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public static void main(String args[]) throws IOException {
        ServerSocket sock = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            sock = new ServerSocket(1024);
            while (true) {
                Socket client = sock.accept();
                countclients++;
                System.out.println("=======================================");
                System.out.println("Client " + countclients + " connected");
                is = client.getInputStream();
                os = client.getOutputStream();
                boolean flag = true;
                while (flag) {
                    byte[] bytes = new byte[1024];
                    is.read(bytes);
                    String str = new String(bytes, "UTF-8");
                    String[] words = str.split(" ");
                    String m = "";
                    bytes = new byte[1024];
                    for (int i = 0; i < words.length - 1; i++) {
                        System.out.println("клиент прислал слово " + words[i]);
                        if (isPalindrom(words[i])) { m += words[i] + " "; }
                    }
                    bytes = m.getBytes();
                    os.write(bytes);
                }
            }
        }
        catch (Exception e) { System.out.println("Error " + e.toString()); }
        finally {
            is.close();
            os.close();
            sock.close();
            System.out.println("Client " + countclients + " disconnected");
        }
    }
}
