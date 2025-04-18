
package HospitalManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Doctor
{
    private List<DoctorInfo> doctorList = new ArrayList<>();
    private Scanner scanner;

    public Doctor(Scanner scanner)
    {
        this.scanner = scanner;
        // Sample doctors for demo
        doctorList.add(new DoctorInfo(1, "Dr. Alice", "Cardiologist"));
        doctorList.add(new DoctorInfo(2, "Dr. Bob", "Neurologist"));
        doctorList.add(new DoctorInfo(3, "Dr. Charlie", "Orthopedic"));
    }

    public void viewDoctors()
    {
        if (doctorList.isEmpty())
        {
            System.out.println("No doctors found.");
            return;
        }

        System.out.println("Doctors: ");
        System.out.println("+------------+--------------------+------------------+");
        System.out.println("| Doctor Id  | Name               | Specialization   |");
        System.out.println("+------------+--------------------+------------------+");

        for (DoctorInfo doc : doctorList)
        {
            System.out.printf("| %-10d | %-18s | %-16s |\n",
                    doc.getId(), doc.getName(), doc.getSpecialization());
            System.out.println("+------------+--------------------+------------------+");
        }
    }

    public boolean getDoctorById(int id)
    {
        for (DoctorInfo doc : doctorList)
        {
            if (doc.getId() == id)
            {
                return true;
            }
        }
        return false;
    }

    public void addDoctor() {
        System.out.print("Enter Doctor Id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        doctorList.add(new DoctorInfo(id, name, specialization));
        System.out.println("Doctor added successfully.");
    }

    // Inner class to hold doctor data
    private static class DoctorInfo
    {
        private int id;
        private String name;
        private String specialization;

        public DoctorInfo(int id, String name, String specialization)
        {
            this.id = id;
            this.name = name;
            this.specialization = specialization;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getSpecialization() { return specialization; }
    }
}
