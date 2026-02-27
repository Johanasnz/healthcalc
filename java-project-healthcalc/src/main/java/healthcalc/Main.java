package healthcalc;

import java.util.Scanner;
import healthcalc.exceptions.InvalidHealthDataException;

public class Main {
    public static void main(String[] args) {
        
        HealthCalc calculator = new HealthCalcImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("3. Calculadora de IBW (Peso Ideal)");
        System.out.print("Selecciona una opción: ");

        int opcion = scanner.nextInt();
        
        try {
            if (opcion == 3) {
                //IBW
                System.out.print("Ingrese su altura en cm: ");
                int altura = scanner.nextInt();
                System.out.print("Escriba su sexo (Hombre o Mujer): ");
                String sexo = scanner.next().toLowerCase(); 
                double ibw = calculator.ibw(altura, sexo);
                System.out.println("Su IBW es: " + ibw);
            }
        } catch (InvalidHealthDataException e) {
            System.out.println("\nERROR DE DATOS: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
