package org.algorithm;

public class Palindrome {
    public static void main(String[] args) {
        String word = "Arriba la birra";

        boolean isPalindrome = isPalindrome(word);

        // print the result
        if (!isPalindrome) {
            System.out.println("No es un palíndromo");
        } else {
            System.out.println("Es un palíndromo");
        }
    }

    private static boolean isPalindrome(String word) {
        // Remove spaces and lowercase the letters
        String wordProcessed = word.toLowerCase().replaceAll("\\s+", "");

        boolean isPalindrome = true;
        int left = 0;
        int right = wordProcessed.length() - 1;

        // Loop to compare the chars
        while (left < right) {
            if (wordProcessed.charAt(left) != wordProcessed.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        return isPalindrome;
    }

}