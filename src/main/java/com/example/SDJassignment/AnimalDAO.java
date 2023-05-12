package com.example.SDJassignment;

import com.example.SDJassignment.Animal;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.*;

@Repository
public class AnimalDAO
{
    private static Map<Integer , Animal> animals = new HashMap<>();
    private int cnt = 0;

    public List<Animal> getAllAnimals()
    {
        return new ArrayList<Animal>(animals.values());
    }

    public Animal getAnimalByRegNo(int regNo)
    {
        return animals.get(regNo);
    }

    public Animal getAnimalsByDate(Date date)
    {
        return animals.get(date);
    }

    public Animal getAnimalByOrigin(String origin)
    {
        return animals.get(origin);
    }

    public Animal getAnimalByType(String animalType)
    {
        return animals.get(animalType);
    }

    public void registerAnimal(Animal animal)
    {
        animal.setRegNo(++cnt);
        animals.put(animal.getRegNo() , animal);
    }

    public void updateAnimal(int regNo , Animal animal)
    {
        animal.setRegNo(regNo);
        animals.put(regNo , animal);
    }

    public void deleteAnimal(int regNo)
    {
        animals.remove(regNo);
    }


}
