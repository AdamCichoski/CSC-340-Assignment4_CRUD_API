package com.csc340.assignment4.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository to store queries for animals
 * @author Adam Cichoski
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    /**
     * Query to match species
     * Matches to any species containing the values in the species parameter
     * @param species
     * @return
     */
    @Query(value ="SELECT * FROM animal WHERE species LIKE %:species%", nativeQuery = true)
    List<Animal> getAnimalBySpecies(String species);

    /**
     * Query to match
     * Matches to any name containing the values in the name parameter
     * @param name
     * @return
     */
    @Query(value= "SELECT * FROM animal WHERE name LIKE %:name%", nativeQuery = true)
    List<Animal> getAnimalByName(String name);

}
