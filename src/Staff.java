//ziad
public class Staff extends Person
{
    int staff_id;
    private final float DoctorSalary=15000;
    private final float ReceptionistSalary=7355;

// constructor
    public Staff(String firstname, String lastname, String username, String password, String mobile_number, String email, int staff_id) {
        super(firstname, lastname, username, password, mobile_number, email);
        this.staff_id = staff_id;
    }
    public Staff(String firstname, String lastname, String username, String password, String mobile_number, String email){
        super(firstname, lastname, username, password, mobile_number, email);
    }
    public Staff(String username,String password){
        super(username,password);

    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public float getDoctorSalary() {
        return DoctorSalary;
    }

    public float getReceptionistSalary() {
        return ReceptionistSalary;
    }
}
