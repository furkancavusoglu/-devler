package Project;

import java.util.HashMap;
        import java.util.Map;

public class ParkSlot {
    private Map<Integer,Boolean> hours =new HashMap<>();

    //Creating the park slot with opening and closing times
    ParkSlot() {
        int morning = 8;
        int night = 20;
        for (int i = morning; i < night; i++) {
            hours.put(i, false);
        }
    }
    //checking if the park slot is empty
    boolean isEmpty(int hour){
        return !(hours.get(hour));
    }
    //filling the hour
    void fill(int hour){
        hours.replace(hour,true);
    }
    //refilling the hour
    void refill(int hour){
        hours.replace(hour,false);
    }
    void clear(){
        hours.clear();
    }
}
