package com.example.SDJassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@RestController
public class SdJassignmentApplication
{
	@Autowired
	private AnimalDAO animalDAO;


	public static void main(String[] args)
	{
		SpringApplication.run(SdJassignmentApplication.class, args);
	}

	@GetMapping("/animals")
	public ResponseEntity<List<Animal>> getAllAnimals()
	{
		List<Animal> animals = animalDAO.getAllAnimals();
		return new ResponseEntity<List<Animal>>(animals , HttpStatus.OK);
	}

	@GetMapping("/animnals/{regNo}")
	public ResponseEntity<Animal> getAnimalByRegNo(@PathVariable int regNo)
	{
		Animal animal = animalDAO.getAnimalByRegNo(regNo);
		if(animal != null)
		{
			return new ResponseEntity<Animal>(animal , HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/animals/{date}")
	public ResponseEntity<Animal> getAnimalByDate(@PathVariable Date date)
	{
		Animal animal = animalDAO.getAnimalsByDate(date);
		if(animal != null)
		{
			return new ResponseEntity<Animal>(animal , HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/animals/{origin}")
	public ResponseEntity<Animal> getAnimalByOrigin(@PathVariable String origin)
	{
		Animal animal = animalDAO.getAnimalByOrigin(origin);
		if(animal != null)
		{
			return new ResponseEntity<Animal>(animal , HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/animals/{type}")
	public ResponseEntity<Animal> getAnimalByType(@PathVariable String animalType)
	{
		Animal animal = animalDAO.getAnimalByType(animalType);
		if(animal != null)
		{
			return new ResponseEntity<Animal>(animal , HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Animal>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/animals")
	public ResponseEntity<Void> registerAnimal(@RequestBody Animal animal)
	{
		animalDAO.registerAnimal(animal);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/animals/{regNO}")
	public ResponseEntity<Void> UpdateAnimal(@PathVariable int regNO , @RequestBody Animal animal)
	{
		Animal existingAnimal = animalDAO.getAnimalByRegNo(regNO);
		if (existingAnimal != null)
		{
			animal.setRegNo(regNO);
			animalDAO.updateAnimal(regNO , animal);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("animals/{regNO}")
	public ResponseEntity<Void> deleteUser(@PathVariable int regNO)
	{
		Animal existingAnimal = animalDAO.getAnimalByRegNo(regNO);
		if(existingAnimal != null)
		{
			animalDAO.deleteAnimal(regNO);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}


}
