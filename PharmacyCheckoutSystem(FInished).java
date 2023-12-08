/***************************************************************
* Name : PharmacyCheckoutSystem
* Author: Jhamil Arnold
* Created : 10/14/2023
* Course: CIS152 14065 - Data Structure
* Version: 1.0
* OS: Windows 11
* IDE: Eclipse IDE JAVA
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Description : Pharmacy system checks patient, medication, and cost, ensuring HIPAA compliance.
*            Input: User selects patient and medication, answers if taken before.
*            Output: Total cost and payment; ensures patient name matches.
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.
***************************************************************/

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

class PharmacyCheckoutSystem {

    static class Medication {
        String name;
        String description;
        String notToTakeWith;
        double cost;

        public Medication(String name, String description, String notToTakeWith, double cost) {
            this.name = name;
            this.description = description;
            this.notToTakeWith = notToTakeWith;
            this.cost = cost;
        }
    }

    public static void insertionSort(String[] names, String[] birthdays) {
        for (int i = 1; i < names.length; i++) {
            String currentName = names[i];
            String currentBirthday = birthdays[i];
            int j = i - 1;

            while (j >= 0 && names[j].compareTo(currentName) > 0) {
                names[j + 1] = names[j];
                birthdays[j + 1] = birthdays[j];
                j--;
            }

            names[j + 1] = currentName;
            birthdays[j + 1] = currentBirthday;
        }
    }

    public static void main(String[] args) {
        // Create a list of patients with names and birthdays
        String[] patientNames = {"Aaron Baron", "Ford Ferrari", "Charlie Oxford", "Emily Davis", "Grace Parker"};
        String[] patientBirthdays = {"10-14-87", "05-20-91", "03-05-80", "12-30-95", "09-10-88"};

        // Sort patient names and birthdays
        insertionSort(patientNames, patientBirthdays);

        // Generate a list of medications
        ArrayList<Medication> medications = new ArrayList<>();
        medications.add(new Medication("Lisinopril", "used for high blood pressure", "not good to take with potassium supplements", 10.0));
        medications.add(new Medication("Hydrochlorothiazide", "used for fluid retention", "not good to take with alcohol", 15.0));
        medications.add(new Medication("Aspirin", "used as a pain reliever", "not good to take on an empty stomach", 5.00));
        medications.add(new Medication("Simvastatin", "used to lower cholesterol", "not good to take with grapefruit", 12.00));
        medications.add(new Medication("Metformin", "used to treat diabetes", "not good to take with alcohol", 8.00));
        medications.add(new Medication("Levothyroxine", "used to treat hypothyroidism", "not good to take with soy", 9.00));
        medications.add(new Medication("Amoxicillin", "used to treat bacterial infections", "not good to take with antacids", 7.00));
        medications.add(new Medication("Ibuprofen", "used to reduce pain and inflammation", "not good to take with blood thinners", 6.00));
        medications.add(new Medication("Omeprazole", "used to reduce stomach acid", "not good to take with clopidogrel", 11.00));
        medications.add(new Medication("Atorvastatin", "used to lower cholesterol", "not good to take with grapefruit", 13.00));

        // Randomly select a patient
        Random random = new Random();
        int randomPatientIndex = random.nextInt(patientNames.length);
        String patientName = patientNames[randomPatientIndex];
        String patientBirthday = patientBirthdays[randomPatientIndex];

        // Prompt the user to select a patient
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hello, My name is " + patientName + ", my birthday is " + patientBirthday + ", I would like to pick up my medications please.");
            System.out.println("User: (Choose a patient by typing the corresponding number)");

            // Create a list of patients to display to the user
            for (int i = 0; i < patientNames.length; i++) {
                System.out.println((i + 1) + ". " + patientNames[i] + " (" + patientBirthdays[i] + ")");
            }

            int selectedPatientIndex = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (selectedPatientIndex < 1 || selectedPatientIndex > patientNames.length) {
                System.out.println("Invalid number, Try again");
                continue;
            }

            selectedPatientIndex--; // Adjust to the array index

            if (!patientNames[selectedPatientIndex].equals(patientName)) {
                System.out.println("Wrong patient! It is important to make sure you got the right patient and following HIPAA regulations.");
                continue;
            }

            // Select a medication
            Medication selectedMedication = medications.get(random.nextInt(medications.size()));

            // Ask if the user has had this medication before
            System.out.println("You are picking up " + selectedMedication.name + ", have you had this before? (yes/no)");

            while (true) {
                String userResponse = scanner.nextLine();

                if (userResponse.equalsIgnoreCase("no")) {
                    System.out.println("The pharmacist will speak with you.");

                    // Randomly select a pharmacist
                    String[] pharmacists = {"Dr. Smith", "Dr. Johnson", "Dr. Brown"};
                    String pharmacist = pharmacists[random.nextInt(pharmacists.length)];

                    System.out.println("Pharmacist: Hello, I'm " + pharmacist + ".");
                    System.out.println(selectedMedication.name + " is " + selectedMedication.description);
                    System.out.println("It is " + selectedMedication.notToTakeWith);

                    System.out.printf("Pharmacist: Okay, your total is $%.2f%n", selectedMedication.cost);
                    System.out.printf("%s pays $%.2f%n", patientName, selectedMedication.cost);
                    break;  // Exit the response loop
                } else if (userResponse.equalsIgnoreCase("yes")) {
                    System.out.printf("Okay, your total is $%.2f%n", selectedMedication.cost);
                    System.out.printf("%s pays $%.2f%n", patientName, selectedMedication.cost);
                    break;  // Exit the response loop
                } else {
                    System.out.println("Invalid response. Please enter 'yes' or 'no'.");
                }
            }

            System.out.println("Thank you and have a great day!");
            break;
        }
    }
}
