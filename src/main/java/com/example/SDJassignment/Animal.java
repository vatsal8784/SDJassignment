package com.example.SDJassignment;

import java.nio.DoubleBuffer;
import java.util.Date;

public class Animal
{
    private int regNo;
    private String animalType;
    private String origin;
    private Date date;
    private Double weight;

    public Animal()
    {

    }

    public Animal(int regNo , String animalType , String origin , Date date , Double weight)
    {
        this.regNo = regNo;
        this.animalType = animalType;
        this.date = date;
        this.origin = origin;
        this.weight = weight;
    }

    public int getRegNo()
    {
        return regNo;
    }

    public void setRegNo(int regNo)
    {
        this.regNo = regNo;
    }

    public Double getWeight()
    {
        return weight;
    }

    public void setWeight(Double weight)
    {
        this.weight = weight;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getAnimalType()
    {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
