package Project;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ParkArea park1 = new ParkArea(15, Location.ODUNPAZARI);
        ParkArea park2 = new ParkArea(20, Location.TEPEBAŞI);
        ParkArea park3 = new ParkArea(30, Location.İNÖNÜ);
        ParkArea park4 = new ParkArea(25, Location.SEYİTGAZİ);
        ParkArea park5 = new ParkArea(10, Location.MAHMUDİYE);
        boolean isValid = false;
        int hour=0;
        Customer customer1=new Customer(Location.ALPU, 0);
        System.out.println("--------------EasyPark--------------\n" +
                "                                    \n" +
                "              WELCOME               \n" +
                "                                    \n" +
                " Please enter your current location \n" +
                "      and reservation hour:         \n" +
                "------------------------------------\n");
        while (isValid == false) {
            String location = scan.next();
            hour = scan.nextInt();
            if(hour<0&& hour>24){
                System.out.println("invalid hour");
                break;
            }
            for (Location l : Location.values()) {
                if (l.toString().equalsIgnoreCase(location)) {
                    customer1 = new Customer(l, hour);
                    isValid = true;
                }
            }
            if (customer1.location == null)
                System.out.println("You didnt't entered valid input,please try again.");
        }
        customer1.makeReservation();
        System.out.println("Occupancy rate is:"+customer1.search().occupancyRate(hour));
        System.out.println("Your price is: "+customer1.setPrice());
    }
}
