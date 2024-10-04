package com.java.practice.records;
//regNumber and owner are known as 'components'
public record CarRecord(String regNumber, String owner)  implements I{ // No extends clause allowed for record
//    private final int age; //instance fields must be listed in constructor signature above
    //static instance field in record
    public static final String currentYear = "24";

    //Custom canonical constructor
    public CarRecord(String regNumber, String owner){
        if (regNumber.length() <= 4){
            throw new IllegalArgumentException();
        }
        this.regNumber=regNumber;
        this.owner=owner;
    }


    //Custom compact  constructor
    /*public CarRecord{
        if (regNumber.length() <= 4){
            throw new IllegalArgumentException();
        }
    }*/

    //Non-canonical record constrictor must delegate to another constructor
    /*public CarRecord(){
        //this("","");
    }*/

    //instance method in record
    public boolean isNewCar(){
        return regNumber.substring(0,2).equals(currentYear);
    }
    //static instance method in record
    public static CarRecord createBlankCarRecord(){
        return new CarRecord("     ","");
    }
    @Override
    public String owner(){
        return owner.toUpperCase();
    }
}

//class X extends CarRecord{} //9

interface I{} //10