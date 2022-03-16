public class Main {
    public static void main(String[] args) {
        System.out.println("����� ������");
        System.out.println("������ �����:");
        for (int i = 11; i <= 30; i++) {
            if(i % 2 == 0) System.out.println(i);
        }

        System.out.println("����� ������");
        Patient patient1 = new Patient();
        Patient patient2 = new Patient("������", "�������", 30);

        WriterInfo writer = new WriterInfo();

        patient1.printAllInf();
        patient2.printAllInf();

        patient1.setSurname("�������");
        patient1.setGender("dcsdv");
        patient1.setAge(20);

        patient1.printInf();
        patient1.setGender("�������");
        patient1.printInf();

        writer.outputInf((patient1));
    }
}

class Patient {
    private String surname;
    private String gender;
    private int age;

    public Patient() {
        surname = "N/A";
        gender = "N/A";
        age = 0;
    }
    public Patient(String s, String g, int a) {
        surname = s;
        gender = g;
        age = a;
    }

    //Setter
    public void setSurname(String s) {surname = s;}
    public void setGender(String g) {
        if(g == "�������" || g == "�������" || g == "�������" || g == "�������") gender = g;
        else System.out.println("������� ������ �������� ����");
    }
    public void setAge(int a) {
        if(a < 0) System.out.println("������� ������ �������� ����");
        else age = a;
    }

    //Getter
    public String getSurname() {return surname;}
    public String getGender() {return gender;}
    public int getAge() {return age;}

    //Output information about Patient
    public void printAllInf() {
        System.out.println(surname + " (" + gender + ") " + age + " ���");
    }
    public void printInf() {
        System.out.print(surname + ", " + age + " ���, ");
        if(gender == "�������" || gender == "�������") System.out.println("���.");
        if(gender == "�������" || gender == "�������") System.out.println("���.");
        else System.out.println("�����.");
    }
}
class WriterInfo {
    public void outputInf(Patient obj) {
        System.out.println("�������� � ��������");
        System.out.println("�������  : " + obj.getSurname() + '\n' +
                           "���      : " + obj.getGender() + '\n' +
                           "�������  : " + obj.getAge() + " ���");
    }
}
