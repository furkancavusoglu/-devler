package HW2;

public class Team {

    protected String name;
    protected int foundationYear;
    public static int number;


    // Do not change anything in this method
    public String getName() {
        return name;
    }


    // Fill in the blanks.
    public Team(String name, int foundationYear) {
        this.name=name;
        this.foundationYear=foundationYear;
        number++;


    }
    // Erase the content. Fill in the blanks. If name and foundationYear are equal, it returns true
    @Override
    public boolean equals(Object obj) {
        BasketballTeam a= (BasketballTeam) obj;
        return (a.foundationYear==((BasketballTeam) obj).foundationYear)&&
                (a.name==((BasketballTeam) obj).name);
    }
    // Erase the content. Fill in the blanks. Format: [name]/[foundationYear]
    // For example: Lakers/1946
    @Override
    public String toString() {

        return this.name+"/"+String.valueOf(foundationYear);

    }




}
