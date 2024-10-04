package com.java.practice.programming.streams;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIntQuest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 4,66, 1,72, 27, 224, 66, 3,25, 2, 46);
        //printSumOfAllNum(list);
        //printAverageOfAllNum(list);
        //printSquareFilterAverage(list);
        //printEvenAndOddNum(list);
        //printNumStartsWith2(list);
        //using set.add()
        //printDuplicateNumbers(list);
        //System.out.println(" Is prime num : " + isPrimeByJava8(5));
        //printMaxAndMinNum(list);
        //printSortedList(list);
        //printSecondHighLow(list);
        //printIsArmstrongNumberJava8(9800817);//1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817
        //printIsArmstrongNumber(371);
//        printIsPalindrome(16461);
        printDuplicateInString("aabbrrwwgtwfsghs");
        //printFibonacciSeries(9);
    }
    //14.The Fibonacci series is the sequence of numbers, where every number is the sum of the preceding two numbers.
    private static void printFibonacciSeries(int n) {
        Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] }).limit(n)
                .map(f -> f[0])
                .forEach(System.out::println);
    }
    //13.Write a program to print duplicate strings.
    private static void printDuplicateInString(String input) {
        //System.out.println((char) 100);
        List<Character> duplicateList= input.chars().mapToObj(x -> Character.toUpperCase((char) x))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() > 1L).map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println(duplicateList);
    }




    //12.A Palindromic number is a number (such as 16461) that remains the same when its digits are reversed.
    private static void printIsPalindrome(int n) {
        String value = String.valueOf(n);
        int len = value.length();
        boolean isPalindromeNumber = IntStream.range(0, len / 2)
                .allMatch(index -> value.charAt(index) == value.charAt(len - index - 1));
        System.out.println(STR." Is Palindrome : \{isPalindromeNumber}");
    }

    //11.Armstrong number is the number in any given number base, which forms the total of the same number,
    //when each of its digits is raised to the power of the number of digits in the number.
    private static void printIsArmstrongNumberJava8(int n) {
        int len = String.valueOf(n).length();
        int sum = String.valueOf(n).chars().map(ch -> Character.digit(ch, 10))
                .map(digit -> (int) Math.pow(digit, len))
                .sum();
        System.out.println(STR."Is Armstrong Number : \{sum == n}");
    }

    private static void printIsArmstrongNumber(int n) {
        int length = String.valueOf(n).length();
        int sum = 0;
        int temp = n;
        while (temp > 0) {
            int rem = temp % 10;
            sum += Math.pow(rem, length);
            temp = temp / 10;
        }
        System.out.println(STR."Is Armstrong Number : \{sum == n}");
    }

    //10.Print second highest and second lowest value
    private static void printSecondHighLow(List<Integer> list) {
        int secHighest = list.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
        int secLowest = list.stream().sorted().distinct().skip(1).findFirst().get();
        System.out.println(STR."Second highest: \{secHighest}\nSecond lowest: \{secLowest}");
    }

    //9.Print sorted list
    private static void printSortedList(List<Integer> list) {
        List<Integer> ascList= list.stream().sorted().collect(Collectors.toList());
        List<Integer> descList= list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(STR."Ascending list: \{ascList} \nDescending list: \{descList}");
    }

    //8.Print max and min numbers
    private static void printMaxAndMinNum(List<Integer> list) {
        int max = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
        int min = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println(STR."Max & Min numbers: \{max} & \{min}");
    }

    //7.Java Program to find whether a number is prime or not.
    //Prime numbers are natural numbers that are divisible by only 1 and the number itself
    private static boolean isPrimeByJava8(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        boolean isPrime = IntStream.rangeClosed(2, n / 2).noneMatch(x -> n % x == 0);
        return isPrime;
    }
    //6.Print duplicate numbers
    private static void printDuplicateNumbers(List<Integer> list) {
        Set<Integer> numbSet = new HashSet<>();
        list.stream().filter(val -> (!numbSet.add(val))).collect(Collectors.toSet()).forEach(System.out::println);

        //Using Collectors.groupingBy()
        list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue()>1).map(Map.Entry::getKey ).forEach(System.out::println);

        //Using Collections.frequency():
//        list.stream().filter(e->Collections.frequency(list,e)>1).collect(Collectors.toSet()).forEach(System.out::println);
    }
    //5.Print numbers starting with 2
    private static void printNumStartsWith2(List<Integer> list) {
        List<Integer> numStartsWith2 = list.stream().map(String::valueOf).filter(ele->ele.startsWith("2")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(STR."Numbers starting with 2: \{numStartsWith2}");
    }

    //4.Print even and ood numbers
    private static void printEvenAndOddNum(List<Integer> list) {
        List<Integer> evenNumbers = list.stream().filter(ele -> ele % 2 == 0).collect(Collectors.toList());
        System.out.println(STR."Even numbers: \{evenNumbers}");
        List<Integer> oddumbers = list.stream().filter(ele -> ele%2!=0).collect(Collectors.toList());
        System.out.println(STR."Odd numbers: \{oddumbers}");
    }

    //3.Print square of each number, filter numbers greater than 100 and print average of numbers
    private static void printSquareFilterAverage(List<Integer> list) {
        Double average = list.stream().map(a -> a*a).filter(ele -> ele > 200).mapToInt(e-> e).average().getAsDouble();
        System.out.println(STR."Average of numbers: \{average}");
    }

    // 2.Print average of all numbers
    private static void printAverageOfAllNum(List<Integer> list) {
//        List<Integer> list = Arrays.asList(1, 4, 2, 7, 4, 66, 3, 5, 2, 456, 66);
        Double average = list.stream().mapToInt(e->e).average().getAsDouble();
        System.out.println(STR."Average of numbers: \{average}");
    }
    //1.Print sum of all numbers
    private static void printSumOfAllNum(List<Integer> list) {
//        List<Integer> list = Arrays.asList(1, 4, 2, 7, 4, 66, 3, 5, 2, 456, 66);
        Optional<Integer> sum = list.stream().reduce((a, b)->a+b);
//        Integer sum = list.stream().mapToInt(e->e).sum();
        System.out.println(STR."Sum of number: \{sum.get()}");
    }
}
