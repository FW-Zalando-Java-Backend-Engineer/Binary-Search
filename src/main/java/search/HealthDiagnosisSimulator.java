package search;

import java.util.ArrayList;
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
        // Get all matching diseases with that severity
        ArrayList<Disease> diagnosises = findDiseaseBySeverity(diseases, patientSeverity);

        // Show results
        if (diagnosises.isEmpty()) {
            System.out.println("❌ No matching diagnosis found for that severity.");
        } else {
            System.out.println("🩺 Possible diagnoses:");
            for (Disease d : diagnosises) {
                System.out.println(" - " + d.name);
            }
        }

        scanner.close();

    }

     /**
      * @description Binary search to find *one* match, then expand left and right
      * to find *all* diseases with the same severity.
      * @param diseases : ascending sorted array by severity
      * @param patientSeverity : the symptoms severity level
      * @return ArrayList<Disease> : All diseases with the matching severity.
      * */
     static ArrayList<Disease> findDiseaseBySeverity(Disease[] diseases, int patientSeverity) {
         ArrayList<Disease> result = new ArrayList<>(); // Empty

         int low = 0;
         int high = diseases.length - 1;
         int foundIndex = -1; // -1: means no match

         // Standard binary search to find one match
         while (low <= high) {
             int mid = (low + high) / 2;
             System.out.println("Checking for: " + diseases[mid].name + " (Severity: " + diseases[mid].severity + ")");

             if (diseases[mid].severity == patientSeverity) {
                 foundIndex = mid;
                 break; // one match found
             } else if (diseases[mid].severity < patientSeverity) {
                 low = mid + 1; // Go right
             } else {
                 high = mid - 1; // Go left
             }
         }
         // If no match found, return empty list
         if (foundIndex == -1) {
             return result;
         }

         // Explore left and right from the found index
         int left = foundIndex;
         int right = foundIndex+1; // excluding redundant element



         // Move left to find other matches
         while(left >=0 && diseases[left].severity == patientSeverity) {
             result.add(diseases[left]); // reducing use of extra loop
             left--;
         }


         //  Move right to find other matches
         while (right < diseases.length && diseases[right].severity == patientSeverity){
             result.add(diseases[right]); // reducing use of extra loop
             right++;
         }

         // Add all matches to result (from left+1 to right-1)
        //         for (int i = left + 1; i < right; i++) {
        //             result.add(diseases[i]);
        //         }

        return result;
    }


}
