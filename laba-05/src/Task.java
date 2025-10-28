import java.util.Arrays;

public class Task {
    
    // Метод 1: Bubble Sort 
    public static void bubbleSort(byte[] arr) {
        int n = arr.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // Для сортування по спаданню: якщо поточний елемент менший за наступний
                if (arr[j] < arr[j + 1]) {
                    // Обмін елементів
                    byte temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Якщо не було обмінів, масив вже відсортований
            if (!swapped) {
                break;
            }
        }
    }
    
    // Метод 2: Selection Sort 
    public static void selectionSort(byte[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            // Знаходимо індекс максимального елемента в невідсортованій частині
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            
            // Обмінюємо знайдений максимальний елемент з першим елементом
            if (maxIdx != i) {
                byte temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;
            }
        }
    }
    
    public static void printArray(byte[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
  
    public static byte[] copyArray(byte[] arr) {
        byte[] copy = new byte[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        return copy;
    }
    
    public static void main(String[] args) {
        // Створюємо тестовий масив
        byte[] original = {15, -3, 42, 7, -15, 23, 8, -42, 0, 31, -8, 16};
        
        System.out.println("=== ЛАБОРАТОРНА РОБОТА  - ВАРІАНТ 16 ===");
        System.out.println("Тип масиву: byte[]");
        System.out.println("Порядок сортування: по спаданню\n");
        
        System.out.println("Оригінальний масив:");
        printArray(original);
        System.out.println();
        
        // Тестування Bubble Sort
        System.out.println("--- МЕТОД 1: BUBBLE SORT ---");
        byte[] arr1 = copyArray(original);
        long startTime1 = System.nanoTime();
        bubbleSort(arr1);
        long endTime1 = System.nanoTime();
        System.out.println("Відсортований масив:");
        printArray(arr1);
        System.out.println("Час виконання: " + (endTime1 - startTime1) + " наносекунд");
        System.out.println();
        
        // Тестування Selection Sort
        System.out.println("--- МЕТОД 2: SELECTION SORT ---");
        byte[] arr2 = copyArray(original);
        long startTime2 = System.nanoTime();
        selectionSort(arr2);
        long endTime2 = System.nanoTime();
        System.out.println("Відсортований масив:");
        printArray(arr2);
        System.out.println("Час виконання: " + (endTime2 - startTime2) + " наносекунд");
        System.out.println();
        
        // Перевірка правильності
        System.out.println("--- ПЕРЕВІРКА ---");
        System.out.println("Обидва методи дали однаковий результат: " + 
                          Arrays.equals(arr1, arr2));
        
        // Додаткові тести
        System.out.println("\n=== ДОДАТКОВІ ТЕСТИ ===");
        
        // Тест 1: Вже відсортований масив
        System.out.println("\nТест 1: Вже відсортований по спаданню масив");
        byte[] sorted = {50, 40, 30, 20, 10, 0, -10, -20};
        System.out.print("До: ");
        printArray(sorted);
        bubbleSort(copyArray(sorted));
        System.out.print("Після Bubble Sort: ");
        printArray(sorted);
        
        // Тест 2: Відсортований у зворотному порядку
        System.out.println("\nТест 2: Відсортований по зростанню (найгірший випадок)");
        byte[] reversed = {-20, -10, 0, 10, 20, 30, 40, 50};
        System.out.print("До: ");
        printArray(reversed);
        byte[] rev1 = copyArray(reversed);
        bubbleSort(rev1);
        System.out.print("Після Bubble Sort: ");
        printArray(rev1);
        
        // Тест 3: Масив з однаковими елементами
        System.out.println("\nТест 3: Масив з однаковими елементами");
        byte[] same = {5, 5, 5, 5, 5};
        System.out.print("До: ");
        printArray(same);
        selectionSort(same);
        System.out.print("Після Selection Sort: ");
        printArray(same);
    }
}