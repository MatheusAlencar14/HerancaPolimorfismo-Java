package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramEmployee {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> emp = new ArrayList<>();

        System.out.print("Digite o número de funcionários: ");
        int func = sc.nextInt();

        for (int i = 0; i < func; i++) {
            System.out.println("Dados do Funcionário #" + (i + 1) + ": ");
            System.out.print("Terceirizado? (s/n): ");
            char terc = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Horas: ");
            int hours = sc.nextInt();
            System.out.print("Valor por hora: ");
            double valuePerHour = sc.nextDouble();
            if (terc == 's') {
                System.out.print("Custo additional: ");
                double additionalCharge = sc.nextDouble();
                Employee employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                emp.add(employee);
            } else {
                Employee employee = new Employee(name, hours, valuePerHour);
                emp.add(employee);
            }
        }

        System.out.println();
        System.out.println("Pagamentos: ");
        for (Employee em : emp) {
            System.out.println(em);
        }
        sc.close();;
    }
}
