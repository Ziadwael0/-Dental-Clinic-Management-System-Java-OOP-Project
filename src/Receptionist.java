//salma
import java.util.Scanner ;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
public class Receptionist extends Staff
{
    private  int age;
    private  String gender;
    private ArrayList<Appointment>appointments;
   private int appointmentId ;
    String date ;
    String time ;
    private String status ;
    private Scanner input;
    public final int id=3;

    public Receptionist(String firstname, String lastname, String username, String password, String mobile, String email,String gender,int age){
        super(firstname, lastname , username, password, mobile, email);
        this.age = age;
        this.gender = gender;
        this.appointments = new ArrayList<>(); // Initialize the list here
        this.input = new Scanner(System.in);
    }

    // Converts object to file-friendly string format
    public String toFileFormat() {
        return String.join(",",
                firstName,
                lastName,
                getUsername(),
                getPassword(),
                getMobile_number(),
                getEmail(),gender,
                String.valueOf(age));

    }
    // Parses a file line to create a Patient object
    public static Receptionist fromFileFormat(String data) {
        String[] parts = data.split(",");
        if (parts.length != 8) {
            throw new IllegalArgumentException("Invalid data format: " + data);
        }
        return new Receptionist(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5],parts[6],
                Integer.parseInt(parts[7]));
    }

    @Override
    public void view_Profile( ) {
        super.view_Profile();
        System.out.println("Age: "+ age);
        System.out.println("Gender: "+ gender);
        System.out.println("Salary: "+ getReceptionistSalary()+"$");
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


    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
    //methods
    public void change_receptionist_details(String email , String mobile_num , int age )
    {
        this.setEmail(email);
        this.setMobile_number(mobile_num);
        this.setAge(age);
        System.out.println("Receptionist details changed successfully^_^");
    }



        public String reservePatientAppType(){
                String type="";
            int ans = -1 ;
            do {
                System.out.println("Choose the service you want to reserve:");
                System.out.println("1.Dental Checkup and Consultation\n2.Teeth Cleaning\n3.Teeth Whitening\n4.Dental Fillings\n5.Dental Crowns");
                ans = input.nextInt();
                if (ans < 6 && ans >= 1) {

                        switch (ans) {
                            case 1:
                                type = "Dental Checkup and Consultation";
                                break;
                            case 2:
                                type = "Teeth Cleaning";
                                break;
                            case 3:
                                type = "Teeth Whitening";
                                break;
                            case 4:
                                type = "Dental Fillings";
                                break;
                            case 5:
                                type = "Dental Crowns";
                                break;

                        }

                }
                else System.out.println("please choose a valid number");

            } while (ans > 5 || ans < 1);

return type;
        }

}






