package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ProgramProduct {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.print("Digite o número de produtos: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Dados do " + (i + 1) + "° produto: ");
            System.out.print("Comum, usado ou importado? (c/u/i): ");
            char tipo = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Preço: ");
            double price = sc.nextDouble();

            if (tipo == 'u') {
                System.out.print("Data de fabricação: ");
                Date manufactureDate = sdf.parse(sc.next());
                products.add(new UsedProduct(name, price, manufactureDate));
            } else if (tipo == 'i') {
                System.out.print("Taxa alfandegária: ");
                double customsFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));
            } else {
                products.add(new Product(name, price));
            }
        }

        System.out.println();
        System.out.println("Etiqueta de preço: ");
        for (Product pd : products) {
            System.out.println(pd.priceTag());
        }

        sc.close();
    }
}
