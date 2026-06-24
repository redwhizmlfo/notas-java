/**
 * Pruebas simples sin JUnit para facilitar el laboratorio.
 * Se ejecutan con: java -ea -cp out MainTest
 */
public class MainTest {
    public static void main(String[] args) {
        probarPromedioExacto();
        probarPromedioDecimal();
        probarRangoPermitido();
        System.out.println("Todas las pruebas pasaron correctamente.");
    }

    private static void probarPromedioExacto() {
        assert Main.calcularPromedio(10, 10, 10) == 10.0 : "Error en promedio exacto";
    }

    private static void probarPromedioDecimal() {
        double esperado = 13.333333333333334;
        double obtenido = Main.calcularPromedio(20, 0, 20);
        assert Math.abs(obtenido - esperado) < 0.000001 : "Error en promedio decimal";
    }

    private static void probarRangoPermitido() {
        assert Main.calcularPromedio(0, 20, 10) == 10.0 : "Error con extremos 0 y 20";
    }
}
