import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Appointment
{
    private String doctorName;
    private String PatientName;
    private String date;  // Example: 2024-06-25
    private String time;  // Example: 14:30
    private String notes;
    private String type;
    boolean isreserved = false ;

    // Constructor


    public Appointment(String doctorName, String date, String time, String notes, String patientName, String type) {
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
        this.notes = notes;
        PatientName = patientName;
        this.type = type;
    }

    public Appointment(String date, String time)
    {
        this.date = date;
        this.time = time;
    }

    public Appointment(String date,String time,String type)
    {
        this.date=date;
        this.time=time;
        this.type=type;

    }
    // Getter and Setter methods
    public static void cancelAppointment() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the appointment date to cancel: ");
        String date = input.nextLine();
        System.out.println("Enter the appointment time to cancel: ");
        String time = input.nextLine();

        boolean found = false;

        // Iterate through appointments to find a match
        for (int i = 0; i < DentalClinic.appointments.size(); i++) {
            if (date.equals(DentalClinic.appointments.get(i).date) &&
                    time.equals(DentalClinic.appointments.get(i).time)) {
                DentalClinic.appointments.remove(i);
                System.out.println("Appointment canceled successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No matching appointment found. Please try again.");
        }
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime (String time)
    {
        this.time=time ;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    // Converts object to file-friendly string format

    public String toFileFormat() {
        return doctorName+ "," + date + "," + time + "," + notes + "," + PatientName+ "," + type ;
    }

    // Static method to load from file
    public static Appointment fromFileFormat(String data) {
        String[] parts = data.split(",");
        if (parts.length != 6) {
            throw new IllegalArgumentException("Invalid data format: " + data);
        }
        return new Appointment(parts[0], parts[1], parts[2], parts[3], parts[4],parts[5]);
    }

    @Override
    public String toString() {
        return "Patient name is "+getPatientName()+"\nDoctor Name: "+getDoctorName()+"\nType of reservation: "+getType()+"\nTime: "+getTime()+"\nNotes: "+getNotes()+"\n===========================";
    }

}