package Project;


public class Customer {
    Location location;
    private double price;
    int hour;
    Customer(Location location,int hour){
        this.location=location;
        this.hour=hour;
    }//finding the nearest park area
    ParkArea search(){
        for(ParkArea parkArea:ParkArea.parkAreas){
            if(parkArea.location==this.location)
                return parkArea;
        }
        return null;
    }
    //setting the price due of occupancy rate of the park area
    double setPrice(){
        ParkArea selectedParkArea=this.search();
        if(selectedParkArea.occupancyRate(this.hour)<25.0)
            return 10;
        else if(selectedParkArea.occupancyRate(this.hour)<75.0)
            return 15;
        else
            return 20;
    }//making reservation on selected park area and finding available parking slot
    void makeReservation(){
        int i=0;
        ParkArea reservation=this.search();
        for( i=0;i<reservation.parkSlots.size();i++){
            if(reservation.parkSlots.get(i).isEmpty(this.hour)){
                reservation.parkSlots.get(i).fill(this.hour);
                break;
            }
        }
        System.out.println(reservation.location+" ,"+this.hour+" is reserved");
    }

}
