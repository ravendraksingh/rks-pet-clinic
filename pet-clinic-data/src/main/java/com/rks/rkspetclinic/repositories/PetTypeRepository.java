package com.rks.rkspetclinic.repositories;

import com.rks.rkspetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
