
public class Task62 {
    

    public static int[] transformArrayByMinElement(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }

        int minElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
            }
        }
        

        int[] result = new int[array.length];
        
        if (minElement == 0) {
      
            for (int i = 0; i < result.length; i++) {
                result[i] = -10;
            }
        } else {
        
            for (int i = 0; i < array.length; i++) {
                result[i] = array[i] / minElement;
            }
        }
        
        return result;
    }
    

    private static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
    
    public static void main(String[] args) {
        System.out.println("=== Завдання 62: Трансформація масиву через найменший елемент ===\n");
        
        int[] test1 = {10, 20, 5, 15};
        System.out.println("Тест 1: {10, 20, 5, 15}");
        try {
            int[] result = transformArrayByMinElement(test1);
            System.out.print("Результат: ");
            printArray(result);
            System.out.println("Найменший елемент: 5, всі елементи поділені на 5");
            System.out.println("Перевірка: {10/5, 20/5, 5/5, 15/5} = {2, 4, 1, 3}");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        
        int[] test2 = {5, 0, 10, 3};
        System.out.println("Тест 2: {5, 0, 10, 3}");
        try {
            int[] result = transformArrayByMinElement(test2);
            System.out.print("Результат: ");
            printArray(result);
            System.out.println("Найменший елемент: 0, всі замінені на -10");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        
        int[] test3 = {-6, 12, -3, 9};
        System.out.println("Тест 3: {-6, 12, -3, 9}");
        try {
            int[] result = transformArrayByMinElement(test3);
            System.out.print("Результат: ");
            printArray(result);
            System.out.println("Найменший елемент: -6");
            System.out.println("Перевірка: {-6/-6, 12/-6, -3/-6, 9/-6} = {1, -2, 0, -1}");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        
        int[] test4 = {7, 7, 7, 7};
        System.out.println("Тест 4: {7, 7, 7, 7}");
        try {
            int[] result = transformArrayByMinElement(test4);
            System.out.print("Результат: ");
            printArray(result);
            System.out.println("Найменший елемент: 7, результат {1, 1, 1, 1}");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        
        int[] test5 = {0, 0, 0};
        System.out.println("Тест 5: {0, 0, 0}");
        try {
            int[] result = transformArrayByMinElement(test5);
            System.out.print("Результат: ");
            printArray(result);
            System.out.println("Найменший елемент: 0, всі замінені на -10");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        
        int[] test6 = {4};
        System.out.println("Тест 6: {4}");
        try {
            int[] result = transformArrayByMinElement(test6);
            System.out.print("Результат: ");
            printArray(result);
            System.out.println("Найменший елемент: 4, результат {1}");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        
        int[] test7 = {0};
        System.out.println("Тест 7: {0}");
        try {
            int[] result = transformArrayByMinElement(test7);
            System.out.print("Результат: ");
            printArray(result);
            System.out.println("Найменший елемент: 0, результат {-10}");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        
        int[] test8 = {};
        System.out.println("Тест 8: {} - порожній масив");
        try {
            int[] result = transformArrayByMinElement(test8);
            System.out.print("Результат: ");
            printArray(result);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        
        int[] test9 = null;
        System.out.println("Тест 9: null - нульовий масив");
        try {
            int[] result = transformArrayByMinElement(test9);
            System.out.print("Результат: ");
            printArray(result);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        
        int[] test10 = {-5, 0, 10, -3};
        System.out.println("Тест 10: {-5, 0, 10, -3}");
        try {
            int[] result = transformArrayByMinElement(test10);
            System.out.print("Результат: ");
            printArray(result);
            System.out.println("Найменший елемент: -5");
            System.out.println("Перевірка: {-5/-5, 0/-5, 10/-5, -3/-5} = {1, 0, -2, 0}");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}