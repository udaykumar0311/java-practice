package com.java.practice.model;

public record Person(String name, Integer age) {}   // component list, name() and age() accessors

//record Player(Person person, Ability ability){}     // person() and ability() accessors
//record Doubles(Player player1, Player player2){}    // player1() and player2() accessors

//record Pair<T> (T x, T y){} // x() and y() accessors