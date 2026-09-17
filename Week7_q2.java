package doctor;

public class Doctor {

    private int doctorId;
    private String name;
    private String specialization;
    private double consultationFee;

    public Doctor(int doctorId, String name, String specialization,
                  double consultationFee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void display() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Doctor Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Consultation Fee: " + consultationFee);
    }
}
package patient;

public class Patient {

    private int patientId;
    private String name;
    private String disease;
    private int age;

    public Patient(int patientId, String name, String disease, int age) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public String getDisease() {
        return disease;
    }

    public int getAge() {
        return age;
    }

    public void display() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + name);
        System.out.println("Disease: " + disease);
        System.out.println("Age: " + age);
    }
}
import doctor.Doctor;
import patient.Patient;

public class Main {
    public static void main(String[] args) {

        Doctor d1 = new Doctor(101, "Dr. Kumar", "Cardiologist", 1000);
        Doctor d2 = new Doctor(102, "Dr. Priya", "Dermatologist", 800);

        Patient p1 = new Patient(201, "Arun", "Heart Problem", 45);
        Patient p2 = new Patient(202, "Meena", "Skin Allergy", 25);
        Patient p3 = new Patient(203, "Ravi", "Heart Problem", 50);

        System.out.println("PATIENT DETAILS");

        System.out.println("\nPatient 1:");
        p1.display();
        System.out.println("Treating Doctor: " + d1.getName());
        System.out.println("Specialization: " + d1.getSpecialization());

        System.out.println("\nPatient 2:");
        p2.display();
        System.out.println("Treating Doctor: " + d2.getName());
        System.out.println("Specialization: " + d2.getSpecialization());

        System.out.println("\nPatient 3:");
        p3.display();
        System.out.println("Treating Doctor: " + d1.getName());
        System.out.println("Specialization: " + d1.getSpecialization());

        int patientsD1 = 2;
        int patientsD2 = 1;

        double totalD1 = patientsD1 * d1.getConsultationFee();
        double totalD2 = patientsD2 * d2.getConsultationFee();

        System.out.println("\nTOTAL CONSULTATION FEE");
        System.out.println(d1.getName() + ": " + totalD1);
        System.out.println(d2.getName() + ": " + totalD2);
    }
}
