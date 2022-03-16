import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.net.*;

public class client extends Frame implements ActionListener, WindowListener {
    TextField tf_adress, tf_port, tf1, tf2, tf3, tf4, tf5, tf6;
    TextArea ta;
    Label la_adress, la_port, la2, la3, la4;
    Socket sock = null;
    InputStream is = null;
    OutputStream os = null;

    public static void main(String args[]) {
        client c = new client();
        c.GUI();
    }

    private void GUI() { // super("Клиент");
        setTitle("Проверка на палиндром");
        tf_adress = new TextField("127.0.0.1");
        tf_port = new TextField("1024");
        tf1 = new TextField();
        tf2 = new TextField();
        tf3 = new TextField();
        tf4 = new TextField();
        tf5 = new TextField();
        tf6 = new TextField();
        ta = new TextArea();
        la_adress = new Label("IP ADRESS");
        la_port = new Label("port");
        la2 = new Label("Отправляемые данные");
        la3 = new Label("Результат");
        la4 = new Label(" ");
        Button btn = new Button("Подключиться");
        Button btn1 = new Button("Отправить");
        tf_adress.setBounds(150, 100, 100, 25);
        tf_port.setBounds(300, 100, 100, 25);
        tf1.setBounds(150, 200, 100, 25);
        tf2.setBounds(270, 200, 100, 25);
        tf3.setBounds(390, 200, 100, 25);
        tf4.setBounds(150, 250, 100, 25);
        tf5.setBounds(270, 250, 100, 25);
        tf6.setBounds(390, 250, 100, 25);
        ta.setBounds(150, 350, 340, 150);
        btn.setBounds(20, 100, 100, 25);
        btn1.setBounds(20, 200, 100, 25);
        la_adress.setBounds(150, 75, 100, 25);
        la_port.setBounds(300, 75, 100, 25);
        la2.setBounds(150, 175, 150, 25);
        la3.setBounds(150, 325, 150, 25);
        la4.setBounds(600, 10, 150, 25);
        add(tf_adress); add(tf_port); add(tf1); add(tf2); add(tf3); add(tf4); add(tf5); add(tf6);
        add(btn); add(btn1);
        add(ta);
        add(la_adress); add(la_port); add(la2); add(la3); add(la4);
        setSize(600, 600);
        setVisible(true);
        addWindowListener(this);
        btn.addActionListener(al);
        btn1.addActionListener(this);
        tf1.getText(); tf2.getText(); tf3.getText(); tf4.getText(); tf5.getText(); tf6.getText();
    }

    public void windowClosing(WindowEvent we) {
        if (sock != null && !sock.isClosed()) {
            try { sock.close(); }
            catch (IOException e) { }
        }
        this.dispose();
    }

    public void windowActivated(WindowEvent we) { };
    public void windowClosed(WindowEvent we) { };
    public void windowDeactivated(WindowEvent we) { };
    public void windowDeiconified(WindowEvent we) { };
    public void windowIconified(WindowEvent we) { };
    public void windowOpened(WindowEvent we) { };

    public void actionPerformed(ActionEvent e) {
        if (sock == null) { return; }
        try {
            is = sock.getInputStream();
            os = sock.getOutputStream();
            String words = "";
            words += tf1.getText() + " ";
            words += tf2.getText() + " ";
            words += tf3.getText() + " ";
            words += tf4.getText() + " ";
            words += tf5.getText() + " ";
            words += tf6.getText() + " ";
            os.write(words.getBytes());
            byte[] bytes = new byte[1024];
            is.read(bytes);
            String str = new String(bytes, "UTF-8");
            String[] n = str.split(" ");
            for (int i = 0; i < n.length - 1; i++) {
                ta.append(n[i] + "\n");
            }
        }
        catch (Exception ex) { ex.printStackTrace(); }
        finally {
            try {
                os.close();
                is.close();
                sock.close();
            }
            catch (IOException e1) { e1.printStackTrace(); }
        }
    }

    public void actionPerformed2(ActionEvent e) { }

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
                sock = new Socket(InetAddress.getByName(tf_adress.getText()), Integer.parseInt(tf_port.getText()));
            }
            catch (NumberFormatException e) { }
            catch (UnknownHostException e) { }
            catch (IOException e) { }
        }
    };
}
