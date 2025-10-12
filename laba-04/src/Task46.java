public class Task46 {
    public static int findSumOfElementsGreaterThan3WithEvenIndex(int[] array) {
        if (array == null) {
            throw new NullPointerException("Масив не може бути null");
        }
        
        if (array.length == 0) {
            throw new IllegalArgumentException("Масив не може бути порожнім");
        }
        
        int sum = 0;
        int index = 0;
        

        for (int element : array) {
            if (index % 2 == 0 && element > 3) {
                sum += element;
            }
            index++;
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Завдання 46: Сума елементів > 3 з парним індексом ===\n");
        

        int[] test1 = {5, 2, 7, 1, 4, 6, 10};
        System.out.println("Тест 1: {5, 2, 7, 1, 4, 6, 10}");
        System.out.println("Індекси:  0  1  2  3  4  5   6");
        try {
            int result = findSumOfElementsGreaterThan3WithEvenIndex(test1);
            System.out.println("Результат: " + result);
            System.out.println("Перевірка: 5(i=0) + 7(i=2) + 4(i=4) + 10(i=6) = 26");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        
      
        int[] test2 = {1, 2, 3, 2, 1};
        System.out.println("Тест 2: {1, 2, 3, 2, 1}");
        System.out.println("Індекси:  0  1  2  3  4");
        try {
            int result = findSumOfElementsGreaterThan3WithEvenIndex(test2);
            System.out.println("Результат: " + result);
            System.out.println("(немає елементів > 3 на парних індексах)");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        

        int[] test3 = {4, 1, 5, 1, 6};
        System.out.println("Тест 3: {4, 1, 5, 1, 6}");
        System.out.println("Індекси:  0  1  2  3  4");
        try {
            int result = findSumOfElementsGreaterThan3WithEvenIndex(test3);
            System.out.println("Результат: " + result);
            System.out.println("Перевірка: 4(i=0) + 5(i=2) + 6(i=4) = 15");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        

        int[] test4 = {10, -5, 4, 3, 8, -2};
        System.out.println("Тест 4: {10, -5, 4, 3, 8, -2}");
        System.out.println("Індекси:   0   1  2  3  4   5");
        try {
            int result = findSumOfElementsGreaterThan3WithEvenIndex(test4);
            System.out.println("Результат: " + result);
            System.out.println("Перевірка: 10(i=0) + 4(i=2) + 8(i=4) = 22");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        
 
        int[] test5 = {};
        System.out.println("Тест 5: {} - порожній масив");
        try {
            int result = findSumOfElementsGreaterThan3WithEvenIndex(test5);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();
        

        int[] test6 = null;
        System.out.println("Тест 6: null - нульовий масив");
        try {
            int result = findSumOfElementsGreaterThan3WithEvenIndex(test6);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();

        int[] test7 = {5};
        System.out.println("Тест 7: {5} - один елемент на індексі 0");
        try {
            int result = findSumOfElementsGreaterThan3WithEvenIndex(test7);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
        System.out.println();

        int[] test8 = {3, 4, 4, 3, 4};
        System.out.println("Тест 8: {3, 4, 4, 3, 4} - перевірка граничного значення 3");
        System.out.println("Індекси:  0  1  2  3  4");
        try {
            int result = findSumOfElementsGreaterThan3WithEvenIndex(test8);
            System.out.println("Результат: " + result);
            System.out.println("Перевірка: 4(i=2) + 4(i=4) = 8 (3 не входить, бо не > 3)");
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
