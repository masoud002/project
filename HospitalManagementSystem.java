
package HospitalManagementSystem;

import java.util.*;

public class HospitalManagementSystem
{
    private static final List<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Patient patient = new Patient(scanner);
        Doctor doctor = new Doctor(scanner);
        System.out.println();
        System.out.println("===================================================");
        System.out.println("|                                                 |");
        System.out.println("|                HOSPITAL MANAGEMENT              |");
        System.out.println("|                    SYSTEM                       |");
        System.out.println("|                                                 |");
        System.out.println("===================================================");
        System.out.println("                    |||||||||||                   ");
        System.out.println("                ===================               ");
        System.out.println("               ||     HOSPITAL     ||             ");
        System.out.println("               ||==================||             ");
        System.out.println("               ||     +      +     ||             ");
        System.out.println("               ||  +    + +    +   ||             ");
        System.out.println("               ||     +     +      ||             ");
        System.out.println("               ||==================||             ");
        System.out.println("               || [ ]   [ ]   [ ]  ||             ");
        System.out.println("               || [ ]   [ ]   [ ]  ||             ");
        System.out.println("               || [ ]   [ ]   [ ]  ||             ");
        System.out.println("               ||==================||             ");
        System.out.println("               ||      ____        ||             ");
        System.out.println("               |||DOOR|||             ");
        System.out.println("                                                 ");
        System.out.println("      Welcome to the Hospital Management System!");
        System.out.println();

        while (true)
        {
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. View Doctors");
            System.out.println("4. Book Appointment");
            System.out.println("5. Add Doctor");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    patient.addPatient();
                    break;
                case 2:
                    patient.viewPatients();
                    break;
                case 3:
                    doctor.viewDoctors();
                    break;
                case 4:
                    bookAppointment(patient, doctor, scanner);
                    break;
                case 5:
                    doctor.addDoctor();
                    break;
                case 6:
                    System.out.println("THANK YOU! FOR USING HOSPITAL MANAGEMENT SYSTEM!!");
                    return;
                default:
                    System.out.println("Enter valid choice!!!");
            }
        }
    }

    public static void bookAppointment(Patient patient, Doctor doctor, Scanner scanner)
    {
        System.out.print("Enter Patient Id: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor Id: ");
        int doctorId = scanner.nextInt();
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String appointmentDate = scanner.next();

        if (patient.getPatientById(patientId) && doctor.getDoctorById(doctorId))
        {
            if (checkDoctorAvailability(doctorId, appointmentDate))
            {
                appointments.add(new Appointment(patientId, doctorId, appointmentDate));
                System.out.println("Appointment Booked!");
            }
            else
            {
                System.out.println("Doctor not available on this date!!");
            }
        }
        else
        {
            System.out.println("Either doctor or patient doesn't exist!!!");
        }
    }

    public static boolean checkDoctorAvailability(int doctorId, String appointmentDate)
    {
        for (Appointment a : appointments)
        {
            if (a.getDoctorId() == doctorId && a.getDate().equals(appointmentDate))
            {
                return false;
            }
        }
        return true;
    }

    // Appointment class
    static class Appointment
    {
        private int patientId;
        private int doctorId;
        private String date;

        public Appointment(int patientId, int doctorId, String date)
        {
            this.patientId = patientId;
            this.doctorId = doctorId;
            this.date = date;
        }

        public int getPatientId()
        {
            return patientId;
        }

        public int getDoctorId()
        {
            return doctorId;
        }

        public String getDate()
        {
            return date;
        }
    }
}
