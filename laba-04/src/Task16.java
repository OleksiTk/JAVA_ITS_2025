
public class Task16 {
        
    public static double findGeometricMeanOfEvenElements(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }
        
        double product = 1.0;
        int count = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                product *= array[i];
                count++;
            }
        }
        
        if (count == 0) {
            throw new IllegalArgumentException("У масиві немає парних елементів");
        }
        
        return Math.pow(product, 1.0 / count);
    }
    
    public static void main(String[] args) {
        System.out.println("=== Завдання 16: Середнє геометричне парних елементів ===\n");

        int[] test1 = {2, 3, 4, 5, 6};
        System.out.println("Тест 1: {2, 3, 4, 5, 6}");
        try {
            double result = findGeometricMeanOfEvenElements(test1);
            System.out.println("Результат: " + result);
            System.out.println("Перевірка: (2 * 4 * 6)^(1/3) = " + Math.pow(48, 1.0/3));
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        
   
        int[] test2 = {2, 4, 8};
        System.out.println("Тест 2: {2, 4, 8}");
        try {
            double result = findGeometricMeanOfEvenElements(test2);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        
        
        int[] test3 = {1, 3, 5, 7};
        System.out.println("Тест 3: {1, 3, 5, 7} - немає парних");
        try {
            double result = findGeometricMeanOfEvenElements(test3);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        
    
        int[] test4 = {-4, 3, -2, 5, 6};
        System.out.println("Тест 4: {-4, 3, -2, 5, 6}");
        try {
            double result = findGeometricMeanOfEvenElements(test4);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        
        
        int[] test5 = {};
        System.out.println("Тест 5: {} - порожній масив");
        try {
            double result = findGeometricMeanOfEvenElements(test5);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
  
        int[] test6 = null;
        System.out.println("Тест 6: null - нульовий масив");
        try {
            double result = findGeometricMeanOfEvenElements(test6);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        

        int[] test7 = {10};
        System.out.println("Тест 7: {10} - один елемент");
        try {
            double result = findGeometricMeanOfEvenElements(test7);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}