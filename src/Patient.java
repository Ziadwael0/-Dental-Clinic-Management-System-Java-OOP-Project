//fatma
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient extends Person {
    // attributes specific to the pateint
    private int age;
    private String gender;
    private double weight;
    private double height;
    private String bloodtype;
    private List<String> medicalHistory;
    private String medication;
    private String dosage;
    private String instructions;
   private String date ;
    private String time ;
    private String type ;
    private List<Appointment> appointments;
    public final int check_up_cost = 300;
    public final int teeth_cleaning_cost = 500;
    public final int teeth_whitning_cost = 600;
    public final int dental_filings_cost = 700;
    private final int denta_crowns_cost = 1500;

    //constructor

    public Patient(String firstname, String lastname, String username, String password, String mobile_number, String Email, int age, String gender, String bloodtype, double weight, double height) {
        super(firstname, lastname, username, password, mobile_number, Email);
        this.age = age;
        this.gender = gender;
        this.bloodtype = bloodtype;
        this.weight = weight;
        this.height = height;
        this.appointments = new ArrayList<>(); // Initialize the list here
        this.medicalHistory = new ArrayList<>();
    }


    //getters and setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public List<String> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<String> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Add a new record to the medical history
    public void addMedicalRecord(String record) {

        medicalHistory.add(record);
        System.out.println("Medical record added for patient: " + firstName);

    }

     // Method to display full patient history
    public void displayPatientHistory() {
        System.out.println("===== Patient History =====");
        // Display medical history
        if (medicalHistory.isEmpty()) {
            System.out.println("No medical history available.");
        } else {
            for(String record :medicalHistory)
            {
                System.out.println("- " + record);
            }
        }
        // Display prescription details
        System.out.println("Prescription Details:");
        viewprescription(); // Calls existing method for prescription
        System.out.println("=====================================");
    }





    // Converts object to file-friendly string format
    public String toFileFormat() {
        return String.join(",",
                firstName, lastName, getUsername(), getPassword(), getMobile_number(), getEmail(), String.valueOf(age), gender, bloodtype, String.valueOf(weight), String.valueOf(height));
    }


    // Static method to load from file
    public static Patient fromFileFormat(String data) {
        String[] parts = data.split(",");
        if (parts.length != 11) {
            throw new IllegalArgumentException("Invalid data format: " + data);
        }
        return new Patient(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5],
                Integer.parseInt(parts[6]), parts[7], parts[8],
                Double.parseDouble(parts[9]), Double.parseDouble(parts[10]));
    }

    //patient change his details
    public void change_patient_details(String email, String mobile_num, double weight, double height) {

        this.setEmail(email);
        this.setMobile_number(mobile_num);
        this.setWeight(weight);
        this.setHeight(height);
        System.out.println("Patient details changed successfully ^_^");
    }


    //search by dr name
    public void getDentist(Dentist dentistname) {
        System.out.println("Doctor name: " + dentistname.getFirstName() + " " + dentistname.getLastName());
        System.out.println("Doctor Available days: " + dentistname.getAvailableDays());
        System.out.println("Doctor Available hours: " + dentistname.getAvailableHours());

    }

    //search by mobile number
    public void getDentist1(Dentist mobilenumber) {
        System.out.println("Doctor name: " + mobilenumber.getFirstName() + " " + mobilenumber.getLastName());
        System.out.println("Doctor Available days: " + mobilenumber.getAvailableDays());
        System.out.println("Doctor Available hours: " + mobilenumber.getAvailableHours());

    }

    public void viewprescription() {
        if (medication == null) {
            medication = "No medication data Entered yet.";
        }
        if (dosage == null) {
            dosage = "No dosage Entered yet.";
        }
        if (instructions == null) {
            instructions = "No instructions Entered yet.";
        }
        System.out.println("Medication: " + medication);
        System.out.println("Dosage: " + dosage);
        System.out.println("Instractions: " + instructions);

    }

    //view patient profile
    public void view_Profile() {
        System.out.println("Patient Information: ");

        super.view_Profile(); //dispaly the info of the patient from person class
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Blood type: " + bloodtype);
        System.out.println("Weight type: " + weight);
        System.out.println("Height type: " + height);
        displayPatientHistory();
    }

    public void CheckPrices() {
        String ans2;

        do {
            int ans;
            do {
                System.out.println("Choose the service you want to reserve:");
                System.out.println("1.Dental Checkup and Consultation\n2.Teeth Cleaning\n3.Teeth Whitening\n4.Dental Fillings\n5.Dental Crowns");
                ans = input.nextInt();
                if (ans > 5 || ans < 1) {
                    System.out.println("please choose a valid number");
                }

            } while (ans > 5 || ans < 1);
            switch (ans) {
                case 1:
                    System.out.println("the cost is " + check_up_cost+"$");
                    break;
                case 2:
                    System.out.println("the cost is " + teeth_whitning_cost+"$");
                    break;
                case 3:
                    System.out.println("the cost is " + teeth_cleaning_cost+"$");
                    break;
                case 4:
                    System.out.println("the cost is " + dental_filings_cost+"$");
                    break;
                case 5:
                    System.out.println("the cost is " + denta_crowns_cost+"$");
                    break;

            }
            input.nextLine();
            System.out.println("Do you want to see another price?\n1.Yes\n2.No");
            ans2 = input.nextLine();
        } while (!ans2.equals("2"));

    }


    public void displayAppointment(String docName){
        if (date == null) {
            date= "No date reserved yet.";
        }
        if (time == null) {
            time = "No time reserved yet.";
        }
        if (type == null) {
            type = "No reserved Appointment.";
        }
        System.out.println("Date: "+date);
        System.out.println("Time: "+time);
        System.out.println("Type: "+type);


    }

    // Reserve Appointment
    public void reserveAppointment(Appointment appointment,String date,String time,String type) {
        appointments.add(appointment);
        setDate(date);
        setTime(time);
        setType(type);
        System.out.println("Appointment successfully reserved!");
    }

    // Cancel Appointment
    public void cancelAppointment(String doctorName, String date) {
        boolean removed = false;
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appt = appointments.get(i);
            if (appt.getDoctorName().equalsIgnoreCase(doctorName) &&
                    appt.getDate().equals(date)) {
                appointments.remove(i);
                removed = true;
                System.out.println("Appointment successfully canceled!");
                break;
            }
        }

        if (!removed) {
            System.out.println("No matching appointment found to cancel.");
        }
    }

}