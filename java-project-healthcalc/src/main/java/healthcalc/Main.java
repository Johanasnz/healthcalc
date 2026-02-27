package healthcalc;

import healthcalc.exceptions.InvalidHealthDataException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HealthCalc calculator = new HealthCalcImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CALCULADORA DE SALUD GRUPAL ===");
        System.out.println("1. Calcular BMI (Índice de Masa Corporal) - Versión FULL");
        System.out.println("2. Calcular MAP (Presión Arterial Media)");
        System.out.print("Selecciona una opción: ");

        int opcion = scanner.nextInt();
        
        try {
            if (opcion == 1) {
                //BMI
                System.out.print("Introduce tu peso (kg): ");
                double weight = scanner.nextDouble();

                System.out.print("Introduce tu altura (m): ");
                double height = scanner.nextDouble();

                double bmi = calculator.bmi(weight, height);
                String clasificacion = calculator.bmiClassification(bmi);

                System.out.println("\n--- RESULTADOS ---");
                System.out.printf("Valor BMI: %.2f kg/m2\n", bmi);
                System.out.println("Clasificación OMS (FULL): " + clasificacion);
            
            } else if (opcion == 2) {
                //MAP
                System.out.print("Introduce la Presión Sistólica (PAS): ");
                float pas = scanner.nextFloat();

                System.out.print("Introduce la Presión Diastólica (PAD): ");
                float pad = scanner.nextFloat();

                float map = calculator.calculateMAP(pas, pad);
                String clasificacion = calculator.mapClassification(map);

                System.out.println("\n--- RESULTADOS ---");
                System.out.printf("Valor MAP: %.2f mmHg\n", map);
                System.out.println("Clasificación: " + clasificacion);
            } else {
                System.out.println("Opción no válida.");
            }

        } catch (InvalidHealthDataException e) {
            System.err.println("\nERROR DE DATOS: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\nERROR: Entrada no válida. Por favor, usa números.");
        } finally {
            scanner.close();
            System.out.println("Saliendo del programa...");
        }
    }
}
