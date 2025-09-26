public class Task9 {

    public static void main(String[] args) {
        // Valid test cases
        printResults(1.0, 10);
        printResults(2.0, 15);
        printResults(4.0, 20);
        printResults(0.5, 5);
        printResults(10.0, 30);
        printResults(Math.PI, 25);
        
        // Edge cases
        printResults(0, 10);    // t = 0
        printResults(1, 1);     // minimal terms
        
        // Invalid test cases (should throw exceptions)
        printResults(-1.0, 10);  // negative t
        printResults(1.0, 0);    // zero terms
        printResults(1.0, -5);   // negative terms
        printResults(-5.0, -10); // both negative
    }
    
  
    public static double calculateFunction(double t, int maxTerms) {
        if (t < 0) {
            throw new IllegalArgumentException("Parameter t must be non-negative: t = " + t);
        }
        if (maxTerms <= 0) {
            throw new IllegalArgumentException("Parameter maxTerms must be positive: maxTerms = " + maxTerms);
        }
        
        double sum = 0.0;
        for (int i = 1; i <= maxTerms; i++) {
            double l;
            if (i % 2 == 1) {
                l = i;  // Since i is already odd
            } else {
                l = i;  // Since i is already even
            }
            
            double term = Math.sqrt(t * i) / l;
            sum += term;
        }
        
        return sum;
    }
    
    static void printResults(double t, int maxTerms) {
        System.out.print("t:" + t + " maxTerms:" + maxTerms + " result:");
        try {
            System.out.println(calculateFunction(t, maxTerms));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}