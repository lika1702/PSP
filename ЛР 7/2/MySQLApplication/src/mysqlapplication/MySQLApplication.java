package mysqlapplication;

public class MySQLApplication {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InsertTable().setVisible(true);
                } catch (Exception e) {
                }
            }
        });
    }
}
