package dev.belavirag.arrays;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        ex13();
    }

    public static void ex1() {
        int[] arr = {11, 23, 39};
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static void ex2() {
        int[] arr = {11, 23, 39};

        System.out.println(indexOfArray(arr, 11)); // 0
        System.out.println(indexOfArray(arr, 111)); // -1
    }

    public static int indexOfArray(int[] haystack, int needle) {
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] == needle) {
                return i;
            }
        }

        return -1;
    }

    public static void ex3() {
        String[] arr = {"Paris", "London", "New York", "Stockholm"};

        System.out.println("String array: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sort string array: " + Arrays.toString(arr));
    }

    public static void ex4() {
        int[] arr = {1, 15, 20};
        int[] copyOfArr = Arrays.copyOf(arr, arr.length);

        System.out.println("Elements from first array: " + Arrays.toString(arr));
        System.out.println("Elements from second array: " + Arrays.toString(copyOfArr));
    }

    public static void ex5() {
        String[][] arr = {{"France", "Paris"}, {"Sweden", "Stockholm"}};

        for (String[] firstArr : arr) {
            System.out.println(Arrays.toString(firstArr));
        }
    }

    public static void ex6() {
        int[] arr = {43, 5, 23, 17, 2, 14};
        double average = (double) Arrays.stream(arr).sum() / arr.length;

        System.out.printf("Average is : %.1f", average);
    }

    public static void ex7() {
        int[] arr = {1, 2, 4, 7, 9, 12};
        int[] oddArray = Arrays.stream(arr).filter(a -> a % 2 != 0).toArray();

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Odd Array: " + Arrays.toString(oddArray));
    }

    public static void ex8() {
        int[] arr = {20, 20, 40, 20, 30, 40, 50, 60, 50};
        int[] deduped = Arrays.stream(arr).distinct().toArray();

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Array without duplicate values: " + Arrays.toString(deduped));
    }

    public static void ex9() {
        int[] one = {1};
        int[] newArray = addToArray(one, 2);

        System.out.println(Arrays.toString(newArray));
    }

    public static int[] addToArray(int[] arr, int item) {
        int[] copyOfArray = Arrays.copyOf(arr, arr.length + 1);
        copyOfArray[copyOfArray.length - 1] = item;

        return copyOfArray;
    }

    public static void ex10() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {

                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    public static int getNumber(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input.trim());
            } catch (Exception e) {
                System.out.println("That's not a number! Try again");
            }
        }
    }

    public static void ex11() {
        int[] userInput = {};
        int currentUserInput = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Type the next number: ");
            final int input = getNumber(scanner);
            currentUserInput = input;

            if (Arrays.stream(userInput).anyMatch(a -> a == input)) {
                break;
            }
            userInput = addToArray(userInput, currentUserInput);
        }
        System.out.println("You have already typed " + currentUserInput + "!");

        int[] reversed = new int[userInput.length];
        for (int i = userInput.length - 1; i >= 0; i--) {
            reversed[userInput.length - i - 1] = userInput[i];
        }

        System.out.println("Reversed: " + Arrays.toString(reversed));
    }

    public static void ex12() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][i]);
        }
    }

    public static void ex13() {
        int[] randomArray = new int[10];
        Random random = new Random();
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(0, 100);
        }

        int[] odd = Arrays.stream(randomArray).filter(a -> a % 2 != 0).toArray();
        int[] even = Arrays.stream(randomArray).filter(a -> a % 2 == 0).toArray();

        int[] combined = IntStream.concat(Arrays.stream(odd), Arrays.stream(even)).toArray();
        System.out.println(Arrays.toString(combined));
    }
}