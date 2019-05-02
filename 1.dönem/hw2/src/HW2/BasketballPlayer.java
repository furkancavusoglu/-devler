package HW2;

public class BasketballPlayer extends Player {

    protected Team team;
    protected String position;

    // Do not change anything in this method
    public static int getNumber() {
        return number;
    }

    // Fill in the blanks. Do not forget to use the keyword "super"
    public BasketballPlayer(String name, int weight, int height, Team team,
                            String position) {
    super(name,weight,height);
    this.team=team;
    this.position=position;
    }

    // Erase the content. Fill in the blanks. If heights and positions are equal, it returns true
    @Override
    public boolean equals(Object obj) {
        BasketballPlayer a= (BasketballPlayer) obj;
        return this.height==a.height&&this.position==a.position;
    }

    // Erase the content.
    // Fill in the blanks. Format: [name]@[teamName]-H:[height]-W:[weight]
    // For example: Jim@Spurs-H:202-W:112
    @Override
    public String toString() {

        return name+"@"+this.team.getName()+"-H:"+String.valueOf(this.height)+"-W:"+String.valueOf(this.weight);

    }

    // Erase the content. Fill in the blanks. It calculates body mass index.
    public double calculateBMI() {

        return  weight/((height/100)*(height/100));
    }
}
