package com.java.practice.sealed_classes;


sealed interface Drivable permits Vehicle{

}
public sealed class Vehicle implements Drivable permits Car{
}

sealed class Car extends Vehicle permits Ford,Volvo{

}

final class Ford extends Car{

}

final class Volvo extends Car{

}

class Table {

}