package mainPackage;
import classPackage.Employee;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee();
        employees[1] = new Employee("Иванов", 598.14F, true);
        employees[2] = new Employee("Иванова", 600.4F, true);
        employees[3] = new Employee(employees[2]);
        employees[4] = new Employee("Петров", 740.55F, false);

        for(int i = 0; i < employees.length; i++) {
            employees[i].printAllInf();
        }

        System.out.println(("Количество работников: " + Employee.number));
        System.out.println("Количество работников с детьми: " + Employee.quantityWithChildren(employees));
        System.out.println("Средняя заработная плата: " + Employee.avgSalary(employees));
    }
}
