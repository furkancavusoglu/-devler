public class User implements Observer {
    Subject subject;
    String subName;
    String pubName;
    String address;
    String discount;
    String event;

    public User(Subject subject, String subName) {
        this.subName = subName;
        this.subject = subject;
        subject.registerObserver(this);
    }

    public void update(String pubName, String address, String discount, String event) {
        this.pubName = pubName;
        this.address = address;
        this.discount = discount;
        this.event = event;
        display();
    }

    public void display() {
        System.out.println("At " + pubName + " which is in " + address + " has a discount on " + discount + " and tonights event is " + event);
    }
}
