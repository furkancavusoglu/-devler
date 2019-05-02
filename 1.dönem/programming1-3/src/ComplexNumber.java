public class ComplexNumber {
    int realPart, imaginaryPart;

    public ComplexNumber() {
        realPart = 0;
        imaginaryPart = 0;
        // no-arg constructor
        // create a complex number with realPart=0 and imaginaryPart=0 which is 0+0i
    }

    public ComplexNumber(String c) {
        //write your code here
        // parse the parameter c
        // consider that complex number c is in the form of x+yi there is no space in it
        // consider that complex number c is not in the form of x+ yi, x + yi, x+ y i, x+ i y
        // extract complex number's real and imaginary parts from c
        // if c=3+4i than realPart=3 and imaginaryPart=4
        // if c=3-4i than realPart=3 and imaginaryPart=4
        // if c=-3+4i than realPart=-3 and imaginaryPart=4
        // if c=-3-4i than realPart=-3 and imaginaryPart=-4
        // if c=4i than realPart=0 and imaginaryPart=4
        // if c=-4i than realPart=0 and imaginaryPart=-4
        // if c=3 than realPart=3 and imaginaryPart=0
        // if c=-3 than realPart=-3 and imaginaryPart=0
        String[] number;
        String real = "";
        String imagine = "";
        boolean negative = false;
        if (c.matches("(.*)\\+(.*)")) {
            number = c.split("\\+");
            for (int i = 0; i < number[0].length(); i++) {
                if (number[0].matches("(.*)-(.*)"))
                    negative = true;
                if (Character.isDigit(number[0].charAt(i)))
                    real += number[0].charAt(i);
            }
            realPart = negative ? -1 * Integer.parseInt(real) : Integer.parseInt(real);
            for (int j = 0; j < number[1].length(); j++) {
                if (Character.isDigit(number[1].charAt(j)))
                    imagine += number[1].charAt(j);
            }
            imaginaryPart = Integer.parseInt(imagine);
        } else if (c.matches("(.*)-(.*)") && c.matches("(.*)i(.*)") && c.length() >= 5) {
            if (c.charAt(0) == '-') {
                negative = true;
                c = c.substring(1);
            }
            number = c.split("-");
            for (int i = 0; i < number[0].length(); i++) {
                if (Character.isDigit(number[0].charAt(i)))
                    real += number[0].charAt(i);
            }
            realPart = negative ? -1 * Integer.parseInt(real) : Integer.parseInt(real);
            negative = false;
            for (int i = 0; i < number[1].length(); i++) {
                if (Character.isDigit(number[1].charAt(i)))
                    imagine += number[1].charAt(i);
            }
            negative = true;
            imaginaryPart = negative ? -1 * Integer.parseInt(imagine) : Integer.parseInt(imagine);
        } else {
            if (c.matches("(.*)i(.*)")) {
                for (int i = 0; i < c.length(); i++) {
                    if (Character.isDigit(c.charAt(i)))
                        imagine += c.charAt(i);
                    if (c.charAt(i) == '-')
                        negative = true;
                }
                realPart = 0;
                imaginaryPart = negative ? -1 * Integer.parseInt(imagine) : Integer.parseInt(imagine);
            } else {
                for (int i = 0; i < c.length(); i++) {
                    if (Character.isDigit(c.charAt(i)))
                        real += c.charAt(i);
                    if (c.charAt(i) == '-')
                        negative = true;
                }
                imaginaryPart = 0;
                realPart = negative ? -1 * Integer.parseInt(real) : Integer.parseInt(real);
            }
        }
    }
}
