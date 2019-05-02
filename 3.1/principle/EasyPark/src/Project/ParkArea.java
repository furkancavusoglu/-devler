package Project;

import java.util.ArrayList;

public class ParkArea {
    ArrayList<ParkSlot> parkSlots=new ArrayList<>();
    Location location;
    static ArrayList<ParkArea> parkAreas= new ArrayList<>();
    //Creating parking area with number of parking slots
    ParkArea(int numOfSlots,Location location) {
        this.location=location;
        for (int i = 0; i < numOfSlots; i++) {
            parkSlots.add(new ParkSlot());
        }
        parkAreas.add(this);
    }
    //adding new parking slot to the parking area
    void addParkingSlot(int number){
        for(int i=0;i<number;i++)
            parkSlots.add(new ParkSlot());
    }//calculating the occupancy rate
    double occupancyRate(int hour){
        double filled=0;
        for(ParkSlot ps:parkSlots){
            if(!(ps.isEmpty(hour))){
                filled++;
            }
        }
        return filled/parkSlots.size();
    }

}
