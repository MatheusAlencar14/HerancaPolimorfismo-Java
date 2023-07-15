package application;

import entities.Circle;
import entities.Color;
import entities.Rectangle;
import entities.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ProgramShapeAbstratas {

    public static void main(String[] args) {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Shape> shapes = new ArrayList<>();

        System.out.print("Digite o número de figuras: ");
        int fig = sc.nextInt();

        for (int i = 0; i < fig; i++) {
            System.out.println("Dados da " + (i+1) + "ª figura: ");
            System.out.print("Retângulo ou Cículo? ");
            char tipo = sc.next().charAt(0);
            System.out.print("Cor: ");
            Color color = Color.valueOf(sc.next());
            if (tipo == 'r') {
                System.out.print("Largura: ");
                double width = sc.nextDouble();
                System.out.print("ALtura: ");
                double height = sc.nextDouble();
                shapes.add(new Rectangle(color, width, height));
            } else {
                System.out.print("Raio: ");
                double radius = sc.nextDouble();
                shapes.add(new Circle(color, radius));
            }
        }

        System.out.println();
        System.out.println("Áreas das figuras: ");
        for (Shape sh : shapes) {
            System.out.println(String.format("%.2f", sh.area()));
        }

        sc.close();
    }
}
