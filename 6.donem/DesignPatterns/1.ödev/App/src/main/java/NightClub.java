import java.util.ArrayList;

public class NightClub implements Subject {
    ArrayList<Observer> observers;
    private String name;
    private String address;
    private String event;
    private String dj;
    private String discount;

    public NightClub() {
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer =  observers.get(i);
            observer.update(name, address, discount, event);
        }
    }

    public void setStatus(String name, String address, String discount, String event, String dj) {
        this.name = name;
        this.address = address;
        this.discount = discount;
        this.event = event;
        this.dj = dj;
        notifyObservers();
    }
}
