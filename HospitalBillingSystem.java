import java.util.Scanner;

class Doctor {
    int doctorId;
    String doctorName;
    double consultationFee;
    String appointmentType;

    Doctor(int id, String name, double fee, String type) {
        doctorId = id;
        doctorName = name;
        consultationFee = fee;
        appointmentType = type;
    }

    double calculateConsultationFee() {
        double fee = consultationFee;

        if (appointmentType.equalsIgnoreCase("Emergency")) {
            fee = fee + 1000;
        }

        return fee;
    }
}

class GeneralDoctor extends Doctor {

    GeneralDoctor(int id, String name, double fee, String type) {
        super(id, name, fee, type);
    }
}

class Specialist extends Doctor {

    Specialist(int id, String name, double fee, String type) {
        super(id, name, fee, type);
    }

    double calculateConsultationFee() {
        double fee = consultationFee + 500;

        if (appointmentType.equalsIgnoreCase("Emergency")) {
            fee = fee + 1000;
        }

        return fee;
    }
}

class Surgeon extends Doctor {

    Surgeon(int id, String name, double fee, String type) {
        super(id, name, fee, type);
    }

    double calculateConsultationFee() {
        double fee = consultationFee + 1500;

        if (appointmentType.equalsIgnoreCase("Emergency")) {
            fee = fee + 1000;
        }

        return fee;
    }
}

public class HospitalBillingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Doctor Type:");
        String type = sc.nextLine();

        System.out.println("Enter Doctor ID:");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Doctor Name:");
        String name = sc.nextLine();

        System.out.println("Enter Consultation Fee:");
        double fee = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter Appointment Type:");
        String appointment = sc.nextLine();

        Doctor doctor;

        if (type.equalsIgnoreCase("GeneralDoctor")) {
            doctor = new GeneralDoctor(id, name, fee, appointment);
        }
        else if (type.equalsIgnoreCase("Specialist")) {
            doctor = new Specialist(id, name, fee, appointment);
        }
        else if (type.equalsIgnoreCase("Surgeon")) {
            doctor = new Surgeon(id, name, fee, appointment);
        }
        else {
            System.out.println("Invalid Doctor Type");
            return;
        }

        double finalFee = doctor.calculateConsultationFee();

        System.out.println("Final Fee: " + (int) finalFee);

        sc.close();
    }
}