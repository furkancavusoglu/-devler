public class ComplexNumberOperatios {
    public String add(ComplexNumber c1, ComplexNumber c2) {
        //write your code here
        // return sum of c1 and c2 as String
        int real = c1.realPart + c2.realPart;
        int imagine = c1.imaginaryPart + c2.imaginaryPart;
        String real2 = String.valueOf(real);
        String imagine2 = String.valueOf(imagine);
        if (imagine > 0)
            return real2 + "+" + imagine2 + "i";
        else
            return real2 + imagine2 + "i";
    }

    public String subtract(ComplexNumber c1, ComplexNumber c2) {
        //write your code here
        // subtract c2 from c1 and return as String
        // if result is 0 than return 0 not 0+0i
        int real = c1.realPart - c2.realPart;
        int imagine = c1.imaginaryPart - c2.imaginaryPart;
        String real2 = String.valueOf(real);
        String imagine2 = String.valueOf(imagine);
        if (imagine > 0)
            return real2 + "+" + imagine2 + "i";
        else if (imagine < 0)
            return real2 + imagine2 + "i";
        else
            return "0";
    }

    public String multiply(ComplexNumber c1, ComplexNumber c2) {
        //write your code here
        // multiply c1 and c2 and return as String
        // if result is 0 than return 0 not 0+0i
        int eq1 = c1.realPart * c2.realPart;
        int eq2 = c1.realPart * c2.imaginaryPart;
        int eq3 = c1.imaginaryPart * c2.realPart;
        int eq4 = c1.imaginaryPart * c2.imaginaryPart;

        int multReal = eq1 + (-1 * eq4);
        int multImg = eq2 + eq3;
        if (multImg > 0)
            return multReal + "+" + multImg + "i";
        else if (multImg < 0)
            return multReal + multImg + "i";
        else
            return "0";
    }

    public String conjugate(ComplexNumber c) {
        //write your code here
        // find The complex conjugate of c and return as String
        // if result is 0 than return 0 not 0+0i
        String real = String.valueOf(c.realPart);
        String imagine = String.valueOf(c.imaginaryPart);
        if (c.imaginaryPart > 0)
            return real + "-" + imagine + "i";
        else if (c.imaginaryPart < 0)
            return real + "+" + imagine + "i";
        else
            return "0";
    }

    double modulo(ComplexNumber c) {
        //write your code here
        // find modulo of c and return double value of it
        // if result is 0 than return 0 not 0+0i
        return Math.sqrt(Math.pow(c.imaginaryPart, 2) + Math.pow(c.realPart, 2));
    }

    double distanceBetweenTwoComplexNumbers(ComplexNumber c1, ComplexNumber c2) {
        //write your code here
        // calculate distance between c1 and c2 and return double value of it.
        double real1 = c1.realPart;
        double real2 = c2.realPart;
        double img1 = c1.imaginaryPart;
        double img2 = c2.imaginaryPart;

        return Math.sqrt(Math.pow(real1 - real2, 2) + Math.pow(img1 - img2, 2));
    }

    Boolean isEqual(ComplexNumber c1, ComplexNumber c2) {
        //write your code here
        // check whether c1 is equal to c2
        // two complex numbers are equal if and only if their real parts and imaginary parts are equal.
        int img1 = c1.imaginaryPart;
        int img2 = c2.imaginaryPart;
        int real1 = c1.realPart;
        int real2 = c2.realPart;
        return img1 == img2 && real1 == real2;

    }
}
