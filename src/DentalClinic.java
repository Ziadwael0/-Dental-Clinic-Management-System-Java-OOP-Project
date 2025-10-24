//Ziad
import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class DentalClinic {
    Scanner input = new Scanner(System.in);
    public String name;
    private String location;
    private List<Dentist> doctors;
    private List<Patient> patients;
    private List<Receptionist> receptionists;
    static List<Appointment> appointments;

    //   private List<ServicePrice> prices;
    private List<Service> services;

    public DentalClinic(String name, String location) {
        this.name = name;
        this.location = location;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.receptionists = new ArrayList<>();
        this.appointments = new ArrayList<>(); // Initialize the list here


        //    this.prices = new ArrayList<>();
        this.services = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Dentist> getDoctors() {
        return doctors;
    }



    public List<Patient> getPatients() {
        return patients;
    }

    public List<Receptionist> getReceptionists() {
        return receptionists;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

//    public List<ServicePrice> getPrices() {
//        return prices;
//    }

    public List<Service> getServices() {
        return services;
    }

    public void addDoctor(Dentist doctor) {
        this.doctors.add(doctor);
    }

    public void removeDoctor(Dentist doctor) {
        this.doctors.remove(doctor);
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public void removePatient(Patient patient) {
        this.patients.remove(patient);
    }

    public void addReceptionist(Receptionist receptionist) {
        this.receptionists.add(receptionist);
    }

    public void removeReceptionist(Receptionist receptionist) {
        this.receptionists.remove(receptionist);
    }

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        this.appointments.remove(appointment);
    }

//list of Doctors
    public void listAllDoctors() {
        int i=1;
        System.out.println("Doctors:");
        for (Dentist doctor : doctors) {
            System.out.println(i+". "+doctor.firstName);
            i++;
        }
    }

//list of all Appointments of dental clinic
    public void listAllAppointments() {
        int i=1;
        System.out.println("Available Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println(i+". "+appointment.getType()+" with Dr/"+appointment.getDoctorName()+" at "+appointment.getDate()+" "+appointment.getTime()+":00");
            System.out.println("Patient Name: "+appointment.getPatientName());
            i++;
        }
    }

    //list of all Patients
    public void listAllPatients() {
        int p=1;
        System.out.println("Patients:");
        for (Patient patient : patients) {
            System.out.println(p+". "+patient.firstName);
            p++;
        }
    }

    //list of all receptionists
    public void listAllReceptionists() {
        int l=1;
        System.out.println("Receptionists:");
        for (Receptionist receptionist : receptionists) {
            System.out.println(l+". "+receptionist.firstName);
            l++;
        }
    }

    //Files handling
    private void saveDentistsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dentists.txt"))) {
            for (Dentist dentist : doctors) {
                writer.write(dentist.toFileFormat() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving dentists to file: " + e.getMessage());
        }
    } //save the new dentist into files
    public void savePatientsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("patients.txt"))) {
            for (Patient patient : patients) {
                writer.write(patient.toFileFormat()+ "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving patients to file: " + e.getMessage());
        }
    } //save the new patients into files
    public void saveAppToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("appointments.txt"))) {
            for (Appointment appointment : appointments) {
                writer.write(appointment.toFileFormat()+ "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving patients to file: " + e.getMessage());
        }
    } //save the new Appointment into files
    public void saveReceptionistsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("receptionist.txt"))) {
            for (Receptionist receptionist : receptionists) {
                writer.write(receptionist.toFileFormat()+ "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving patients to file: " + e.getMessage());
        }
    } //save the new Receptionist into files

    public void loadAppFromFile() {
        File file = new File("appointments.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    try {
                        String[] parts = line.split(",");
                        if (parts.length != 6) { // Adjust according to your Dentist properties
                            System.out.println("Invalid line format: " + line);
                            continue;
                        }
                        String docName = parts[0];
                        String date = parts[1];
                        String time = parts[2];
                        String notes = parts[3];
                        String PatientName = parts[4];
                        String type = parts[5];

                        Appointment appointment = new Appointment(docName,date,time,notes,PatientName,type);
                        appointments.add(appointment);
                    } catch (Exception e) {
                        System.out.println("Error parsing line: " + line);
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("File 'appointments.txt' does not exist. No data loaded.");
        }
    } //read the appointments files and load from it

    public void loadPatientsFromFile() {
        File file = new File("patients.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    try {
                        Patient patient = Patient.fromFileFormat(line);
                        patients.add(patient);
                    } catch (Exception e) {
                        System.out.println("Error parsing line: " + line);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading patients file: " + e.getMessage());
            }
        }
    } //read the patients files and load from it

    public void loadReceptionistsFromFile() {
        File file = new File("receptionist.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    try {
                        Receptionist receptionist =     Receptionist.fromFileFormat(line);
                        receptionists.add(receptionist);
                    } catch (Exception e) {
                        System.out.println("Error parsing line: " + line);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading patients file: " + e.getMessage());
            }
        }
    } //read the receptionists files and load from it

    public void loadDentistsFromFile() {
        File file = new File("dentists.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    try {
                        String[] parts = line.split(",");
                        if (parts.length != 9) { // Adjust according to your Dentist properties
                            System.out.println("Invalid line format: " + line);
                            continue;
                        }
                        String username = parts[0];
                        String password = parts[1];
                        String firstName = parts[2];
                        String lastName = parts[3];
                        String email = parts[4];
                        String mobile = parts[5];
                        String availabledays = parts[6];
                        String availablehours = parts[7];
                        String spec = parts[8];
                        Dentist dentist = new Dentist(username, password, firstName, lastName, email, mobile, availabledays, availablehours, spec);
                        doctors.add(dentist);
                    } catch (Exception e) {
                        System.out.println("Error parsing line: " + line);
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.out.println("File 'dentists.txt' does not exist. No data loaded.");
        }
    } //read the dentists files and load from it

//method to show the avilable appointments for specific day
    public void showAppointmentsForDay(String day) {
        System.out.println("Appointments for " + day + ":");
        boolean found = false;
        int i = 1;
        for (Appointment appointment : appointments) {
            if (appointment.getDate().equalsIgnoreCase(day)) {
                System.out.println(i+". "+appointment.toString());
                found = true;
                i++;
            }
        }

        if (!found) {
            System.out.println("No appointments found for " + day + ".");
        }
    }


// Register Methods
public boolean registerDentist(String firstname,String lastname,String username, String password,String mobile,String email, String specilization){
    // Check if the username is unique
    for (Dentist dentist : doctors) {
        if (dentist.getUsername().equals(username)) {
            System.out.println("Username already exists. Registration failed.");
            return false;
        }
    }
    // Add the new dentist
    Dentist newDentist = new Dentist(firstname, lastname, username, password, mobile, email, specilization);
    doctors.add(newDentist);
    saveDentistsToFile();
    System.out.println("Dentist registered successfully!" );
    return true;
}

 public boolean registerReceptionist(String firstname, String lastname, String username, String password, String mobile, String email, String gender,int age) {
    // Check if the username is unique
    for (Receptionist receptionist : receptionists) {
        if (receptionist.getUsername().equals(username)) {
            System.out.println("Username already exists. Registration failed.");
            return false;
        }
    }
    // Add the new Receptionist
    Receptionist newReceptionist = new Receptionist(firstname, lastname, username, password, mobile, email,gender,age);
    receptionists.add(newReceptionist);
    System.out.println("Reseptionist registered successfully!" );
    saveReceptionistsToFile();
    return true;
}

public boolean registerPatient(String firstname,String lastname,String username, String password,String mobile,String email,int age ,String gender,String bloodtype ,double weight ,double height) {
    // Check if the username is unique
    for (Patient patient : patients) {
        if (patient.getUsername().equals(username)) {
            System.out.println("Username already exists. Registration failed.");
            return false;
        }
    }
    // Add the new Patient
    Patient newPatient = new Patient(firstname, lastname, username, password, mobile, email,age,gender,bloodtype,weight,height);
    patients.add(newPatient);
    savePatientsToFile();
    System.out.println("Patient registered successfully!" );
    return true;
}


// Login Method
    public Dentist loginDentist(String username, String password) {
        for (Dentist dentist : doctors) {
            if (dentist.getUsername().equals(username) && dentist.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + dentist.getFirstName());
                return dentist;
            }
        }
        System.out.println("Invalid username or password. Login failed.");
        return null;
    }

 public Receptionist loginReceptionist(String username, String password) {
        for (Receptionist receptionist : receptionists) {
            if (receptionist.getUsername().equals(username) && receptionist.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + receptionist.getFirstName());
                return receptionist;
            }
        }
        System.out.println("Invalid username or password. Login failed.");
        return null;
    }



 public Patient loginPatient(String username, String password) {
        for (Patient patient : patients) {
            if (patient.getUsername().equals(username) && patient.getPassword().equals(password)) {
                System.out.println("Login successful! Welcome, " + patient.getFirstName());
                return patient;
            }
        }
        System.out.println("Invalid username or password. Login failed.");
        return null;
    }

    String regex = "^01\\d{9}$";                                //to check number start with 01
    String regex2 = "^[\\w.%+-]+@(gmail\\.com|yahoo\\.com)$";   //to check email ends with @gmail.com or @yahoo.com

//Register patient menu
    public void RegisterPatient(){
        System.out.print("Enter First name: ");
        String firstname = input.nextLine();
        System.out.print("Enter Last name: ");
        String lastname = input.nextLine();
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        System.out.print("Password : ");
        String password = input.nextLine();
        while (true) {

            System.out.print("Enter password again: ");//lazem yktb el password elly ktbo awl mara
            String checkPassword = input.nextLine();
            if (checkPassword.equals(password)) {
                System.out.println("Password confirmed!");
                break;//يخرج بره اللوب
            }
            else {
                System.out.println("Wrong password, Please try again");
            }
        }

        String mobile_number;
        while (true) {

            System.out.print("Enter Mobile number: ");
            mobile_number = input.nextLine();
            if (mobile_number.matches(regex)) {
                break;
            }
            else{
                System.out.println("Invalid mobile number. Please try again.");
            }
        }
        String email;
        while (true) {

            System.out.print("Email: ");
            email = input.nextLine();
            if (email.matches(regex2)) {
                break;
            }
            else{
                System.out.println("Invalid Email. Please try again.(make it @gmail.com or @yahoo.com)");
            }
        }

        String gender;
        while (true) {

            System.out.print("Enter your Gender: ");
            gender = input.nextLine();
            if (gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("female")) {
                break;
            }
            else{
                System.out.println("Invalid Gender! Please try again.(Enter male or female.)");
            }
        }

        System.out.print("Enter Your Blood type: ");
        String bloodtype = input.nextLine();
        double weight;
        while (true) {
            System.out.print("Enter Your Weight: ");
            if (input.hasNextDouble()) {
                weight = input.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                input.next(); // Clear the invalid input
            }
        }
     double height;
        while (true) {
            System.out.print("Enter Your Height: ");
            if (input.hasNextDouble()) {
                height = input.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                input.next(); // Clear the invalid input
            }
        }
        int age=-1;
        while (true) {
            try {
                System.out.print("Enter your age (1-100): ");
                age = Integer.parseInt(input.nextLine());

                // Check if the age is within a valid range
                if (age >= 1 && age <= 100) {
                    break;
                } else {
                    System.out.println("Invalid age. Age must be between 1 and 100. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer for age.");
            }
        }

        registerPatient(firstname, lastname, username, password, mobile_number,email,age,gender,bloodtype,weight,height);
    }

//Register receptionist menu
 public void RegisterReceptionist(){
        System.out.print("Enter First name: ");
        String firstname = input.nextLine();
        System.out.print("Enter Last name: ");
        String lastname = input.nextLine();
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        System.out.print("Password : ");
        String password = input.nextLine();
        while (true) {

            System.out.print("Enter password again: ");//lazem yktb el password elly ktbo awl mara
            String checkPassword = input.nextLine();
            if (checkPassword.equals(password)) {
                System.out.println("Password confirmed!");
                break;//يخرج بره اللوب
            }
            else {
                System.out.println("Wrong password, Please try again");
            }
        }
     String mobile_number;
     while (true) {

         System.out.print("Enter Mobile number: ");
         mobile_number = input.nextLine();
         if (mobile_number.matches(regex)) {
             break;
         }
         else{
             System.out.println("Invalid mobile number. Please try again.");
         }
     }
     String email;
     while (true) {

         System.out.print("Email: ");
         email = input.nextLine();
         if (email.matches(regex2)) {
             break;
         }
         else{
             System.out.println("Invalid Email. Please try again.(make it @gmail.com or @yahoo.com)");
         }
     }

     String gender;
     while (true) {

         System.out.print("Enter your Gender: ");
         gender = input.nextLine();
         if (gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("female")) {
             break;
         }
         else{
             System.out.println("Invalid Gender! Please try again.(Enter male or female.)");
         }
     }
     int age=-1;
     while (true) {
         try {
             System.out.print("Enter your age (1-100): ");
             age = Integer.parseInt(input.nextLine());

             // Check if the age is within a valid range
             if (age >= 1 && age <= 100) {
                 break;
             } else {
                 System.out.println("Invalid age. Age must be between 1 and 100. Please try again.");
             }
         } catch (NumberFormatException e) {
             System.out.println("Invalid input. Please enter a valid integer for age.");
         }
     }

     registerReceptionist(firstname, lastname, username, password, mobile_number, email,gender,age);
    }

//Register dentist menu
        public void RegisterDentist() {
        System.out.print("Enter First name: ");
        String firstname = input.nextLine();
        System.out.print("Enter Last name: ");
        String lastname = input.nextLine();
        System.out.print("Enter specialization: ");
        String spec = input.nextLine();
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        System.out.print("Password : ");
        String password = input.nextLine();
        while (true) {

            System.out.print("Enter password again: ");//lazem yktb el password elly ktbo awl mara
            String checkPassword = input.nextLine();
            if (checkPassword.equals(password)) {
                System.out.println("Password confirmed!");
                break;//يخرج بره اللوب
            }
            else {
                System.out.println("Wrong password, Please try again");
            }
        }
            String mobile_number;
            while (true) {

                System.out.print("Enter Mobile number: ");
                mobile_number = input.nextLine();
                if (mobile_number.matches(regex)) {
                    break;
                }
                else{
                    System.out.println("Invalid mobile number. Please try again.");
                }
            }
            String email;
            while (true) {

                System.out.print("Email: ");
                email = input.nextLine();
                if (email.matches(regex2)) {
                    break;
                }
                else{
                    System.out.println("Invalid Email. Please try again.(make it @gmail.com or @yahoo.com)");
                }
            }

            registerDentist(firstname, lastname, username, password, mobile_number, email,spec);

        }

//Login methods
    public void Dentist_Login(){
        //Dentist login
        System.out.print("Enter Username: ");
        String loginUsername = input.nextLine();
        System.out.print("Enter Password: ");
        String loginPassword = input.nextLine();
        Dentist loggedInDentist = loginDentist(loginUsername, loginPassword);
        if (loggedInDentist != null) {              //if dentist enter username and password correct
            System.out.println("You are now logged in!");
            int ii;
            do {
                System.out.println("\n=== Dentist Management System ===");
                System.out.println("1. View Profile");
                System.out.println("2. Update Schedule");
                System.out.println("3. View Availability");
                System.out.println("4. show all appointments for a specific day");
                System.out.println("5. Get contact information of the receptionist");
                System.out.println("6. Get Patient information");
                System.out.println("7. Write a prescription");
                System.out.println("8. Show all the Staff in dental clinic");
                System.out.println("9. Go back to main menu");
                System.out.println("10. Exit");
                System.out.print("Choose an option: ");
                int choice = input.nextInt();
                input.nextLine(); // Consume newline
                ii = 0;
                switch (choice) {
                    case 1://dentist view his profile
                        loggedInDentist.viewProfile();
                        break;
                    case 2://dentist Update Schedule
                        System.out.print("Enter new available days (& separated): ");
                        String daysInput = input.nextLine();
                        System.out.print("Enter new available hours (& separated): ");
                        String hoursInput = input.nextLine();
                        loggedInDentist.updateSchedule(daysInput, hoursInput);
                        System.out.println("Schedule updated successfully!");
                        saveDentistsToFile();
                        break;
                    case 3://dentist View Availability
                        loggedInDentist.viewAvailability();
                        break;
                        case 4://show all appointments for a specific day
                            System.out.print("Enter Day to show all appointments: ");
                            String day=input.nextLine();
                        showAppointmentsForDay(day);
                        break;
                   case 5://dentist Enter receptionist to get contact information
                       listAllReceptionists();
                       boolean check=false;
                       System.out.print("Enter Receptionist name: ");
                       String name=input.nextLine();
                       for (Receptionist receptionist : receptionists) {
                           if (receptionist.getFirstName().equals(name)) {
                            loggedInDentist.GetContactReceptionist(receptionist);
                            check=true;
                            break;
                           }
                           else
                               check=false;

                       }
                       if (check==false)
                           System.out.println("Entered name is incorrect!");
                        break;
                    case 6:
                        listAllPatients();
                        boolean checker=true;
                        System.out.print("Enter patient name: ");
                        String patName=input.nextLine();
                        for (Patient patient : patients) {
                            if (patient.getFirstName().equals(patName)){
                                loggedInDentist.GetPatientInfo(patient);
                                checker=true;
                                break;
                            }
                            else {
                                checker=false;
                            }
                        }
                        if (checker==false)
                            System.out.println("Entered name is incorrect!");
                        break;
                    case 7:
                        boolean y=false;
                        listAllPatients();
                        System.out.print("Enter patient's name: ");
                        String patientName = input.nextLine();
                        for (Patient patient:patients)
                        {
                            if (patientName.equals(patient.getFirstName())) {
                                System.out.print("Enter medication: ");
                                String medication = input.nextLine();
                                System.out.print("Enter dosage: ");
                                String dosage = input.nextLine();
                                System.out.print("Enter instructions: ");
                                String instructions = input.nextLine();
                                loggedInDentist.writePrescription(patient,patientName, medication, dosage, instructions);
                                y = true;
                                break;

                            }
                            else
                                y=false;

                        }
                        if(y==false){
                            System.out.println("Name isn't exist ,please try again!");

                        }
                        break;
                    case 8:
                        viewStaff();
                        break;
                    case 9://Go back to Main Menu
                        ii = 1;
                        break;
                    case 10://Exit the system
                        System.out.println("Exiting the system. Goodbye!");
                        System.exit(0);
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (ii != 1); //loop
        }
    }

    public void Receptionist_Login(){
        //Dentist login
        System.out.print("Enter Username: ");
        String loginUsername = input.nextLine();
        System.out.print("Enter Password: ");
        String loginPassword = input.nextLine();
        Receptionist loggedInReception = loginReceptionist(loginUsername, loginPassword);
        if (loggedInReception != null) {              //if Receptionist enter username and password correct
            System.out.println("You are now logged in!");
            int ii;
            do {
                System.out.println("\n===Receptionist Management System ===");
                System.out.println("1. View Profile");
                System.out.println("2. Reserve Appointment");
                System.out.println("3. View Appointments");
                System.out.println("4. Cancle Appointment");
                System.out.println("5. Change details");
                System.out.println("6. Go Back to Main Menu");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                int choice = input.nextInt();
                input.nextLine(); // Consume newline
                ii = 0;
                switch (choice) {
                    case 1:// view profile
                        loggedInReception.view_Profile();
                        break;
                    case 2:// Reserve Appointment
                        boolean check=false;
                        Patient p = null;
                        listAllPatients();
                        do {
                            System.out.print("Enter Patient name: ");
                            String name = input.nextLine();
                            for (Patient patient : patients) {
                                if (patient.getFirstName().equals(name)) {
                                    p = patient;
                                    check = true;
                                    break;
                                } else
                                    check = false;

                            }
                            if (check == false)
                                System.out.println("Entered name is incorrect!");
                        }while(check==false);
                        listAllDoctors();
                        boolean checker=false;
                        Dentist d = null;
                        String docName="";
                        do {
                            System.out.print("Doctor's Name: ");
                             docName=input.nextLine();
                            for (Dentist dentist : doctors) {
                                if (dentist.getFirstName().equals(docName)) {
                                    d = dentist;
                                    checker = true;
                                    break;
                                } else
                                    checker = false;

                            }
                            if (checker == false)
                                System.out.println("Doctor name is incorrect!");
                        }while(checker==false);
                        String type=loggedInReception.reservePatientAppType();
                        String Choosen_day="";
                        while (true) {
                            AvailableDays();
                            System.out.println("Enter a day number (1 to 7):");
                            String day = input.nextLine();

                            switch (day) {

                                case "1":
                                    Choosen_day = "Sunday";
                                    break;
                                case "2":
                                    Choosen_day = "Monday";
                                    break;
                                case "3":
                                    Choosen_day = "Tuesday";
                                    break;
                                case "4":
                                    Choosen_day = "Wednesday";
                                    break;
                                case "5":
                                    Choosen_day = "Thursday";
                                    break;
                                case "6":
                                    System.out.println("Sorry we are not available on this day ^_^.");
                                    break;
                                case "7":
                                    Choosen_day = "Saturday";
                                    break;
                                default:
                                    System.out.println("Invalid input, please enter a valid number (1 to 7).");
                                    continue; // Restart the loop for invalid inputs
                            }

                            // Break the loop if a valid day other than Friday (6) is chosen
                            if (!day.equals("6")) {
                                break;
                            }

                            if (Choosen_day.equals("Friday")) {
                                System.out.println("Sorry we are not available on this day ^_^.");
                            }
                        }
                        String time=Availabletimes();
                        System.out.print("Add any notes:");
                        String notes=input.nextLine();


                        reserveAppointment(p,docName,Choosen_day,time,notes,type);
                        break;
                    case 3:// view appointment
                         listAllAppointments();
                        break;

                    case 4: //Cancle Appointment
                   // p.cancelAppointment(docName,p.getDate());
                        break;
                    case 5://Change details
                        Scanner scanner = new Scanner(System.in);

                        String email;
                        while (true) {

                            System.out.print("Email: ");
                            email = input.nextLine();
                            if (email.matches(regex2)) {
                                break;
                            }
                            else{
                                System.out.println("Invalid Email. Please try again.(make it @gmail.com or @yahoo.com)");
                            }
                        }

                        String mobile_number;
                        while (true) {

                            System.out.print("Enter Mobile number: ");
                            mobile_number = input.nextLine();
                            if (mobile_number.matches(regex)) {
                                break;
                            }
                            else{
                                System.out.println("Invalid mobile number. Please try again.");
                            }
                        }
                        int age=-1;
                        while (true) {
                            try {
                                System.out.print("Enter your age (1-100): ");
                                age = Integer.parseInt(input.nextLine());

                                // Check if the age is within a valid range
                                if (age >= 1 && age <= 100) {
                                    break;
                                } else {
                                    System.out.println("Invalid age. Age must be between 1 and 100. Please try again.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid integer for age.");
                            }
                        }
                        loggedInReception.change_receptionist_details(email,mobile_number,age);
                        saveReceptionistsToFile();
                        break;
                    case 6://Go Back to Main Menu
                        ii = 1;
                        break;
                    case 7://Exit the system
                        System.out.println("Exiting the system. Goodbye!");
                        System.exit(0);
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (ii != 1); //loop
        }
    }


    public void Patient_login() {

        System.out.println("Enter Username: ");
        String loginUsername = input.nextLine();
        System.out.println("Enter Password: ");
        String loginPassword = input.nextLine();
        Patient loggedInPatient = loginPatient(loginUsername, loginPassword);
        if (loggedInPatient != null) {              //if patient enter username and password correct
            System.out.println("You are now logged in!");
            int ii;
            do {
                System.out.println("\n===Patient Management System ===");
                System.out.println("1. View Profile");
                System.out.println("2. Reserve appointment");
                System.out.println("3. View appointment");
                System.out.println("4. cancel appointment");
                System.out.println("5. update patient details");
                System.out.println("6. Find dentist with name or mobile number");
                System.out.println("7. View Prescription");
                System.out.println("8. Go back to the main menu");
                System.out.println("9. Exit");
                System.out.print("Choose an option: ");
                int choice = input.nextInt();
                input.nextLine(); // Consume newline
                ii = 0;
                String docname="";
                switch (choice) {
                    case 1://patient view profile
                        loggedInPatient.view_Profile();
                        break;
                    case 2://reserve appointment
                        loggedInPatient.CheckPrices();
                        String type="";
                        while(true) {
                            System.out.println("Enter Number you want to reserve");
                           String num = input.nextLine();
                            if (num.equals("1")) {
                                type = "Dental Checkup and Consultation";
                                break;
                            } else if (num.equals("2")) {
                                type = "Teeth Cleaning";
                                break;
                            } else if (num.equals("3")) {
                                type = "Teeth Whitening";
                                break;
                            } else if (num.equals("4")) {
                                type = "Dental Fillings";
                                break;
                            } else if (num.equals("5")) {
                                type = "Dental Crowns";
                                break;
                            }
                            else System.out.println("Invalid input number,please try again.");
                        }
                            listAllDoctors();
                        boolean checker=false;
                        Dentist doc = null;
                        String docName="";
                        do {
                            System.out.print("Doctor's Name: ");
                            docName=input.nextLine();
                            for (Dentist dentist : doctors) {
                                if (dentist.getFirstName().equals(docName)) {
                                    doc = dentist;
                                    checker = true;
                                    break;
                                } else
                                    checker = false;

                            }
                            if (checker == false)
                                System.out.println("Doctor name is incorrect!");
                        }while(checker==false);

                        docname=docName;
                        String Choosen_day="";
                        while (true) {
                            AvailableDays();
                            System.out.println("Enter a day number (1 to 7):");
                            String day = input.nextLine();

                            switch (day) {

                                case "1":
                                    Choosen_day = "Sunday";
                                    break;
                                case "2":
                                    Choosen_day = "Monday";
                                    break;
                                case "3":
                                    Choosen_day = "Tuesday";
                                    break;
                                case "4":
                                    Choosen_day = "Wednesday";
                                    break;
                                case "5":
                                    Choosen_day = "Thursday";
                                    break;
                                case "6":
                                    System.out.println("Sorry we are not available on this day ^_^.");
                                    break;
                                case "7":
                                    Choosen_day = "Saturday";
                                    break;
                                default:
                                    System.out.println("Invalid input, please enter a valid number (1 to 7).");
                                    continue; // Restart the loop for invalid inputs
                            }

                            // Break the loop if a valid day other than Friday (6) is chosen
                            if (!day.equals("6")) {
                                break;
                            }
                        }
                       String time=Availabletimes();
                        System.out.print("Add any notes:");
                        String notes=input.nextLine();


                        reserveAppointment(loggedInPatient,docName,Choosen_day,time,notes,type);
//                        Appointment appointment = new Appointment(loggedInPatient, date, time, type);  old
                        break;
                    case 3://view appointment
//                          loggedInPatient.displayAppointment();   old
                        viewPatientAppointments(loggedInPatient.getUsername(),docname);
                        break;
                    case 4: //cancel appointment
                       cancelReservation(docname,loggedInPatient,loggedInPatient.getDate(),loggedInPatient.getTime());
                        break;

                    case 5:
                        Scanner scanner = new Scanner(System.in);

                        String mobile_number;
                        while (true) {

                            System.out.print("Enter new Mobile number: ");
                            mobile_number = input.nextLine();
                            if (mobile_number.matches(regex)) {
                                break;
                            }
                            else{
                                System.out.println("Invalid mobile number. Please try again.");
                            }
                        }
                        String email;
                        while (true) {

                            System.out.print("Enter new Email: ");
                            email = input.nextLine();
                            if (email.matches(regex2)) {
                                break;
                            }
                            else{
                                System.out.println("Invalid Email. Please try again.(make it @gmail.com or @yahoo.com)");
                            }
                        }

                        double weight;
                        while (true) {
                            System.out.print("Enter Your Weight: ");
                            if (input.hasNextDouble()) {
                                weight = input.nextDouble();
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter a valid number.");
                                input.next(); // Clear the invalid input
                            }
                        }
                        double height;
                        while (true) {
                            System.out.print("Enter Your Height: ");
                            if (input.hasNextDouble()) {
                                height = input.nextDouble();
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter a valid number.");
                                input.next(); // Clear the invalid input
                            }
                        }
                        loggedInPatient .change_patient_details(email,mobile_number,weight,height);
                        savePatientsToFile();
                        break;
                    case 6:
                        System.out.println("1-search by dr_name:");
                        System.out.println("2-search by mobile number:");
                        String s=input.nextLine();
                        if (s.equals("1"))
                        {
                            System.out.print("Enter Doctor name: ");
                            boolean x = false;
                            String name = input.nextLine();
                            for (Dentist d : doctors) {
                                if (d.getFirstName().equals(name)) {
                                    loggedInPatient.getDentist(d);
                                    x = true;
                                    break;
                                }
                                else
                                    x = false;
                            }
                            if(x==false) {
                                System.out.println("Name is incorrect");
                            }
                            break;
                        }

                        else if (s.equals("2"))
                        {
                            System.out.println("Enter dr mobile number");
                            boolean x = false;
                            String mobilen = input.nextLine();
                            for (Dentist dentist : doctors) {
                                if (dentist.getMobile_number().equals(mobilen)) {
                                    loggedInPatient.getDentist1(dentist);
                                    x = true;
                                    break;
                                } else
                                    x = false;
                            }
                            if (x==false)
                                System.out.println("mobile number is not available");
                            break;
                        }
                        else
                            System.out.println("invalid input");

                    case 7:
                        loggedInPatient.viewprescription();
                        break;
                    case 8://Go back to Main Menu
                        ii = 1;
                        break;
                    case 9://Exit the system
                        System.out.println("Exiting the system. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (ii != 1); //loop

 }
}


    // Reserve Appointment for a Patient
    public void reserveAppointment(Patient patient,String doctorName,String date,String time,String notes,String type) {
        Appointment appointment = new Appointment(doctorName, date, time,notes,patient.getFirstName(), type);
        appointments.add(appointment);
        // Add appointment to patient's history
        String record = "Appointment: " + type + " on " + date + " at " + time +" "+"with Dr:"+doctorName;
        patient.addMedicalRecord(record);
        patient.reserveAppointment(appointment,date, time, type);
        savePatientsToFile();
        saveAppToFile();
    }

//    // Cancel Appointment for a Patient
//    public void cancelAppointment(String patientUsername) {
//        Patient patient = findPatientByUsername(patientUsername);
//
//        if (patient == null) {
//            System.out.println("Patient not found!");
//            return;
//        }
//
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter Doctor Name:");
//        String doctorName = input.nextLine();
//
//        System.out.println("Enter Date of Appointment (e.g., 2024-06-25):");
//        String date = input.nextLine();
//
//        patient.cancelAppointment(doctorName, date);
//    }

    public void cancelReservation(String doctorName,Patient p, String date, String time) {
        boolean appointmentFound = false;
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            if (    appointment.getDate().equalsIgnoreCase(date) &&
                    appointment.getTime().equalsIgnoreCase(time)) {
                appointments.remove(i); // Remove the appointment from the list
                p.setDate("No Appointment date");
                p.setTime("No Appointment time");
                p.setType("No Appointment type");
                appointmentFound = true;
                System.out.println("Appointment successfully canceled.");
                saveAppToFile(); // Save the updated list to the file
                savePatientsToFile();
                break;
            }
        }

        if (!appointmentFound) {
            System.out.println("No matching appointment found for the given details.");
        }
    }


    private Patient findPatientByUsername(String username) {
        for (Patient patient : patients) {
            if (patient.getUsername().equals(username)) {
                return patient;
            }
        }
        return null;
    }

    public void viewPatientAppointments(String patientUsername,String docName) {
        Patient patient = findPatientByUsername(patientUsername);
        if (patient != null) {
            patient.displayAppointment(docName);
        } else {
            System.out.println("Patient not found!");
        }
    }

    public void AvailableDays(){
        String days[]={"Sunday","Monday","Tuseday","Wendesday","Thursday","Friday","Saturday"};
        System.out.println("Choose a day");
        for (int i=0;i<7;i++){
            System.out.println(i+1+". "+days[i]);
        }


    }

    public String Availabletimes() {
        System.out.println("Available hours:");
        for (int i = 12; i < 21; i++) {
            System.out.print(i + ":00\t");
        }
        System.out.println(); // Move to the next line after printing times.

        String chosenTime;
        while (true) {
            System.out.println("Please choose an available time (12 to 20):");
            chosenTime = input.nextLine();
            // Validate the input
            if (chosenTime.matches("\\d+") && Integer.parseInt(chosenTime) >= 12 && Integer.parseInt(chosenTime) <= 20) {
                System.out.println("You have chosen " + chosenTime + ":00");
                break;
            } else {
                System.out.println("Invalid input. Please enter a number between 12 and 20.");
            }
        }
        return chosenTime;
    }
public void viewStaff(){
    System.out.println("==== This is Our Staff ====");
        listAllDoctors();
        listAllReceptionists();
    }


}
