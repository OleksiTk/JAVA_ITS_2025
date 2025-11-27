public class Task {
    public static void main(String[] args) {
        System.out.println(hexStringToInt("CAFE")); // 51966
          String arg = "The user with the nickname koala757677 this month left 3 times more "
               + "comments than the user with the nickname croco181dile181920 4 months ago";

    System.out.println(countWords(arg)); // 19
    }
     public static int hexStringToInt(String s) {
    int result = 0;

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        int digit;

        if (c >= '0' && c <= '9') {
            digit = c - '0';
        } else if (c >= 'A' && c <= 'F') {
            digit = 10 + (c - 'A');
        } else if (c >= 'a' && c <= 'f') {
            digit = 10 + (c - 'a');
        } else {
            throw new IllegalArgumentException("Invalid hex character: " + c);
        }

        result = result * 16 + digit;
    }

    return result;
}


public static int countWords(String sentence) {
    if (sentence == null || sentence.trim().isEmpty()) {
        return 0;
    }

    // Розбиваємо за одним або кількома пробілами
    String[] parts = sentence.trim().split("\\s+");
    return parts.length;
}



}