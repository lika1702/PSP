import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame {
    public Main() {
        setTitle("Движение треугольников");
        setSize(600, 600);
        setVisible(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Установка значка приложения
        try { setIconImage(ImageIO.read(new File("D:\\ПСП\\ЛР 6\\img\\icon.jpg"))); }
        catch(IOException exc) {}

        JPanel content = new JPanel(new BorderLayout());
        setContentPane(content);

        ToolBar tools = new ToolBar();

        content.add(tools, BorderLayout.NORTH);
        content.add(new Image());
    }

    private class ToolBar extends JMenuBar {
        public ToolBar() {
            setLayout(new FlowLayout());

            JButton button_left = new JButton("Курсор влево");
            JButton button_right = new JButton("Курсор вправо");
            button_left.setSize(new Dimension(100, 50));
            button_right.setSize(new Dimension(100, 50));

            JButton button_run = new JButton("Пуск");
            JButton button_stop = new JButton("Стоп");
            button_run.setSize(new Dimension(100, 50));
            button_stop.setSize(new Dimension(100, 50));

            ButtonActionListener run = new ButtonActionListener();
            button_run.addActionListener(run);
            button_stop.addActionListener(run);
            button_left.addActionListener(run);
            button_right.addActionListener(run);
            this.add(button_left);
            this.add(button_right);
            this.add(button_run);
            this.add(button_stop);
        }
    }

    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Пуск")) {
                run = true;
                Thread rotate = new Thread(new Rotate());
                rotate.start();
            }
            if(e.getActionCommand().equals("Стоп")) { run = false; }
            if(e.getActionCommand().equals("Курсор влево")) { side = true; }
            if(e.getActionCommand().equals("Курсор вправо")) { side = false; }
        }
    }

    private class Image extends JPanel {
        public Image() {
            System.out.println("1");
            try {
                image_1 = ImageIO.read(new File("D:\\ПСП\\ЛР 6\\img\\triangle_1.png"));
                image_2 = ImageIO.read(new File("D:\\ПСП\\ЛР 6\\img\\triangle_2.png"));
                image_3 = ImageIO.read(new File("D:\\ПСП\\ЛР 6\\img\\triangle_3.png"));
                image_4 = ImageIO.read(new File("D:\\ПСП\\ЛР 6\\img\\triangle_4.png"));
                image_5 = ImageIO.read(new File("D:\\ПСП\\ЛР 6\\img\\triangle_5.png"));
            }
            catch (IOException exc) {};
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.rotate(theta, getWidth()/2, getHeight()/2);
            graphics2D.drawImage(image_1, (getWidth() - image_1.getWidth())/2, (getHeight() - image_1.getHeight())/2, this);
            graphics2D.drawImage(image_2, 0, 0, this);
            graphics2D.drawImage(image_3, 30, 250, this);
            graphics2D.drawImage(image_4, 400, 0, this);
            graphics2D.drawImage(image_5, getWidth() - image_5.getWidth(), getHeight() - image_5.getHeight(), this);
        }
    }

    public class Rotate implements Runnable{
        @Override
        public void run() {
            while (run == true) {
                if (!side) theta += 0.5;
                if (side) theta -= 0.5;
                repaint();
                try { Thread.sleep(50); }
                catch (Exception exc) {};
            }
        }
    }

    BufferedImage image_1, image_2, image_3, image_4, image_5;

    private boolean run, side;
    double theta = 0.0;

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}