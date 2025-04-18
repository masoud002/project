
package HospitalManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient {
    private List<PatientInfo> patientList = new ArrayList<>();
    private Scanner scanner;

    public Patient(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addPatient() {
        System.out.print("Enter Patient Id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        patientList.add(new PatientInfo(id, name, age));
        System.out.println("Patient added successfully.");
    }

    public void viewPatients() {
        if (patientList.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        System.out.println("Patients: ");
        System.out.println("+------------+--------------------+-----+");
        System.out.println("| Patient Id | Name               | Age |");
        System.out.println("+------------+--------------------+-----+");

        for (PatientInfo p : patientList) {
            System.out.printf("| %-10d | %-18s | %-3d |\n", p.getId(), p.getName(), p.getAge());
            System.out.println("+------------+--------------------+-----+");
        }
    }

    public boolean getPatientById(int id) {
        for (PatientInfo p : patientList) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // Inner class to hold patient data
    private static class PatientInfo {
        private int id;
        private String name;
        private int age;

        public PatientInfo(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
    }
}
