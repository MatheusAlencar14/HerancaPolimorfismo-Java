package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramTaxPayer {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> lista = new ArrayList<>();

        System.out.print("Digite o número de contribuintes: ");
        int cont = sc.nextInt();

        for (int i = 0; i < cont; i++) {
            System.out.println("Dados do " + (i+1) + "º contribuinte: ");
            System.out.print("Pessoa Física ou Empresa? (p/e): ");
            char tipo = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Rendimento anual: ");
            double annualIncome = sc.nextDouble();
            if (tipo == 'p') {
                System.out.print("Gastos com saúde: ");
                double healthExpenditures = sc.nextDouble();
                lista.add(new Individual(name, annualIncome, healthExpenditures));
            } else {
                System.out.print("Número de funcionários: ");
                int numberOfEmployees = sc.nextInt();
                lista.add(new Company(name, annualIncome, numberOfEmployees));
            }
        }

        System.out.println();
        System.out.println("Impostos Pagos: ");

        for (TaxPayer tp : lista) {
            System.out.println(tp.getName() + ": R$ " + String.format("%.2f", tp.tax()));
        }

        double soma = 0;
        for (TaxPayer tp : lista) {
            soma = soma + tp.tax();
        }

        System.out.println();
        System.out.println("Total de impostos: " + String.format("%.2f", soma));

        sc.close();
    }
}