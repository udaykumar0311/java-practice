package com.java.practice.records;

public class CarMain {
    public static void main(String[] args){
        //1.Regular Class
        Car car = new Car("24053220","Uday");
        System.out.println(car);
        System.out.println(car.getRegNumber());
        System.out.println(car.getOwner());

        //2.Using a record
        CarRecord carRecord = new CarRecord("2405JN6086","Uday");
        System.out.println(carRecord);
        System.out.println(carRecord.regNumber()); //slightly different accessor method names
        System.out.println(carRecord.owner());

        //3.Define an instance method; cannot define instance field
        System.out.println(carRecord.isNewCar());

        //4.Define a static field
        System.out.println(CarRecord.currentYear);

        //5.Define a static method
        CarRecord blankCar = CarRecord.createBlankCarRecord();
        System.out.println("blank owner: "+ blankCar.owner());
        System.out.println("blank regnumber: "+ blankCar.regNumber());

        //6.Define custom canonical constructor and compact constructor
        //7.Non-canonical record constructor must delegate to another constructor
        //8.Override the owner() accessor method.
        //9.Cannot define a subtype based on a record
        //10.Can implement an interface
        //11.When defining your record, you cannot extend from another type
    }
}
