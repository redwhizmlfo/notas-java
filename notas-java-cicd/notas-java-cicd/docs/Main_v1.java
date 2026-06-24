import java.util.Scanner;

/**
 * VERSIÓN 1 - Sin validación de notas.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nota1, nota2, nota3, promedio;

        System.out.print("Ingrese nota 1: ");
        nota1 = sc.nextInt();
        System.out.print("Ingrese nota 2: ");
        nota2 = sc.nextInt();
        System.out.print("Ingrese nota 3: ");
        nota3 = sc.nextInt();

        promedio = (nota1 + nota2 + nota3) / 3;
        System.out.println("El promedio es: " + promedio);
        sc.close();
    }
}
