import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DentalClinic clinic = new DentalClinic("Dental Clinic", "123 Main St");
        System.out.println("========= Welcome to "+clinic.name+" =========");

        clinic.loadDentistsFromFile();
        clinic.loadPatientsFromFile();
        clinic.loadReceptionistsFromFile();
        clinic.loadAppFromFile();

            int y;
        do {
            y=0;
            Scanner input = new Scanner(System.in);
            System.out.println("Choose one:");
            System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("3.Exit Program");
            String n = input.nextLine();
            if (n.equals("1")) { //Login
                System.out.println("You Want to Login as:");
                System.out.println("1.Dentist");
                System.out.println("2.Reciptionest");
                System.out.println("3.Patient");
                System.out.println("4.Exit");
                String choose = input.nextLine();
                if (choose.equals("1")) {
                    clinic.Dentist_Login();
                }
                else if (choose.equals("2")) {
                    clinic.Receptionist_Login();
                }
               else if (choose.equals("3")) {
                    clinic.Patient_login();
                }

               else if (choose.equals("4")) {
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                }
            } else if (n.equals("2")) { //Register
                System.out.println("You Want to Register as:");
                System.out.println("1.Dentist");
                System.out.println("2.Receptionist");
                System.out.println("3.Patient");
                System.out.println("4.Exit");
                String select = input.nextLine();
                if (select.equals("1")) {
                    clinic.RegisterDentist();

                }
                else if (select.equals("2")) {
                    clinic.RegisterReceptionist();
                } else if (select.equals("3")) {
                    clinic.RegisterPatient();
                }
                else if (select.equals("4")) {
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                }
                 else
                    System.out.println("Invalid input! Please Enter another number:");
            }
            else if(n.equals("3")){ //Exit
                System.out.println("Exiting the system. Goodbye!");
                System.exit(0);
            }
            else {
                System.out.println("Invalid input! Please Enter another number:");
            }
        } while (true);

    }
}



