package com.java.practice.programming.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public  static  void main(String[] args){

        List<Integer> reversedList = reversByN(Arrays.asList(10,2,13,70,43,51,66,49,33,70),3);
        reversedList.forEach(System.out::println);
    }
    //10,2,13,70,43,51,66,49,33,70

    public static List<Integer> reversByN(List<Integer> a,int n){
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<a.size(); i=i+n){   //1st it:10,2,13 i=0 | 70,43,51 i=3 | 66,49,33 i=6 | 70 i=9
            if(i+(n-1)<=a.size()){
                for (int j=(i+(n-1));j>=i; j--){// j=2 13,j=1; j=1 2, j=0 10 | j=5 51,j=4 43,j=3 70 | j=8 33,j=7 49,j=6 66 | j=
                    list.add(a.get(j));
                }
            }
        }
        return list;
    }
}
