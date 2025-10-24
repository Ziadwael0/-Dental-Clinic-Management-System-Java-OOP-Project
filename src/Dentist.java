//farida

import java.util.ArrayList;
import java.util.List;

class Dentist extends Staff {
    private String availableDays;
    private String availableHours;
    private String specialization;
    private String medication;
    private String dosage;
    private String instructions;
    private List<Appointment> appointments;
    private final int id=1;



    @Override
    public void setStaff_id(int id) {
        super.setStaff_id(this.id);

    }

    // Constructor

    public Dentist(String username, String password, String firstName, String lastName, String email, String mobileNumber, String availableDays, int staff_id, String availableHours, String specialization,String medication, String dosage,String instructions) {
        super(firstName, lastName, username, password, mobileNumber, email, staff_id);
        this.availableDays = availableDays;
        this.availableHours = availableHours;
        this.specialization = specialization;
        this.medication=medication;
        this.dosage=dosage;
        this.instructions=instructions;
        this.appointments = new ArrayList<>(); // Initialize the list here
    }

    public Dentist(String firstname, String lastname, String username, String password, String mobile_number, String email, String availableDays, String availableHours, String specialization) {
        super(username,password,firstname,lastname, mobile_number, email);
        this.availableDays = availableDays;
        this.availableHours = availableHours;
        this.specialization = specialization;
        this.appointments = new ArrayList<>();
    }

    public Dentist(String username, String password, String firstName, String lastName, String email, String mobileNumber, String availableDays, int staff_id, String availableHours, String specialization) {
        super(firstName,lastName,username,password,mobileNumber,email,staff_id);
        this.availableDays = availableDays;
        this.availableHours = availableHours;
        this.specialization = specialization;
        this.appointments = new ArrayList<>();
    }

public Dentist( String firstname,String lastname,String username, String password,String mobile,String email) {
        super(firstname,lastname,username,password,mobile,email);

    }
    public Dentist( String firstname,String lastname,String username, String password,String mobile,String email,String specialization) {
        super(firstname,lastname,username,password,mobile,email);
        this.specialization=specialization;
        this.appointments = new ArrayList<>();
    }

    public String getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(String availableDays) {
        this.availableDays = availableDays;
    }

    public String getAvailableHours() {
        return availableHours;
    }

    public void setAvailableHours(String availableHours) {
        this.availableHours = availableHours;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String toFileFormat() {
        return getUsername()+ "," + getPassword() + "," + firstName + "," + lastName + "," + getMobile_number()+ "," + getEmail()  + "," +availableDays + "," +availableHours + "," +specialization;
    }

    // Static method to create Dentist from file data
    public static Dentist fromFileFormat(String data) {
        String[] parts = data.split(",");
        if (parts.length != 9) {
            throw new IllegalArgumentException("Invalid data format: " + data);
        }
        return new Dentist(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8]);
    }


    // Method to show all appointments for a specific day
    public void showAppointmentsForDay(String day) {
        System.out.println("Appointments for " + day + ":");
        boolean found = false;

        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(day)) {
                System.out.println(appointment.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments found for " + day + ".");
        }
    }
    // Method to update doctor's schedule
    public void updateSchedule(String newDays, String newHours) {
        setAvailableDays(newDays);
        setAvailableHours(newHours);
    }

    public void GetContactReceptionist(Receptionist receptionist){
        System.out.println("Receptionist Contact:");
        System.out.println("Email: "+receptionist.getEmail());
        System.out.println("Mobile Number: "+receptionist.getMobile_number());
    }

    public void GetPatientInfo(Patient patient){
        patient.view_Profile();
    }
    // Method to view profile
    public void viewProfile() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Doctor specialization: "+specialization);
        System.out.println("Email: " + getEmail());
        System.out.println("Mobile Number: " + getMobile_number());
        System.out.println("Salary: " + getDoctorSalary()+"$");
        if (availableDays != null && availableHours != null) {
            System.out.println("Available Days: "+availableDays);
            System.out.println("Available Hours: " +availableHours);
        }
        else {
            setAvailableHours("No Entered Hours");
            setAvailableDays("No Entered days");
            System.out.println("Available Days: "+availableDays);
            System.out.println("Available Hours: " +availableHours);
        }
    }

    // Method to update availability
    public void viewAvailability() {
        if (availableDays != null && availableHours != null) {
            System.out.println("Available Days: "+availableDays);
            System.out.println("Available Hours: " +availableHours);
        }
        else {
            setAvailableHours("No Entered Hours");
            setAvailableDays("No Entered days");
            System.out.println("Available Days: "+availableDays);
            System.out.println("Available Hours: " +availableHours);
        }
    }

    public void writePrescription(Patient p,String patientName, String medication, String dosage, String instructions)
    {
        System.out.println("Writing prescription for: " + patientName);
        System.out.println("Medication: " + medication);
        System.out.println("Dosage: " + dosage);
        System.out.println("Instructions: " + instructions);
        // p.viewprescription(medication,dosage,instructions);
        p.setMedication(medication);
        p.setDosage(dosage);
        p.setInstructions(instructions);


    }
}



