public class Test {

    // DO NOT DO ANYTHING ON TEST CLASS
    // THIS CLASS WIL BE USED FOR TESTING
    //ONLY WORK ON 5 CLASSES BELOW

    //1-CPUOperation.java
    //2-Instruction.java
    //3- ComplexNumber.java
    //4- ComplexNumberOperatios.java
    //5- ArrayOperation.java
    // Please read HW3.pdf for more information about CPUOperation

    public static void main(String[] args) {
        int grade=0;

        Instruction I1=new Instruction(0,0,0,1,0,1,1,1,0,1,0,0,1);
        Instruction I2=new Instruction(0,0,0,0,1,1,1,1,0,0,1,1,1);
        Instruction I3=new Instruction(0,0,1,1,1,0,1,1,1,0,1,1,0);
        Instruction I4=new Instruction(0,1,0,0,1,1,1,1,1,0,1,0,1);
        Instruction I5=new Instruction(0,1,0,1,1,0,0,1,0,1,1,1,1);
        Instruction I6=new Instruction(0,1,1,0,1,1,1,0,0,0,0,1,1);
        Instruction I7=new Instruction(1,0,0,1,0,1,0,1,0,0,1,0,1);
        Instruction I8=new Instruction(1,0,1,0,0,1,1,1,1,1,1,1,1);
        Instruction I9=new Instruction(1,1,0,1,1,0,1,1,0,0,0,1,1);
        Instruction I10=new Instruction(1,1,1,1,0,0,1,1,1,1,1,1,1);

        CPUOperation cpu=new CPUOperation();
        //P1
        if(cpu.execute(I1)==2) {
            grade += 4;
            System.out.println("P1 is true");
        }
        else{
            System.out.println("P1 is wrong");
        }
        //P2
        if(cpu.execute(I2)==22){
            grade+=4;
            System.out.println("P2 is true");
        }
        else{
            System.out.println("P2 is wrong");
        }
        //P3
        if(cpu.execute(I3)==-5){
            grade+=4;
            System.out.println("P3 is true");
        }
        else{
            System.out.println("P3 is wrong");
        }
        //P4
        if(cpu.execute(I4)==-75){
            grade+=4;
            System.out.println("P4 is true");
        }
        else{
            System.out.println("P4 is wrong");
        }
        //P5
        if(cpu.execute(I5)==-135){
            grade+=4;
            System.out.println("P5 is true");
        }
        else{
            System.out.println("P5 is wrong");
        }
        //P6
        if(cpu.execute(I6)==4){
            grade+=4;
            System.out.println("P6 is true");
        }
        else{
            System.out.println("P6 is wrong");
        }
        //P7
        if(cpu.execute(I7)==5){
            grade+=4;
            System.out.println("P7 is true");
        }
        else{
            System.out.println("P7 is wrong");
        }
        //P8
        if(cpu.execute(I8)==-15){
            grade+=4;
            System.out.println("P8 is true");
        }
        else{
            System.out.println("P8 is wrong");
        }
        //P9
        if(cpu.execute(I9)==355){
            grade+=4;
            System.out.println("P9 is true");
        }
        else{
            System.out.println("P9 is wrong");
        }
        //P10
        if(cpu.execute(I10)==127){
            grade+=4;
            System.out.println("P10 is true");
        }
        else{
            System.out.println("P10 is wrong");
        }

        ComplexNumber c1=new ComplexNumber("3+4i");
        ComplexNumber c2=new ComplexNumber("-2i");
        ComplexNumber c3=new ComplexNumber("4");
        ComplexNumber c4=new ComplexNumber("4+4i");
        ComplexNumber c5=new ComplexNumber("5-12i");
        ComplexNumber c6=new ComplexNumber();
        ComplexNumber c7=new ComplexNumber("4+4i");
        ComplexNumber c8=new ComplexNumber("-2-4i");

        ComplexNumberOperatios cno=new ComplexNumberOperatios();
        //P11

        if(cno.add(c1,c2).equals("3+2i")){
            grade+=5;
            System.out.println("P11 is true");
        }
        else{
            System.out.println("P11 is wrong");
        }
        //P12
        if(cno.subtract(c1,c3).equals("-1+4i")){
            grade+=5;
            System.out.println("P12 is true");
        }
        else{
            System.out.println("P12 is wrong");
        }
        //P13
        if(cno.multiply(c1,c4).equals("-4+28i")){
            grade+=5;
            System.out.println("P13 is true");
        }
        else{
            System.out.println("P13 is wrong");
        }
        //P14
        if(cno.multiply(c5,c6).equals("0")){
            grade+=5;
            System.out.println("P14 is true");
        }
        else{
            System.out.println("P14 is wrong");
        }
        //P15
        if(cno.distanceBetweenTwoComplexNumbers(c4,c8)==10){
            grade+=5;
            System.out.println("P15 is true");
        }
        else{
            System.out.println("P15 is wrong");
        }
        //P16
        if(cno.modulo(c5)==13){
            grade+=5;
            System.out.println("P16 is true");
        }
        else{
            System.out.println("P16 is wrong");
        }
        //P17
        if(cno.conjugate(c4).equals("4-4i")){
            grade+=5;
            System.out.println("P17 is true");

        }
        else{
            System.out.println("P17 is wrong");
        }
        //P18
        if(cno.isEqual(c4,c7)){
            grade+=5;
            System.out.println("P18 is true");
        }
        else{
            System.out.println("P18 is wrong");
        }


        int[] array1={3,11,5,7,8,9,11,15,13,9,11,15,13};
        int[] array2={6,2,3,4,5,1,8,12};
        int[] array3={4,5,4,8,7,4,4,1,8,7,4,4,1,8,4};
        int[] array4={1,3,2,5};
        int[] array5={4,5,1,3,2};

        ArrayOperation ao=new ArrayOperation();
        //P19
        if(ao.secondLargestElementsOfanArray(array1)==13){
            grade+=5;
            System.out.println("P19 is true");
        }
        else{
            System.out.println("P19 is wrong");
        }
        //P20
        if(ao.numberOfevenNumbers(array2)==5){
            grade+=5;
            System.out.println("P20 is true");
        }
        else{
            System.out.println("P20 is wrong");
        }
        //P21
        if(ao.theMostRepeatedElement(array3)==4){
            grade+=5;
            System.out.println("P21 is true");
        }
        else{
            System.out.println("P21 is wrong");
        }
        //P22
        if(ao.numberOfElementsInUnionOfTwoArray(array4,array5)==5){
            grade+=5;
            System.out.println("P22 is true");
        }
        else{
            System.out.println("P22 is wrong");
        }
        System.out.println("Your Grade is->"+grade);
    }
}
