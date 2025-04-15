package search;

import java.util.Scanner;

public class HealthDiagnosisSimulator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Sorted array of diseases by severity (lowest to highest)
        Disease[] diseases = {
                new Disease("Common Cold", 1),
                new Disease("Seasonal Flu", 1),
                new Disease("Bronchitis", 2),
                new Disease("Pneumonia", 2),
                new Disease("COVID-19", 2),
                new Disease("Tuberculosis", 3),
                new Disease("Lung Cancer", 3)
        };

        // Ask for the patient's symptom severity
        System.out.println("Welcome to the Health Diagnosis Simulator 🩺");
        System.out.println("On a scale of 1 (Mild) to 3 (Severe), how severe are the symptoms?");
        int patientSeverity = scanner.nextInt();

        // Use the binary search method to find a matching disease
        Disease diagnosis = findDiseaseBySeverity(diseases, patientSeverity);


        if (diagnosis != null) {
            System.out.println("🩺 Possible diagnosis: " + diagnosis.name);
        } else {
            System.out.println("❌ No matching diagnosis found for that severity.");
        }

        scanner.close();

    }

    // method that performs Binary Search on disease array
     static Disease findDiseaseBySeverity(Disease[] diseases, int patientSeverity) {
         int low = 0;
         int high = diseases.length - 1;

         while (low <= high) {
             int mid = (low + high) / 2;
             System.out.println("Checking for: " + diseases[mid].name + " (Severity: " + diseases[mid].severity + ")");

             if (diseases[mid].severity == patientSeverity) {
                 return diseases[mid]; // Match found
             } else if (diseases[mid].severity < patientSeverity) {
                 low = mid + 1; // Go right
             } else {
                 high = mid - 1; // Go left
             }
         }


        return null; // No match
    }


}
