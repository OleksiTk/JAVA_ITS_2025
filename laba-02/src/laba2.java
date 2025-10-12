public class laba2 {
    public static void main(String[] args) {
        firstExercise();
        secondExercise();
        thirdExercise();
    }
    public static void firstExercise (){
        double a = -1.23;
        double b = -0.34;
        double c = 0.707;
        double d = 2.312;

        double logTerm = Math.log10(Math.abs(b / a));

        double trigExpTerm = Math.sqrt(Math.sin(c) + Math.exp(d));

    
        double y = 3 * (logTerm + trigExpTerm);

        System.out.printf("y = %.5f\n", y);
    }
    public static void secondExercise(){
                double a = 0.58;
        double b = 0.34;
        double c = 1.25;
        double d = -1.89;

        double numerator = Math.sin(a);

        double denominator = Math.acos(-2 * b);

        double firstPart = 2 * (numerator / denominator);

        double insideLog = c * Math.abs(2 * d);
        double secondPart = Math.sqrt(Math.log(insideLog));

        double y = firstPart - secondPart;

        System.out.printf("y = %.5f\n", y);
    }
    public static void thirdExercise(){
     double a = 1.27;
        double b = 10.99;
        double c = 4;
        double d = -25.32;

        double numerator = Math.pow(Math.tan(a), 1.0 / 6);

   
        double denominator = Math.sinh(b);

     
        double topFraction = numerator / denominator;

      
        double logPart = Math.log(Math.abs(d + c));


        double bottomPart = 2 - (1 / logPart);


        double y = topFraction / bottomPart;

        System.out.printf("y = %.5f\n", y);
    }
}


