package com.rks.rkspetclinic.repositories;

import com.rks.rkspetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
