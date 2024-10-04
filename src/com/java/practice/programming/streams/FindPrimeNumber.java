package com.java.practice.programming.streams;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//1- Write a Java Program to find whether a number is prime or not.
//Prime numbers are natural numbers that are divisible by only 1 and the number itself
public class FindPrimeNumber {

    public static void main(String[] args) {
        System.out.println(" Is Prime No : " + isPrimeByJava8(4));
    }
    private static boolean isPrimeByJava8(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        System.out.println(IntStream.rangeClosed(2, n / 2).summaryStatistics());
        boolean isPrime = IntStream.rangeClosed(2, n / 2).noneMatch(x -> n % x == 0);
        return isPrime;
    }
}
