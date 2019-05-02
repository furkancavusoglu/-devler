import java.util.Scanner;

public class UserCommandLine {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        Shape shape= new Circle(0);
        Shape decoratedShape;
        String option;
        String description;

        System.out.println("Please select a shape\n"+
                "[c:Circle | r:Rectangle | s:Square]");

        String input = scan.nextLine();

        if(input.equals("c")) {
            System.out.println("Enter radius:");
            int radius = scan.nextInt();
            shape = new Circle(radius);
        }else if(input.equals("r")) {
            System.out.println("Enter width:");
            int width= scan.nextInt();
            System.out.println("Enter length:");
            int length= scan.nextInt();
            shape= new Rectangle(width,length);
        }else if (input.equals("s")){
            System.out.println("Enter length:");
            int length= scan.nextInt();
            shape= new Square(length);
        }else {
            System.out.println("You entered wrong input.");
            return;
        }
        decoratedShape= shape;
        do{
            System.out.println("Please select for\n"
                    +"[i:Shape Info | l:Add Light(int) | clr:Add Color(String) | cnt:Add Contrast(int) | q:Quit]");
            option = scan.next();
            if(option.equals("i")){
                System.out.println(decoratedShape.printProperties());
            }else if(option.equals("l")){
                System.out.println("Enter light:");
                int l= scan.nextInt();
                Light light= new Light(shape,l);
                decoratedShape= light;
            }else if (option.equals("clr")){
                System.out.println("Enter color:");
                String c= scan.next();
                Color color= new Color(shape,c);
                decoratedShape= color;
            }else if(option.equals("cnt")) {
                System.out.println("Enter contrast:");
                int cont = scan.nextInt();
                Contrast contrast = new Contrast(shape, cont);
                decoratedShape = contrast;
            }
        }while(!option.equals("q"));

        do {
            System.out.println("Please select the material of shape\n"+
                    "[i:Shape Info | cu:Copper | fe:Iron | au:Gold | q:Quit]");
            option= scan.next();
            if(option.equals("i")) {
                System.out.println(decoratedShape.getShapeProperty());
            }else if(option.equals("cu")) {
                Copper c = new Copper(shape);
                System.out.println("Mass for Iron " + shape.toString() + "= " + c.calculateMass());
            }else if(option.equals("fe")) {
                Iron i = new Iron(shape);
                System.out.println("Mass for Iron " + shape.toString() + "= " + i.calculateMass());
            }else if(option.equals("au")) {
                Gold g = new Gold(shape);
                System.out.println("Mass for Iron " + shape.toString() + "= " + g.calculateMass());
            }
        }while(!option.equals("q"));
    }
}