//ziad
import java.util.Scanner;
public class Person {
    Scanner input = new Scanner(System.in);
    String firstName;
    String lastName;
    private String username;
    private String password;
    private String mobile_number;
    private String Email;

    public Person(String firstname, String lastname, String username, String password, String mobile_number, String email) {
        firstName = firstname;
        lastName = lastname;
        this.username = username;
        this.password = password;
        this.mobile_number = mobile_number;
        this.Email = email;
    }
    public Person(String username,String password){
        this.username=username;
        this.password=password;
    }
    public Person(String username){
        this.username=username;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    public void login() {
        System.out.println("Please Enter your username: ");
        String user = input.nextLine();
        System.out.println("Please Enter your password: ");
        String pass = input.nextLine();
        if (this.username.equals(user) && this.password.equals(pass)) {
            System.out.println("Login Successfully");
        } else {
            System.out.println("Wrong username or password");
            login();//recursion
        }
    }
        public void view_Profile ()  {
            System.out.println("Name: " + firstName + " " + lastName);
            System.out.println("Email: " + Email);
            System.out.println("Mobile Number: " + mobile_number);
        }
    }

