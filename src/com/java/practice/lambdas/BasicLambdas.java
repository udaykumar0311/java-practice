package com.java.practice.lambdas;
@FunctionalInterface
interface I{
    void m();
}
public class BasicLambdas {
    public static void main(String[] args){
        I lambda1 = () -> System.out.println("My Basic Lambda");
        lambda1.m();
    }
}
