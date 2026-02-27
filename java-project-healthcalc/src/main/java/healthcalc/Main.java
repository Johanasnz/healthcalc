package healthcalc;

import healthcalc.exceptions.InvalidHealthDataException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HealthCalc calculator = new HealthCalcImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- CALCULADORA DE ÍDINCE DE MASA CORPORAL (BMI - Versión FULL) ---");
        
        try {
            System.out.print("Introduce tu peso (kg): ");
            double weight = scanner.nextDouble();

            System.out.print("Introduce tu altura (m): ");
            double height = scanner.nextDouble();

            double bmi = calculator.bmi(weight, height);
            String clasificacion = calculator.bmiClassification(bmi);

            System.out.println("\n--- RESULTADOS ---");
            System.out.printf("Valor BMI: %.2f kg/m2\n", bmi);
            System.out.println("Clasificación OMS (FULL): " + clasificacion);

        } catch (InvalidHealthDataException e) {
            System.err.println("\nERROR DE DATOS: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\nERROR: Entrada no válida.");
        } finally {
            scanner.close();
            System.out.println("\nSaliendo del programa...");
        }
    }
}
