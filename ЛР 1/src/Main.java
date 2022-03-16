public class Main {
    public static void main(String[] args) {
        System.out.println("ЧАСТЬ ПЕРВАЯ");
        System.out.println("Четные числа:");
        for (int i = 11; i <= 30; i++) {
            if(i % 2 == 0) System.out.println(i);
        }

        System.out.println("ЧАСТЬ ВТОРАЯ");
        Patient patient1 = new Patient();
        Patient patient2 = new Patient("Иванов", "мужской", 30);

        WriterInfo writer = new WriterInfo();

        patient1.printAllInf();
        patient2.printAllInf();

        patient1.setSurname("Иванова");
        patient1.setGender("dcsdv");
        patient1.setAge(20);

        patient1.printInf();
        patient1.setGender("Женский");
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
        if(g == "мужской" || g == "Мужской" || g == "женский" || g == "Женский") gender = g;
        else System.out.println("Неверно задано значение поля");
    }
    public void setAge(int a) {
        if(a < 0) System.out.println("Неверно задано значение поля");
        else age = a;
    }

    //Getter
    public String getSurname() {return surname;}
    public String getGender() {return gender;}
    public int getAge() {return age;}

    //Output information about Patient
    public void printAllInf() {
        System.out.println(surname + " (" + gender + ") " + age + " лет");
    }
    public void printInf() {
        System.out.print(surname + ", " + age + " лет, ");
        if(gender == "Мужской" || gender == "мужской") System.out.println("муж.");
        if(gender == "Женский" || gender == "женский") System.out.println("жен.");
        else System.out.println("неопр.");
    }
}
class WriterInfo {
    public void outputInf(Patient obj) {
        System.out.println("СВЕДЕНИЯ О ПАЦИЕНТЕ");
        System.out.println("Фамилия  : " + obj.getSurname() + '\n' +
                           "Пол      : " + obj.getGender() + '\n' +
                           "Возраст  : " + obj.getAge() + " лет");
    }
}
