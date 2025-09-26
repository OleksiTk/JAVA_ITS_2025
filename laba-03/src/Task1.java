public class Task1 {
    public static void main(String[] args) {
        // Valid test cases
        printResults(1, 1);
        printResults(2, 5);
        printResults(5, 10);
        printResults(10, 20);
        printResults(15, 30);
        printResults(Math.PI, 15);
        printResults(0.5, 5);
        
        // Edge cases
        printResults(0, 1);
        printResults(1, 0);
        printResults(100, 1);
        
        // Invalid test cases (should throw exceptions)
        printResults(-1, 5);    // negative m
        printResults(5, -1);    // negative k
        printResults(5, 31);    // k > 30
        printResults(0, 0);     // both zero
        printResults(-5, -5);   // both negative
    }
    
    public static double calculateSeriesSum(double m, int k) {
        if (m <= 0) {
            throw new IllegalArgumentException("Parameter m must be positive: m = " + m);
        }
        if (k <= 0) {
            throw new IllegalArgumentException("Parameter k must be positive: k = " + k);
        }
        if (k > 30) {
            throw new IllegalArgumentException("Parameter k must not exceed 30: k = " + k);
        }
        
        double sum = 0.0;
        for (int i = 1; i <= k; i++) {
            double term = Math.sqrt(m / i) * Math.sin(m - i);
            sum += term;
        }
        
        return sum;
    }
    

    static void printResults(double m, int k) {
        System.out.print("m:" + m + " k:" + k + " result:");
        try {
            System.out.println(calculateSeriesSum(m, k));
        } catch (IllegalArgumentException e) {
            System.out.println("EXCEPTION! " + e.getMessage());
        }
    }
}