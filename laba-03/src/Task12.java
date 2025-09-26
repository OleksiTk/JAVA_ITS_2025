public class Task12 {
    public static void main(String[] args) {
        // Valid test cases with different precision levels
        printResults(0.1);          // low precision
        printResults(0.01);         // medium precision
        printResults(0.001);        // high precision
        printResults(0.0001);       // very high precision
        printResults(0.00001);      // extremely high precision
        printResults(1e-6);         // scientific notation
        printResults(1e-10);        // very small epsilon
        
        // Edge cases
        printResults(1.0);          // large epsilon
        printResults(0.5);          // medium epsilon
        
        // Invalid test cases (should throw exceptions)
        printResults(0.0);          // zero epsilon
        printResults(-0.1);         // negative epsilon
        printResults(-1e-5);        // small negative epsilon
        printResults(Double.NaN);   // NaN
        printResults(Double.POSITIVE_INFINITY);  // infinity
    }
    

    public static double calculateInfiniteSum(double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("Parameter epsilon must be positive: epsilon = " + epsilon);
        }
        if (Double.isNaN(epsilon)) {
            throw new IllegalArgumentException("Parameter epsilon cannot be NaN: epsilon = " + epsilon);
        }
        if (Double.isInfinite(epsilon)) {
            throw new IllegalArgumentException("Parameter epsilon cannot be infinite: epsilon = " + epsilon);
        }
        
        double sum = 0.0;
        int i = 1;
        double term;
        
        do {
            term = 1.0 / (i * (i + 1.0));
            sum += term;
            i++;
        } while (Math.abs(term) >= epsilon);
        
        return sum;
    }
    

    public static double[] calculateInfiniteSumWithTermCount(double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("Parameter epsilon must be positive: epsilon = " + epsilon);
        }
        if (Double.isNaN(epsilon)) {
            throw new IllegalArgumentException("Parameter epsilon cannot be NaN: epsilon = " + epsilon);
        }
        if (Double.isInfinite(epsilon)) {
            throw new IllegalArgumentException("Parameter epsilon cannot be infinite: epsilon = " + epsilon);
        }
        
        double sum = 0.0;
        int i = 1;
        double term;
        
        do {
            term = 1.0 / (i * (i + 1.0));
            sum += term;
            i++;
        } while (Math.abs(term) >= epsilon);
        
        return new double[]{sum, i - 1}; 
    }

    static void printResults(double epsilon) {
        System.out.print("epsilon:" + epsilon + " result:");
        try {
            double result = calculateInfiniteSum(epsilon);
            double[] resultWithCount = calculateInfiniteSumWithTermCount(epsilon);
            System.out.printf("%.10f (terms used: %.0f)%n", result, resultWithCount[1]);
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}