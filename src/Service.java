import java.util.Scanner;
public class Service {
    private final int ServiceID;
    private String Name;
    float cost;
    String duration;

    public Service(){
        ServiceID=0;
        Name=null;
        this.cost=0;
        this.duration=null;
    }
    public Service(int serviceID, String name, float cost, String duration) {
        ServiceID = serviceID;
        Name = name;
        this.cost = cost;
        this.duration = duration;
    }


    public int getServiceID() {
        return ServiceID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    public void updateService(){
        Scanner myObj = new Scanner(System.in);

        System.out.println("select the attribute you want to update : ");
        System.out.println("1-name\n2-cost\n3-duration");
        int x=myObj.nextInt();
        if (x==1){
            System.out.println("type the new name : ");
            String y=myObj.next();
            setName(y);
        }
        else if (x==2){

            System.out.println("type the new cost : ");
            float y=myObj.nextFloat();
            setCost(y);
        }
        else if (x==3){

            System.out.println("type the new duration : ");
            String y=myObj.next();
            setDuration(y);
        }
        else System.out.println("ERROR!\nnone of the specified numbers was chosen");
    }

    @Override
    public String toString() {
        return "Service{" +
                "ServiceID=" + ServiceID +
                ", Name='" + Name + '\'' +
                ", cost=" + cost +
                ", duration='" + duration + '\'' +
                '}';
    }
    public String viewDetails(){
        return toString();
    }
}
