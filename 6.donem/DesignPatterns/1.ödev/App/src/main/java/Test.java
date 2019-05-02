public class Test {
    public static void main(String[] args) {
        Pub social = new Pub();
        NightClub mood= new NightClub();
        User furkan = new User(social, "furkan");
        mood.registerObserver(furkan);


        System.out.println("Welcome to the NightLife, the app that find the best hangout for your night!"+
                " Tonight's events are: ");
        social.setStatus("Social", "barlar sokağı", "Bomonti %20 discount", "Beerpong");
        mood.setStatus("Mood", "Ismet Inonu Boulevard", "Enterance Free",
                "Spring Mood", "Onur Oflaz");
    }
}
