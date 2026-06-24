import java.util.Scanner;

/**
 * VERSIÓN 3 - Programa final para producción.
 * - Lee tres notas.
 * - Valida que cada nota esté entre 0 y 20.
 * - Calcula el promedio como double para evitar pérdida de decimales.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nota1 = leerNota(sc, 1);
        int nota2 = leerNota(sc, 2);
        int nota3 = leerNota(sc, 3);

        double promedio = calcularPromedio(nota1, nota2, nota3);
        System.out.println("El promedio es: " + promedio);

        sc.close();
    }

    public static int leerNota(Scanner sc, int numero) {
        int nota;
        do {
            System.out.print("Ingrese nota " + numero + " (0-20): ");
            nota = sc.nextInt();
        } while (nota < 0 || nota > 20);
        return nota;
    }

    public static double calcularPromedio(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }
}
