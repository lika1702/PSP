package classPackage;

public class Employee {
    private String surname;
    private float salary;
    private boolean isChildren;
    static public int number = 0;

    //Constructors
    public Employee() {
        surname = new String("N/A");
        salary = 0;
        isChildren = false;
        number++;
    }
    public Employee(String surname, float salary, boolean isChildren) {
        this.surname = surname;
        this.salary = salary;
        this.isChildren = isChildren;
        number++;
    }
    public Employee(String surname, float salary) {
        this.surname = surname;
        this.salary = salary;
        number++;
    }
    public Employee(Employee obj) {
        surname = obj.surname;
        isChildren = obj.isChildren;
        salary = obj.salary;
        number++;
    }

    //Getters
    public String getSurname() {return surname;}
    public float getSalary() {return salary;}
    public boolean getIsChildren() {return isChildren;}

    //Setters
    public void setSurname(String surname) {this.surname = surname;}
    public void setSalary(float salary) {this.salary = salary;}
    public void setIsChildren(boolean isChildren) {this.isChildren = isChildren;}

    //Printers
    public void printAllInf() {
        if(isChildren) System.out.println(surname + " (з/пл " + salary + ") дети: есть");
        else System.out.println(surname + " (з/пл " + salary + ") дети: нет");
    }

    //Static-methods
    public static int quantityWithChildren(Employee[] mas) {
        int quantity = 0;
        for (int i = 0; i < mas.length; i++)
            if(mas[i].isChildren) quantity++;
        return quantity;
    }
    public static float avgSalary(Employee[] mas) {
        float summarySalary = 0;
        for (int i = 0; i < mas.length; i++)
            summarySalary += mas[i].salary;
        return summarySalary/mas.length;
    }
}