package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

public class GUI  extends JFrame implements ActionListener{

JTextField txf_name, txf_weight, txf_price, txf_date;
    JTextArea txa_description, txa_inf;
    JLabel lb_1, lb_2, lb_3, lb_name, lb_weight, lb_price, lb_date, lb_description;
    JButton btn;
    JList list;
    DefaultListModel model;

    public GUI() {
        setTitle("Учет товара");
        setVisible(false);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel container = new JPanel(null);
        setContentPane(container);

        txf_name = new JTextField(); txf_weight = new JTextField();
        txf_price = new JTextField(); txf_date = new JTextField();
        txf_name.setBounds(50, 70, 250, 25);
        txf_weight.setBounds(50, 130, 250, 25);
        txf_price.setBounds(50, 190, 250, 25);
        txf_date.setBounds(50, 250, 250, 25);

        txa_description = new JTextArea(); txa_inf = new JTextArea();
        txa_description.setBounds(50, 310, 250, 75);
        txa_description.setLineWrap(true);
        txa_inf.setBounds(350, 310, 300, 75);
        txa_inf.setLineWrap(true);

        btn = new JButton("Добавить");
        btn.setBounds(200, 410, 100, 25);
        btn.addActionListener(this);

        lb_1 = new JLabel("Данные о товаре"); lb_2 = new JLabel("Список товаров"); lb_3 = new JLabel("Сведения о продукте");
        lb_name = new JLabel("Наименование :"); lb_weight = new JLabel("Вес (грамм) :");
        lb_price = new JLabel("Цена :"); lb_date = new JLabel("Дата поступления :"); lb_description = new JLabel("Описание :");
        lb_1.setBounds(50, 20, 200, 25); lb_2.setBounds(350, 20, 200, 25); lb_3.setBounds(350, 285, 200, 25);
        lb_name.setBounds(50, 45, 250, 25); lb_weight.setBounds(50, 105, 250, 25);
        lb_price.setBounds(50, 165, 250, 25); lb_date.setBounds(50, 225, 250, 25);
        lb_description.setBounds(50, 285, 250, 25);

        list = new JList(); model = new DefaultListModel();
        list.setBounds(350, 70, 300, 100);
        list.setModel(model);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Object element = list.getSelectedValue();
                txa_inf.setText(((Product)element).print());
            }
        });

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("D:\\ПСП\\ЛР 5.2\\Product.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String parts[] = line.split(":");
                String subline[] = parts[0].split(" ");
                String date[] = subline[3].split("\\.");
                Product obj = new Product(subline[0], Double.parseDouble(subline[1]), Double.parseDouble(subline[2]), Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]), parts[1]);
                products.add(obj);
                model.addElement(obj);
            }
            reader.close();
        }
        catch (IOException ex) { System.out.println(ex.getMessage()); }
        catch (NumberFormatException ex) { System.out.println(ex.getMessage()); }

        container.add(txf_name); container.add(txf_weight);
        container.add(txf_price); container.add(txf_date);
        container.add(txa_description);
        container.add(btn);
        container.add(lb_1); container.add(lb_2); container.add(lb_3); container.add(txa_inf);
        container.add(lb_name); container.add(lb_weight); container.add(lb_price); container.add(lb_date); container.add(lb_description);
        container.add(list);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        GregorianCalendar new_date = new GregorianCalendar(); new_date.setTime(new Date());
        if (e.getActionCommand().equals("Добавить")) {
            txf_date.setText(Product.format(new_date));
            btn.setText("Сохранить");
        }
        if (e.getActionCommand().equals("Сохранить")) {
            Product obj = new Product(txf_name.getText(), Double.parseDouble(txf_weight.getText()), Double.parseDouble(txf_price.getText()), new_date.getTime(), txa_description.getText());
            products.add(obj);
            model.addElement(obj);
            BufferedWriter reader;
            try {
                reader = new BufferedWriter(new FileWriter("D:\\ПСП\\NetBeans\\GUI\\Product.txt", true));
                reader.newLine();
                reader.write(obj.print());
                reader.close();
            }
            catch (IOException ex) { System.out.println(ex.getMessage()); }
            catch (NumberFormatException ex) { System.out.println(ex.getMessage()); }
            txf_name.setText(""); txf_weight.setText(""); txf_price.setText("");
            txf_date.setText(""); txa_description.setText("");
            btn.setText("Добавить");
        }
    }

    static Vector<Product> products;
    
    public static void main(String[] args) {
        products = new Vector<>();

        for(Product item : products) {
            item.print();
        }
        new GUI().setVisible(true);
    }
}
